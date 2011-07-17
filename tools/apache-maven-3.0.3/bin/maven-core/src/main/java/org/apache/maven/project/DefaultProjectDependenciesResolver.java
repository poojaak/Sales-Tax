package org.apache.maven.project;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.maven.RepositoryUtils;
import org.apache.maven.artifact.Artifact;
import org.apache.maven.model.Dependency;
import org.apache.maven.model.DependencyManagement;
import org.apache.maven.model.Exclusion;
import org.apache.maven.model.InputLocation;
import org.apache.maven.model.InputSource;
import org.codehaus.plexus.component.annotations.Component;
import org.codehaus.plexus.component.annotations.Requirement;
import org.codehaus.plexus.logging.Logger;
import org.sonatype.aether.RepositorySystem;
import org.sonatype.aether.RepositorySystemSession;
import org.sonatype.aether.RequestTrace;
import org.sonatype.aether.artifact.ArtifactTypeRegistry;
import org.sonatype.aether.collection.CollectRequest;
import org.sonatype.aether.collection.DependencyCollectionException;
import org.sonatype.aether.graph.DependencyFilter;
import org.sonatype.aether.graph.DependencyNode;
import org.sonatype.aether.graph.DependencyVisitor;
import org.sonatype.aether.resolution.ArtifactResult;
import org.sonatype.aether.resolution.DependencyRequest;
import org.sonatype.aether.util.DefaultRequestTrace;
import org.sonatype.aether.util.artifact.ArtifacIdUtils;
import org.sonatype.aether.util.artifact.ArtifactProperties;
import org.sonatype.aether.util.artifact.JavaScopes;

/**
 * @author Benjamin Bentmann
 */
