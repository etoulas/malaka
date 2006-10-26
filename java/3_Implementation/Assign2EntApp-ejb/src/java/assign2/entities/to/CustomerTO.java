/*
 * CustomerTO.java
 *
 * Created on 25. Oktober 2006, 22:29
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package assign2.entities.to;

/**
 *
 * @author Thorsten
 */
public class CustomerTO extends UsersTO {
    
    /** Creates a new instance of CustomerTO */
    public CustomerTO() {
    }
    
    private String company;
    
    public CustomerTO(String uname,String fname,String lname, String company) {
        super(uname, fname, lname);
        this.company = company;
        
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
    
}
