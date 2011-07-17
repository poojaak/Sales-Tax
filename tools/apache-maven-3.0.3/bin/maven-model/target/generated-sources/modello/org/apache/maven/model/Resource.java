/*
 =================== DO NOT EDIT THIS FILE ====================
 Generated by Modello 1.4.1 on 2011-06-25 18:03:34,
 any modifications will be overwritten.
 ==============================================================
 */

package org.apache.maven.model;

/**
 * This element describes all of the classpath resources associated
 * with a project
 *         or unit tests.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings( "all" )
public class Resource
    extends FileSet
    implements java.io.Serializable, java.lang.Cloneable
{

      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * 
     *             
     *             Describe the resource target path. The path is
     * relative to the target/classes
     *             directory (i.e.
     * <code>${project.build.outputDirectory}</code>).
     *             For example, if you want that resource to appear
     * in a specific package
     *             (<code>org.apache.maven.messages</code>), you
     * must specify this
     *             element with this value:
     * <code>org/apache/maven/messages</code>.
     *             This is not required if you simply put the
     * resources in that directory
     *             structure at the source, however.
     *             
     *           
     */
    private String targetPath;

    /**
     * 
     *             
     *             Whether resources are filtered to replace tokens
     * with parameterised values or not.
     *             The values are taken from the
     * <code>properties</code> element and from the
     *             properties in the files listed in the
     * <code>filters</code> element. Note: While the type
     *             of this field is <code>String</code> for
     * technical reasons, the semantic type is actually
     *             <code>Boolean</code>. Default value is
     * <code>false</code>.
     *             
     *           
     */
    private String filtering;

    /**
     * 
     *             
     *             FOR INTERNAL USE ONLY. This is a unique
     * identifier assigned to each
     *             resource to allow Maven to merge changes to this
     * resource that take
     *             place during the execution of a plugin. This
     * field must be managed
     *             by the generated parser and formatter classes in
     * order to allow it
     *             to survive model interpolation.
     *             
     *           
     */
    private String mergeId;


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method clone.
     * 
     * @return Resource
     */
    public Resource clone()
    {
        try
        {
            Resource copy = (Resource) super.clone();

            return copy;
        }
        catch ( java.lang.Exception ex )
        {
            throw (java.lang.RuntimeException) new java.lang.UnsupportedOperationException( getClass().getName()
                + " does not support clone()" ).initCause( ex );
        }
    } //-- Resource clone()

    /**
     * Get whether resources are filtered to replace tokens with
     * parameterised values or not.
     *             The values are taken from the
     * <code>properties</code> element and from the
     *             properties in the files listed in the
     * <code>filters</code> element. Note: While the type
     *             of this field is <code>String</code> for
     * technical reasons, the semantic type is actually
     *             <code>Boolean</code>. Default value is
     * <code>false</code>.
     * 
     * @return String
     */
    public String getFiltering()
    {
        return this.filtering;
    } //-- String getFiltering()

    /**
     * Get fOR INTERNAL USE ONLY. This is a unique identifier
     * assigned to each
     *             resource to allow Maven to merge changes to this
     * resource that take
     *             place during the execution of a plugin. This
     * field must be managed
     *             by the generated parser and formatter classes in
     * order to allow it
     *             to survive model interpolation.
     * 
     * @return String
     */
    public String getMergeId()
    {
        return this.mergeId;
    } //-- String getMergeId()

    /**
     * Get describe the resource target path. The path is relative
     * to the target/classes
     *             directory (i.e.
     * <code>${project.build.outputDirectory}</code>).
     *             For example, if you want that resource to appear
     * in a specific package
     *             (<code>org.apache.maven.messages</code>), you
     * must specify this
     *             element with this value:
     * <code>org/apache/maven/messages</code>.
     *             This is not required if you simply put the
     * resources in that directory
     *             structure at the source, however.
     * 
     * @return String
     */
    public String getTargetPath()
    {
        return this.targetPath;
    } //-- String getTargetPath()

    /**
     * Set whether resources are filtered to replace tokens with
     * parameterised values or not.
     *             The values are taken from the
     * <code>properties</code> element and from the
     *             properties in the files listed in the
     * <code>filters</code> element. Note: While the type
     *             of this field is <code>String</code> for
     * technical reasons, the semantic type is actually
     *             <code>Boolean</code>. Default value is
     * <code>false</code>.
     * 
     * @param filtering
     */
    public void setFiltering( String filtering )
    {
        this.filtering = filtering;
    } //-- void setFiltering( String )

    /**
     * Set fOR INTERNAL USE ONLY. This is a unique identifier
     * assigned to each
     *             resource to allow Maven to merge changes to this
     * resource that take
     *             place during the execution of a plugin. This
     * field must be managed
     *             by the generated parser and formatter classes in
     * order to allow it
     *             to survive model interpolation.
     * 
     * @param mergeId
     */
    public void setMergeId( String mergeId )
    {
        this.mergeId = mergeId;
    } //-- void setMergeId( String )

    /**
     * Set describe the resource target path. The path is relative
     * to the target/classes
     *             directory (i.e.
     * <code>${project.build.outputDirectory}</code>).
     *             For example, if you want that resource to appear
     * in a specific package
     *             (<code>org.apache.maven.messages</code>), you
     * must specify this
     *             element with this value:
     * <code>org/apache/maven/messages</code>.
     *             This is not required if you simply put the
     * resources in that directory
     *             structure at the source, however.
     * 
     * @param targetPath
     */
    public void setTargetPath( String targetPath )
    {
        this.targetPath = targetPath;
    } //-- void setTargetPath( String )

    
            
    private static int mergeIdCounter = 0;

    public void initMergeId()
    {
        if ( getMergeId() == null )
        {
            setMergeId( "resource-" + (mergeIdCounter++) );
        }
    }

    public boolean isFiltering()
    {
        return ( filtering != null ) ? Boolean.parseBoolean( filtering ) : false;
    }

    public void setFiltering( boolean filtering )
    {
        this.filtering = String.valueOf( filtering );
    }

    /**
     * @see java.lang.Object#toString()
     */
    public String toString()
    {
        return "Resource {targetPath: " + getTargetPath() + ", filtering: " + isFiltering() + ", " + super.toString() + "}";
    }
            
          
}