@Component( role = ProjectDependenciesResolver.class )
public class DefaultProjectDependenciesResolver
    implements ProjectDependenciesResolver
{

    @Requirement
    private Logger logger;

    @Requirement
    private RepositorySystem repoSystem;

    public DependencyResolutionResult resolve( DependencyResolutionRequest request )
        throws DependencyResolutionException
    {
        RequestTrace trace = DefaultRequestTrace.newChild( null, request );

        DefaultDependencyResolutionResult result = new DefaultDependencyResolutionResult();

        MavenProject project = request.getMavenProject();
        RepositorySystemSession session = request.getRepositorySession();
        DependencyFilter filter = request.getResolutionFilter();

        ArtifactTypeRegistry stereotypes = session.getArtifactTypeRegistry();

        CollectRequest collect = new CollectRequest();
        collect.setRequestContext( "project" );
        collect.setRepositories( project.getRemoteProjectRepositories() );

        if ( project.getDependencyArtifacts() == null )
        {
            for ( Dependency dependency : project.getDependencies() )
            {
                collect.addDependency( RepositoryUtils.toDependency( dependency, stereotypes ) );
            }
        }
        else
        {
            Map<String, Dependency> dependencies = new HashMap<String, Dependency>();
            for ( Dependency dependency : project.getDependencies() )
            {
                String key = dependency.getManagementKey();
                dependencies.put( key, dependency );
            }
            for ( Artifact artifact : project.getDependencyArtifacts() )
            {
                String key = artifact.getDependencyConflictId();
                Dependency dependency = dependencies.get( key );
                Collection<Exclusion> exclusions = dependency != null ? dependency.getExclusions() : null;
                org.sonatype.aether.graph.Dependency dep = RepositoryUtils.toDependency( artifact, exclusions );
                if ( !JavaScopes.SYSTEM.equals( dep.getScope() ) && dep.getArtifact().getFile() != null )
                {
                    // enable re-resolution
                    org.sonatype.aether.artifact.Artifact art = dep.getArtifact();
                    art = art.setFile( null ).setVersion( art.getBaseVersion() );
                    dep = dep.setArtifact( art );
                }
                collect.addDependency( dep );
            }
        }

        DependencyManagement depMngt = project.getDependencyManagement();
        if ( depMngt != null )
        {
            for ( Dependency dependency : depMngt.getDependencies() )
            {
                collect.addManagedDependency( RepositoryUtils.toDependency( dependency, stereotypes ) );
            }
        }

        DependencyRequest depRequest = new DependencyRequest( collect, filter );
        depRequest.setTrace( trace );

        DependencyNode node;
        try
        {
            collect.setTrace( DefaultRequestTrace.newChild( trace, depRequest ) );
            node = repoSystem.collectDependencies( session, collect ).getRoot();
            result.setDependencyGraph( node );
        }
        catch ( DependencyCollectionException e )
        {
            result.setDependencyGraph( e.getResult().getRoot() );
            result.setCollectionErrors( e.getResult().getExceptions() );

            throw new DependencyResolutionException( result, "Could not resolve dependencies for project "
                + project.getId() + ": " + e.getMessage(), e );
        }

        depRequest.setRoot( node );

        if ( logger.isWarnEnabled() )
        {
            for ( DependencyNode child : node.getChildren() )
            {
                if ( !child.getRelocations().isEmpty() )
                {
                    logger.warn( "The artifact " + child.getRelocations().get( 0 ) + " has been relocated to "
                        + child.getDependency().getArtifact() );
                }
            }
        }

        if ( logger.isDebugEnabled() )
        {
            node.accept( new GraphLogger( project ) );
        }

        try
        {
            process( result, repoSystem.resolveDependencies( session, depRequest ).getArtifactResults() );
        }
        catch ( org.sonatype.aether.resolution.DependencyResolutionException e )
        {
            process( result, e.getResult().getArtifactResults() );

            throw new DependencyResolutionException( result, "Could not resolve dependencies for project "
                + project.getId() + ": " + e.getMessage(), e );
        }

        return result;
    }

    private void process( DefaultDependencyResolutionResult result, Collection<ArtifactResult> results )
    {
        for ( ArtifactResult ar : results )
        {
            DependencyNode node = ar.getRequest().getDependencyNode();
            if ( ar.isResolved() )
            {
                result.addResolvedDependency( node.getDependency() );
            }
            else
            {
                result.setResolutionErrors( node.getDependency(), ar.getExceptions() );
            }
        }
    }

    class GraphLogger
        implements DependencyVisitor
    {

        private final MavenProject project;

        private String indent = "";

        private Map<String, Dependency> managed;

        public GraphLogger( MavenProject project )
        {
            this.project = project;
        }

        public boolean visitEnter( DependencyNode node )
        {
            StringBuilder buffer = new StringBuilder( 128 );
            buffer.append( indent );
            org.sonatype.aether.graph.Dependency dep = node.getDependency();
            if ( dep != null )
            {
                org.sonatype.aether.artifact.Artifact art = dep.getArtifact();

                buffer.append( art );
                buffer.append( ':' ).append( dep.getScope() );

                if ( node.getPremanagedScope() != null && !node.getPremanagedScope().equals( dep.getScope() ) )
                {
                    buffer.append( " (scope managed from " ).append( node.getPremanagedScope() );
                    appendManagementSource( buffer, art, "scope" );
                    buffer.append( ")" );
                }

                if ( node.getPremanagedVersion() != null && !node.getPremanagedVersion().equals( art.getVersion() ) )
                {
                    buffer.append( " (version managed from " ).append( node.getPremanagedVersion() );
                    appendManagementSource( buffer, art, "version" );
                    buffer.append( ")" );
                }
            }
            else
            {
                buffer.append( project.getGroupId() );
                buffer.append( ':' ).append( project.getArtifactId() );
                buffer.append( ':' ).append( project.getPackaging() );
                buffer.append( ':' ).append( project.getVersion() );
            }

            logger.debug( buffer.toString() );
            indent += "   ";
            return true;
        }

        public boolean visitLeave( DependencyNode node )
        {
            indent = indent.substring( 0, indent.length() - 3 );
            return true;
        }

        private void appendManagementSource( StringBuilder buffer, org.sonatype.aether.artifact.Artifact artifact,
                                             String field )
        {
            if ( managed == null )
            {
                managed = new HashMap<String, Dependency>();
                if ( project.getDependencyManagement() != null )
                {
                    for ( Dependency dep : project.getDependencyManagement().getDependencies() )
                    {
                        managed.put( dep.getManagementKey(), dep );
                    }
                }
            }

            String key =
                ArtifacIdUtils.toVersionlessId( artifact.getGroupId(), artifact.getArtifactId(),
                                                artifact.getProperty( ArtifactProperties.TYPE, "jar" ),
                                                artifact.getClassifier() );

            Dependency dependency = managed.get( key );
            if ( dependency != null )
            {
                InputLocation location = dependency.getLocation( field );
                if ( location != null )
                {
                    InputSource source = location.getSource();
                    if ( source != null )
                    {
                        buffer.append( " by " ).append( source.getModelId() );
                    }
                }
            }
        }

    }

}
