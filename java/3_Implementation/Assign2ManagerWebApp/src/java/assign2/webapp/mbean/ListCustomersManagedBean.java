/*
 * ListCustomersManagedBean.java
 *
 * Created on 25. Oktober 2006, 23:00
 *
 * To change this template, choose Tools | Template Customer
 * and open the template in the editor.
 */

package assign2.webapp.mbean;

import assign2.entities.to.CorporateDetailedTO;
import assign2.entities.to.CorporateTO;
import assign2.session.UserManagerRemote;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Thorsten
 */
public class ListCustomersManagedBean {
    
    /**
     * Creates a new instance of ListCustomersManagedBean
     */
    public ListCustomersManagedBean() {
    }
    @EJB
    UserManagerRemote um;
    
    private DataModel model;
    
    public DataModel getAllCustomers() {
        setModel(new ListDataModel(um.getAllCustomerTOs()));
        return getModel();
    }
    
    public DataModel getModel() {
        return model;
    }
    
    public void setModel(DataModel model) {
        this.model = model;
    }
    
    //This method adds the selected vehicle to a session variable, and then uses JSF to got to an edit page.
    public String editSelectedCustomer() {
        CorporateTO mto = (CorporateTO)model.getRowData();
        System.out.println("managed bean user: " + mto.getUsername());
        
        CorporateDetailedTO mdto = um.getCustomerDetailedTO(mto.getUsername());
        
        //Add CustomerDetailedTO to session
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("EditCustomerSession", mdto );
        
        return "CustomerEdit";
        
        
    }
    
    public String CreateCustomer() {
        return "createNew";
    }
    
    
}
