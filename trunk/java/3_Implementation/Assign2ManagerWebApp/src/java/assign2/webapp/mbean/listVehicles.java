/*
 * listVehicles.java
 *
 * Created on 22 October 2006, 20:05
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package assign2.webapp.mbean;

import assign2.entities.to.VehicleTO;
import assign2.session.VehicleManagerRemote;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Gerard Gigliotti
 */
public class listVehicles {
    @EJB
    VehicleManagerRemote vm;
        
     private DataModel model;
    /** Creates a new instance of listVehicles */
    
     public listVehicles() {
    }
    
    public DataModel getListAllVehicles()
    {
        setModel(new ListDataModel(vm.getAllVehicleTOs()));
        return getModel();
    }

    public DataModel getModel() {
        return model;
    }

    public void setModel(DataModel model) {
        this.model = model;
    }
    
    //This method adds the selected vehicle to a session variable, and then uses JSF to got to an edit page.
    public String selectEditVehicle()
    { 
        VehicleTO vto = (VehicleTO)model.getRowData();
        System.out.println("Adding Vehicle To Session. Variable editVehicleTO");
        //Add VTO TO session
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("VehicleEditSession",vto);
        System.out.println("Session Test");
        System.out.println(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("VehicleEditSession"));
        return "vehicle_edit";
        
        
    }
    
}
