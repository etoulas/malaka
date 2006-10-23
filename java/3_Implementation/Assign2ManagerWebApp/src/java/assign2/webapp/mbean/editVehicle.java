/*
 * editVehicle.java
 *
 * Created on 22 October 2006, 21:43
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package assign2.webapp.mbean;

import assign2.entities.to.VehicleLicenseTO;
import assign2.entities.to.VehicleTO;
import assign2.entities.to.VehicleTypeTO;
import assign2.session.VehicleManagerRemote;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 *
 * @author Gerard Gigliotti
 */
public class editVehicle {
    
    @EJB
    VehicleManagerRemote vm;
    
    private Long id;
    private String colour;
    private String name;
    private VehicleTypeTO type;
    private VehicleLicenseTO license;
    private Integer year;
    private Boolean enabled;
    private String VehicleTypeCode;
    private Long VehicleLicenseID;
    
    /** Creates a new instance of editVehicle */
    public editVehicle() {
        System.out.println("Editing a Vehicle Page");
        //Copies the object out of the sesison. WILL CRASH IF NULL
        VehicleTO vt =  (VehicleTO)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("VehicleEditSession");
        //This will redirect the page if this is null
        
        System.out.println(vt.getId());
        setId(vt.getId());
        setColour(vt.getColour());
        setName(vt.getName());
        setType(vt.getType());
        setEnabled(vt.getEnabled());
        setLicense(vt.getLicense());
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    //This Code is for the drop down boxes.
    private List<VehicleTypeTO> getTypeList() {
        /*Values for populating form */
        List<VehicleTypeTO> typeList = vm.getAllVehicleTypeTOs();
        return typeList;
    }
    
    //Similar to the one in the add vehicle, except it prioritises the items.
    public List<SelectItem> getTypeSelectItemList() {
        List<SelectItem> typeSelectItem = new ArrayList();
        for (VehicleTypeTO vt : getTypeList()) {
            System.out.println("VehicleTO RUN");
            System.out.println(vt.getCode());
            SelectItem si = new SelectItem(vt.getCode(),vt.getDescription());
            
            //Moves selected value to top of list.
            if(vt.getCode().equals(type.getCode()))
                typeSelectItem.add(0,si);
            else
                typeSelectItem.add(si);
        }
        
        System.out.println("RETURN");
        return typeSelectItem;
    }
    
    private List<VehicleLicenseTO> getLicenseList() {
        /*Values for populating form */
        List<VehicleLicenseTO> licenseList = vm.getAllVehicleLicenseTOs();
        return licenseList;
    }
    
    //Similar to the one in the add vehicle, except it prioritises the items.
    public List<SelectItem> getlicenseSelectItemList() {
        List<SelectItem> licenseSelectItem = new ArrayList();
        for (VehicleLicenseTO vl : getLicenseList()) {
            //If statement to move the vehicles current type to the top of the list
            SelectItem si = new SelectItem(vl.getId(),vl.getDescription());
            
            //Copies selected value to top of list
            if(license.getId() == vl.getId())
                licenseSelectItem.add(0,si);
            else
                licenseSelectItem.add(si);
        }
        return licenseSelectItem;
    }
    
    public String getColour() {
        return colour;
    }
    
    public void setColour(String colour) {
        this.colour = colour;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Integer getYear() {
        return year;
    }
    
    public void setYear(Integer year) {
        this.year = year;
    }
    
    public VehicleTypeTO getType() {
        System.out.println("Editing a Vehicle Page");
        return type;
    }
    
    public void setType(VehicleTypeTO type) {
        System.out.println("Editing a Vehicle Page");
        this.type = type;
    }
    
    public VehicleLicenseTO getLicense() {
        return license;
    }
    
    public void setLicense(VehicleLicenseTO license) {
        this.license = license;
    }
    
    public String saveVehicle() {
        System.out.println("Save the Vehicle");
        VehicleTO to = new VehicleTO();
        to.setId(id);
        to.setColour(colour);
        to.setName(name);
        to.setLicense(license);
        to.setType(type);
        to.setYear(year);
        to.setEnabled(enabled);
        vm.modifyVehicle(to);
        return "saveVehicle";
    }
    
    public Boolean getEnabled() {
        return enabled;
    }
    
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
    
    public String getVehicleTypeCode() {
        return VehicleTypeCode;
    }
    
    public void setVehicleTypeCode(String VehicleTypeCode) {
        this.VehicleTypeCode = VehicleTypeCode;
        type = vm.getVehicleTypeTO(VehicleTypeCode);
    }
    
    public Long getVehicleLicenseID() {
        return VehicleLicenseID;
    }
    
    public void setVehicleLicenseID(Long VehicleLicenseID) {
        this.VehicleLicenseID = VehicleLicenseID;
        license = vm.getVehicleLicenseTO(VehicleLicenseID);
    }
    
    public String deleteVehicle() {
        this.setEnabled(false);
        saveVehicle();
        return "delete";
    }
}
