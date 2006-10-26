/*
 * ListManagersManagedBean.java
 *
 * Created on 25. Oktober 2006, 23:00
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package assign2.webapp.mbean;

import assign2.entities.to.ManagerDetailedTO;
import assign2.entities.to.ManagerTO;
import assign2.session.UserManagerRemote;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Thorsten
 */
public class ListManagersManagedBean {
    
    /**
     * Creates a new instance of ListManagersManagedBean
     */
    public ListManagersManagedBean() {
    }
    @EJB
    UserManagerRemote um;
    
    private DataModel model;
    
    public DataModel getAllManagers() {
        setModel(new ListDataModel(um.getAllManagerTOs()));
        return getModel();
    }
    
    public DataModel getModel() {
        return model;
    }
    
    public void setModel(DataModel model) {
        this.model = model;
    }
    
    //This method adds the selected vehicle to a session variable, and then uses JSF to got to an edit page.
    public String editSelectedManager() {
        ManagerTO mto = (ManagerTO)model.getRowData();
        System.out.println("managed bean user: " + mto.getUsername());
        
        ManagerDetailedTO mdto = um.getManagerDetailedTO(mto.getUsername());
        
        //Add ManagerDetailedTO to session
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("EditManagerSession", mdto );
        
        return "managerEdit";
        
        
    }
    
    public String CreateManager() {
        return "createNew";
    }
    
    
}
