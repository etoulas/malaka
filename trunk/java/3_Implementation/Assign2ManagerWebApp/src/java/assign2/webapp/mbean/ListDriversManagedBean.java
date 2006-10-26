/*
 * ListDriversManagedBean.java
 *
 * Created on 25. Oktober 2006, 23:00
 *
 * To change this template, choose Tools | Template Driver
 * and open the template in the editor.
 */

package assign2.webapp.mbean;

import assign2.entities.to.DriverDetailedTO;
import assign2.entities.to.DriverTO;
import assign2.session.UserManagerRemote;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Thorsten
 */
public class ListDriversManagedBean {
    
    /**
     * Creates a new instance of ListDriversManagedBean
     */
    public ListDriversManagedBean() {
    }
    @EJB
    UserManagerRemote um;
    
    private DataModel model;
    
    public DataModel getAllDrivers() {
        setModel(new ListDataModel(um.getAllDriverTOs()));
        return getModel();
    }
    
    public DataModel getModel() {
        return model;
    }
    
    public void setModel(DataModel model) {
        this.model = model;
    }
    
    //This method adds the selected vehicle to a session variable, and then uses JSF to got to an edit page.
    public String editSelectedDriver() {
        DriverTO mto = (DriverTO)model.getRowData();
        System.out.println("managed bean user: " + mto.getUsername());
        
        DriverDetailedTO mdto = um.getDriverDetailedTO(mto.getUsername());
        
        //Add DriverDetailedTO to session
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("EditDriverSession", mdto );
        
        return "DriverEdit";
        
        
    }
    
    public String CreateDriver() {
        return "createNew";
    }
    
    
}
