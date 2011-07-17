/*
 =================== DO NOT EDIT THIS FILE ====================
 Generated by Modello 1.4.1 on 2011-06-25 18:03:34,
 any modifications will be overwritten.
 ==============================================================
 */

package org.apache.maven.model;

/**
 * A repository contains the information needed for establishing
 * connections with
 *         remote repository.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings( "all" )
public class Repository
    extends RepositoryBase
    implements java.io.Serializable, java.lang.Cloneable
{

      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * How to handle downloading of releases from this repository.
     */
    private RepositoryPolicy releases;

    /**
     * How to handle downloading of snapshots from this repository.
     */
    private RepositoryPolicy snapshots;


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method clone.
     * 
     * @return Repository
     */
    public Repository clone()
    {
        try
        {
            Repository copy = (Repository) super.clone();

            if ( this.releases != null )
            {
                copy.releases = (RepositoryPolicy) this.releases.clone();
            }

            if ( this.snapshots != null )
            {
                copy.snapshots = (RepositoryPolicy) this.snapshots.clone();
            }

            return copy;
        }
        catch ( java.lang.Exception ex )
        {
            throw (java.lang.RuntimeException) new java.lang.UnsupportedOperationException( getClass().getName()
                + " does not support clone()" ).initCause( ex );
        }
    } //-- Repository clone()

    /**
     * Get how to handle downloading of releases from this
     * repository.
     * 
     * @return RepositoryPolicy
     */
    public RepositoryPolicy getReleases()
    {
        return this.releases;
    } //-- RepositoryPolicy getReleases()

    /**
     * Get how to handle downloading of snapshots from this
     * repository.
     * 
     * @return RepositoryPolicy
     */
    public RepositoryPolicy getSnapshots()
    {
        return this.snapshots;
    } //-- RepositoryPolicy getSnapshots()

    /**
     * Set how to handle downloading of releases from this
     * repository.
     * 
     * @param releases
     */
    public void setReleases( RepositoryPolicy releases )
    {
        this.releases = releases;
    } //-- void setReleases( RepositoryPolicy )

    /**
     * Set how to handle downloading of snapshots from this
     * repository.
     * 
     * @param snapshots
     */
    public void setSnapshots( RepositoryPolicy snapshots )
    {
        this.snapshots = snapshots;
    } //-- void setSnapshots( RepositoryPolicy )

}
