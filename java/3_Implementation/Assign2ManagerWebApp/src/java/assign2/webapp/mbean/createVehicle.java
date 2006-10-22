/*
 * createVehicle.java
 *
 * Created on 20 October 2006, 23:58
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package assign2.webapp.mbean;

import assign2.entities.to.VehicleLicenseTO;
import assign2.entities.to.VehicleTO;
import assign2.entities.to.VehicleTypeTO;
import assign2.session.VehicleManagerRemote;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.model.SelectItem;

/**
 *
 * @author Gerard Gigliotti
 */
public class createVehicle
{
    @EJB
    VehicleManagerRemote vm;
    
    /*Values for creating new vehicles*/     
    private Long id;
    private String colour;
    private String name;
    private String VehicleTypeCode;
    private Long VehicleLicenseID;
    private Integer year;
      
    /*Adding vehicle to vehicle manager */
    public void addVehicle()
    {
        VehicleTO to = new VehicleTO();
        to.setColour(colour);
        to.setName(name);
        to.setLicense(vm.getVehicleLicenseTO(VehicleLicenseID));
        to.setType(vm.getVehicleTypeTO(VehicleTypeCode));
        to.setYear(year);
        vm.createVehicle(to);      
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

    public Integer getYear()
    {
        return year;
    }

    public void setYear(Integer year)
    {
        this.year = year;
    }

    private List<VehicleTypeTO> getTypeList()
    {
         /*Values for populating form */
        List<VehicleTypeTO> typeList = vm.getAllVehicleTypeTOs();
        return typeList;  
    }
    
    public List<SelectItem> getTypeSelectItemList()
    {
        List<SelectItem> typeSelectItem = new ArrayList();
        for (VehicleTypeTO vt : getTypeList())
        {
            SelectItem si = new SelectItem(vt.getCode(),vt.getDescription());
            typeSelectItem.add(si);
        }
        return typeSelectItem;
    }

    private List<VehicleLicenseTO> getLicenseList()
    {
        /*Values for populating form */
        List<VehicleLicenseTO> licenseList = vm.getAllVehicleLicenseTOs();
        return licenseList;
    }
    
    public List<SelectItem> getlicenseSelectItemList()
    {
        List<SelectItem> licenseSelectItem = new ArrayList();
        for (VehicleLicenseTO vt : getLicenseList())
        {
            SelectItem si = new SelectItem(vt.getId(),vt.getDescription());
            licenseSelectItem.add(si);
        }
        return licenseSelectItem;
    }

    public String getVehicleTypeCode() {
        return VehicleTypeCode;
    }

    public void setVehicleTypeCode(String VehicleTypeCode) {
        this.VehicleTypeCode = VehicleTypeCode;
    }

    public Long getVehicleLicenseID() {
        return VehicleLicenseID;
    }

    public void setVehicleLicenseID(Long VehicleLicenseID) {
        this.VehicleLicenseID = VehicleLicenseID;
    }
    
}
