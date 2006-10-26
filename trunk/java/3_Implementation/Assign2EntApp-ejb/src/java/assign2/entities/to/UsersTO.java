/*
 * UsersTO.java
 *
 * Created on 19 October 2006, 14:18
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package assign2.entities.to;

import java.io.Serializable;
/**
 *
 * @author Gerard Gigliotti
 */
public class UsersTO implements Serializable {
    private String firstName;
    private String lastName;
    private String username;
    private Boolean enabled;
    
    public UsersTO() {

    }
    
    /** Creates a new instance of UsersTO */
    public UsersTO(String uname,String fname,String lname) {
        this.setUsername(uname);
        this.setFirstName(fname);
        this.setLastName(lname);
    }
    
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
}

