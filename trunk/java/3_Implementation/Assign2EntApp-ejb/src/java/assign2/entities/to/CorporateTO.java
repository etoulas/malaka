/*
 * CorporateTO.java
 *
 * Created on 26. Oktober 2006, 17:15
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package assign2.entities.to;

/**
 *
 * @author Thorsten
 */
public class CorporateTO extends UsersTO {
    
    /** Creates a new instance of CorporateTO */
    public CorporateTO() {
    }
     
    public CorporateTO(String uname,String fname,String lname) {
        super(uname, fname, lname);
        
    } 
}
