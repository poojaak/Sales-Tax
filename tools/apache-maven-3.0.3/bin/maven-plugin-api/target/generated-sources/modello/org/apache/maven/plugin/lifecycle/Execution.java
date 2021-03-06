/*
 =================== DO NOT EDIT THIS FILE ====================
 Generated by Modello 1.4.1 on 2011-06-25 18:03:45,
 any modifications will be overwritten.
 ==============================================================
 */

package org.apache.maven.plugin.lifecycle;

/**
 * A set of goals to execute.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings( "all" )
public class Execution
    implements java.io.Serializable
{

      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Configuration to pass to the goals.
     */
    private Object configuration;

    /**
     * Field goals.
     */
    private java.util.List<String> goals;


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addGoal.
     * 
     * @param string
     */
    public void addGoal( String string )
    {
        getGoals().add( string );
    } //-- void addGoal( String )

    /**
     * Get configuration to pass to the goals.
     * 
     * @return Object
     */
    public Object getConfiguration()
    {
        return this.configuration;
    } //-- Object getConfiguration()

    /**
     * Method getGoals.
     * 
     * @return List
     */
    public java.util.List<String> getGoals()
    {
        if ( this.goals == null )
        {
            this.goals = new java.util.ArrayList<String>();
        }

        return this.goals;
    } //-- java.util.List<String> getGoals()

    /**
     * Method removeGoal.
     * 
     * @param string
     */
    public void removeGoal( String string )
    {
        getGoals().remove( string );
    } //-- void removeGoal( String )

    /**
     * Set configuration to pass to the goals.
     * 
     * @param configuration
     */
    public void setConfiguration( Object configuration )
    {
        this.configuration = configuration;
    } //-- void setConfiguration( Object )

    /**
     * Set the goals to execute.
     * 
     * @param goals
     */
    public void setGoals( java.util.List<String> goals )
    {
        this.goals = goals;
    } //-- void setGoals( java.util.List )

}
