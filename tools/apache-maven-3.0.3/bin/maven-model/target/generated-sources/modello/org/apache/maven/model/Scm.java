/*
 =================== DO NOT EDIT THIS FILE ====================
 Generated by Modello 1.4.1 on 2011-06-25 18:03:34,
 any modifications will be overwritten.
 ==============================================================
 */

package org.apache.maven.model;

/**
 * 
 *         
 *         The <code>&lt;scm&gt;</code> element contains
 * informations required to the SCM
 *         (Source Control Management) of the project.
 *         
 *       
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings( "all" )
public class Scm
    implements java.io.Serializable, java.lang.Cloneable, org.apache.maven.model.InputLocationTracker
{

      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * 
     *             
     *             The source control management system URL
     *             that describes the repository and how to connect
     * to the
     *             repository. For more information, see the
     *             <a
     * href="http://maven.apache.org/scm/scm-url-format.html">URL
     * format</a>
     *             and <a
     * href="http://maven.apache.org/scm/scms-overview.html">list
     * of supported SCMs</a>.
     *             This connection is read-only.
     *             
     *           
     */
    private String connection;

    /**
     * 
     *             
     *             Just like <code>connection</code>, but for
     * developers, i.e. this scm connection
     *             will not be read only.
     *             
     *           
     */
    private String developerConnection;

    /**
     * The tag of current code. By default, it's set to HEAD during
     * development.
     */
    private String tag = "HEAD";

    /**
     * The URL to the project's browsable SCM repository, such as
     * ViewVC or Fisheye.
     */
    private String url;

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
     * @return Scm
     */
    public Scm clone()
    {
        try
        {
            Scm copy = (Scm) super.clone();

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
    } //-- Scm clone()

    /**
     * Get the source control management system URL
     *             that describes the repository and how to connect
     * to the
     *             repository. For more information, see the
     *             <a
     * href="http://maven.apache.org/scm/scm-url-format.html">URL
     * format</a>
     *             and <a
     * href="http://maven.apache.org/scm/scms-overview.html">list
     * of supported SCMs</a>.
     *             This connection is read-only.
     * 
     * @return String
     */
    public String getConnection()
    {
        return this.connection;
    } //-- String getConnection()

    /**
     * Get just like <code>connection</code>, but for developers,
     * i.e. this scm connection
     *             will not be read only.
     * 
     * @return String
     */
    public String getDeveloperConnection()
    {
        return this.developerConnection;
    } //-- String getDeveloperConnection()

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
     * Get the tag of current code. By default, it's set to HEAD
     * during development.
     * 
     * @return String
     */
    public String getTag()
    {
        return this.tag;
    } //-- String getTag()

    /**
     * Get the URL to the project's browsable SCM repository, such
     * as ViewVC or Fisheye.
     * 
     * @return String
     */
    public String getUrl()
    {
        return this.url;
    } //-- String getUrl()

    /**
     * Set the source control management system URL
     *             that describes the repository and how to connect
     * to the
     *             repository. For more information, see the
     *             <a
     * href="http://maven.apache.org/scm/scm-url-format.html">URL
     * format</a>
     *             and <a
     * href="http://maven.apache.org/scm/scms-overview.html">list
     * of supported SCMs</a>.
     *             This connection is read-only.
     * 
     * @param connection
     */
    public void setConnection( String connection )
    {
        this.connection = connection;
    } //-- void setConnection( String )

    /**
     * Set just like <code>connection</code>, but for developers,
     * i.e. this scm connection
     *             will not be read only.
     * 
     * @param developerConnection
     */
    public void setDeveloperConnection( String developerConnection )
    {
        this.developerConnection = developerConnection;
    } //-- void setDeveloperConnection( String )

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
     * Set the tag of current code. By default, it's set to HEAD
     * during development.
     * 
     * @param tag
     */
    public void setTag( String tag )
    {
        this.tag = tag;
    } //-- void setTag( String )

    /**
     * Set the URL to the project's browsable SCM repository, such
     * as ViewVC or Fisheye.
     * 
     * @param url
     */
    public void setUrl( String url )
    {
        this.url = url;
    } //-- void setUrl( String )

}
