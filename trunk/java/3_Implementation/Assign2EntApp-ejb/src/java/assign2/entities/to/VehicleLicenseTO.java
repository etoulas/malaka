/*
 * VehicleLicenseTO.java
 *
 * Created on 21 October 2006, 00:13
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package assign2.entities.to;

import java.io.Serializable;

/**
 *
 * @author Gerard Gigliotti
 */
public class VehicleLicenseTO implements Serializable
{
    private Long id;
    private String description;
    /** Creates a new instance of VehicleLicenseTO */
    public VehicleLicenseTO()
    {
    }
    
    public VehicleLicenseTO(Long id, String description)
    {
        this.id = id;
        this.description = description;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
    
    public String toString()
    {
        return description;
    }
}
