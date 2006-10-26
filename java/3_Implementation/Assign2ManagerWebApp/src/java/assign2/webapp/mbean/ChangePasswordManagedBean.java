/*
 * ChangePasswordManagedBean.java
 *
 * Created on 26. Oktober 2006, 14:03
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package assign2.webapp.mbean;

import assign2.entities.to.UsersDetailedTO;
import javax.faces.context.FacesContext;

/**
 *
 * @author Thorsten
 */
public class ChangePasswordManagedBean {
    
    private String username;
    private String password;
    private String repPassword;
    
    private UsersDetailedTO uto;
    
    /** Creates a new instance of ChangePasswordManagedBean */
    public ChangePasswordManagedBean() {
        
        this.uto = (UsersDetailedTO)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ChangePasswordSession");
        
        this.username = uto.getUsername();
        
    }
    
    public String SavePassword() {
        
        uto.setPassword(this.password);
        return "saved";
    }
    
    public String CancelSavePassword() {
        
        
        return "cancel";
    }
    
    
    
    
}
