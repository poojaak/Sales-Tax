/*
 =================== DO NOT EDIT THIS FILE ====================
 Generated by Modello 1.4.1 on 2011-06-25 18:03:34,
 any modifications will be overwritten.
 ==============================================================
 */

package org.apache.maven.model;

/**
 * This is the file specification used to activate the profile. The
 * missing value
 *         will be the location of a file that needs to exist, and
 * if it doesn't the profile will be
 *         activated. On the other hand exists will test for the
 * existence of the file and if it is
 *         there the profile will be activated.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings( "all" )
public class ActivationFile
    implements java.io.Serializable, java.lang.Cloneable, org.apache.maven.model.InputLocationTracker
{

      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The name of the file that must be missing to activate the
     *           profile.
     */
    private String missing;

    /**
     * The name of the file that must exist to activate the profile.
     */
    private String exists;

    /**
     * Field locations.
     */
    private java.util.Map<Object, InputLocation> locations;


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method clone.
     * 
     * @return ActivationFile
     */
    public ActivationFile clone()
    {
        try
        {
            ActivationFile copy = (ActivationFile) super.clone();

            if ( copy.locations != null )
            {
                copy.locations = new java.util.LinkedHashMap( copy.locations );
            }

            return copy;
        }
        catch ( java.lang.Exception ex )
        {
            throw (java.lang.RuntimeException) new java.lang.UnsupportedOperationException( getClass().getName()
                + " does not support clone()" ).initCause( ex );
        }
    } //-- ActivationFile clone()

    /**
     * Get the name of the file that must exist to activate the
     * profile.
     * 
     * @return String
     */
    public String getExists()
    {
        return this.exists;
    } //-- String getExists()

    /**
     * 
     * 
     * @param key
     * @return InputLocation
     */
    public InputLocation getLocation( Object key )
    {
        return ( locations != null ) ? locations.get( key ) : null;
    } //-- InputLocation getLocation( Object )

    /**
     * Get the name of the file that must be missing to activate
     * the
     *           profile.
     * 
     * @return String
     */
    public String getMissing()
    {
        return this.missing;
    } //-- String getMissing()

    /**
     * Set the name of the file that must exist to activate the
     * profile.
     * 
     * @param exists
     */
    public void setExists( String exists )
    {
        this.exists = exists;
    } //-- void setExists( String )

    /**
     * 
     * 
     * @param key
     * @param location
     */
    public void setLocation( Object key, InputLocation location )
    {
        if ( location != null )
        {
            if ( this.locations == null )
            {
                this.locations = new java.util.LinkedHashMap<Object, InputLocation>();
            }
            this.locations.put( key, location );
        }
    } //-- void setLocation( Object, InputLocation )

    /**
     * Set the name of the file that must be missing to activate
     * the
     *           profile.
     * 
     * @param missing
     */
    public void setMissing( String missing )
    {
        this.missing = missing;
    } //-- void setMissing( String )

}
