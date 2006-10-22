/*
 * VehicleTypeTO.java
 *
 * Created on 21 October 2006, 00:13
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package assign2.entities.to;

/**
 *
 * @author Gerard Gigliotti
 */
public class VehicleTypeTO
{
    private String code;
    private String description;
    private Integer seats;
    
    /** Creates a new instance of VehicleTypeTO */
    public VehicleTypeTO()
    {
    }

    public VehicleTypeTO(String code,String description,Integer seats)
    {
        this.code = code;
        this.description = description;
        this.seats = seats;
    }
    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Integer getSeats()
    {
        return seats;
    }

    public void setSeats(Integer seats)
    {
        this.seats = seats;
    }
    
    public String toString()
    {
        return description;
    }
}
