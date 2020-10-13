/*
 =================== DO NOT EDIT THIS FILE ====================
 Generated by Modello 1.4.1 on 2011-06-25 18:03:45,
 any modifications will be overwritten.
 ==============================================================
 */

package org.apache.maven.plugin.lifecycle;

/**
 * A phase mapping definition.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings( "all" )
public class Phase
    implements java.io.Serializable
{

      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The ID of this phase, eg <code>generate-sources</code>.
     */
    private String id;

    /**
     * Field executions.
     */
    private java.util.List<Execution> executions;

    /**
     * Configuration to pass to all goals run in this phase.
     */
    private Object configuration;


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addExecution.
     * 
     * @param execution
     */
    public void addExecution( Execution execution )
    {
        getExecutions().add( execution );
    } //-- void addExecution( Execution )

    /**
     * Get configuration to pass to all goals run in this phase.
     * 
     * @return Object
     */
    public Object getConfiguration()
    {
        return this.configuration;
    } //-- Object getConfiguration()

    /**
     * Method getExecutions.
     * 
     * @return List
     */
    public java.util.List<Execution> getExecutions()
    {
        if ( this.executions == null )
        {
            this.executions = new java.util.ArrayList<Execution>();
        }

        return this.executions;
    } //-- java.util.List<Execution> getExecutions()

    /**
     * Get the ID of this phase, eg <code>generate-sources</code>.
     * 
     * @return String
     */
    public String getId()
    {
        return this.id;
    } //-- String getId()

    /**
     * Method removeExecution.
     * 
     * @param execution
     */
    public void removeExecution( Execution execution )
    {
        getExecutions().remove( execution );
    } //-- void removeExecution( Execution )

    /**
     * Set configuration to pass to all goals run in this phase.
     * 
     * @param configuration
     */
    public void setConfiguration( Object configuration )
    {
        this.configuration = configuration;
    } //-- void setConfiguration( Object )

    /**
     * Set the goals to execute within the phase.
     * 
     * @param executions
     */
    public void setExecutions( java.util.List<Execution> executions )
    {
        this.executions = executions;
    } //-- void setExecutions( java.util.List )

    /**
     * Set the ID of this phase, eg <code>generate-sources</code>.
     * 
     * @param id
     */
    public void setId( String id )
    {
        this.id = id;
    } //-- void setId( String )

}