/*
 =================== DO NOT EDIT THIS FILE ====================
 Generated by Modello 1.4.1 on 2011-06-25 18:03:45,
 any modifications will be overwritten.
 ==============================================================
 */

package org.apache.maven.plugin.lifecycle;

/**
 * 
 *         A custom lifecycle mapping definition.
 *       
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings( "all" )
public class Lifecycle
    implements java.io.Serializable
{

      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The ID of this lifecycle, for identification in the mojo
     * descriptor.
     */
    private String id;

    /**
     * Field phases.
     */
    private java.util.List<Phase> phases;


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addPhase.
     * 
     * @param phase
     */
    public void addPhase( Phase phase )
    {
        getPhases().add( phase );
    } //-- void addPhase( Phase )

    /**
     * Get the ID of this lifecycle, for identification in the mojo
     * descriptor.
     * 
     * @return String
     */
    public String getId()
    {
        return this.id;
    } //-- String getId()

    /**
     * Method getPhases.
     * 
     * @return List
     */
    public java.util.List<Phase> getPhases()
    {
        if ( this.phases == null )
        {
            this.phases = new java.util.ArrayList<Phase>();
        }

        return this.phases;
    } //-- java.util.List<Phase> getPhases()

    /**
     * Method removePhase.
     * 
     * @param phase
     */
    public void removePhase( Phase phase )
    {
        getPhases().remove( phase );
    } //-- void removePhase( Phase )

    /**
     * Set the ID of this lifecycle, for identification in the mojo
     * descriptor.
     * 
     * @param id
     */
    public void setId( String id )
    {
        this.id = id;
    } //-- void setId( String )

    /**
     * Set the phase mappings for this lifecycle.
     * 
     * @param phases
     */
    public void setPhases( java.util.List<Phase> phases )
    {
        this.phases = phases;
    } //-- void setPhases( java.util.List )

}
