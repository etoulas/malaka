/*
 * VehicleTO.java
 *
 * Created on 21 October 2006, 00:10
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package assign2.entities.to;

/**
 *
 * @author Gerard Gigliotti
 */
public class VehicleTO
{
    private Long id;
    private String colour;
    private String name;
    private VehicleTypeTO type;
    private VehicleLicenseTO license;
    private Integer year;
    /** Creates a new instance of VehicleTO */
    public VehicleTO()
    {
    }
    
    public VehicleTO(Long id,String colour,VehicleTypeTO type,VehicleLicenseTO license, Integer year)
    {
       this.setId(id);
       this.setColour(colour);
       this.setType(type);
       this.setLicense(license);
       this.setYear(year);
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getColour()
    {
        return colour;
    }

    public void setColour(String colour)
    {
        this.colour = colour;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public VehicleTypeTO getType()
    {
        return type;
    }

    public void setType(VehicleTypeTO type)
    {
        this.type = type;
    }

    public VehicleLicenseTO getLicense()
    {
        return license;
    }

    public void setLicense(VehicleLicenseTO license)
    {
        this.license = license;
    }

    public Integer getYear()
    {
        return year;
    }

    public void setYear(Integer year)
    {
        this.year = year;
    }
    
}
