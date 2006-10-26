/*
 * Manager.java
 *
 * Created on 16 October 2006, 22:05
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package assign2.entities;

import assign2.entities.to.ManagerTO;
import assign2.entities.to.UsersDetailedTO;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * Entity class Manager
 *
 * @author Gerard Gigliotti
 */
@Entity
@NamedQueries(
{    
    @NamedQuery(
    name="findAllManagers",
            query="SELECT m FROM Manager m WHERE m.enabled = true"
            ),

    @NamedQuery(
    name="findManagerByUsername",
            query="SELECT m FROM Manager m WHERE m.username = :username"
            )
})
public class Manager extends Users implements Serializable {
    /** Creates a new instance of Manager */
    public Manager() {
    }
    
    public Manager(String username,String password) {
        super(username,password);
    }
    
    public Manager(String uname, String fname, String lname) {
        this.username = uname;
        this.firstName = fname;
        this.lastName = lname;
    }
    
    public Manager(UsersDetailedTO to) {
        super(to);
    }
    
    public ManagerTO getData() {
        ManagerTO to = new ManagerTO(getUsername(),getFirstName(),getLastName());
        return to;
    }
    
    public UsersDetailedTO getDetailedData() {
        return null;
    }
}
