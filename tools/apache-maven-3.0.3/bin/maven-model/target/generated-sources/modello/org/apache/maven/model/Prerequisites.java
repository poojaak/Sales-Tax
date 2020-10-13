/*
 =================== DO NOT EDIT THIS FILE ====================
 Generated by Modello 1.4.1 on 2011-06-25 18:03:34,
 any modifications will be overwritten.
 ==============================================================
 */

package org.apache.maven.model;

/**
 * Describes the prerequisites a project can have.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings( "all" )
public class Prerequisites
    implements java.io.Serializable, java.lang.Cloneable, org.apache.maven.model.InputLocationTracker
{

      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The minimum version of Maven required to build the project,
     * or to use this
     *             plugin.
     */
    private String maven = "2.0";

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
     * @return Prerequisites
     */
    public Prerequisites clone()
    {
        try
        {
            Prerequisites copy = (Prerequisites) super.clone();

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
    } //-- Prerequisites clone()

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
     * Get the minimum version of Maven required to build the
     * project, or to use this
     *             plugin.
     * 
     * @return String
     */
    public String getMaven()
    {
        return this.maven;
    } //-- String getMaven()

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
     * Set the minimum version of Maven required to build the
     * project, or to use this
     *             plugin.
     * 
     * @param maven
     */
    public void setMaven( String maven )
    {
        this.maven = maven;
    } //-- void setMaven( String )

}