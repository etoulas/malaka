/*
 * Manager.java
 *
 * Created on 16 October 2006, 22:05
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package assign2.entities;

import assign2.entities.to.UsersDetailedTO;
import assign2.entities.to.UsersTO;
import java.io.Serializable;
import javax.persistence.Entity;

/**
 * Entity class Manager
 * 
 * @author Gerard Gigliotti
 */
@Entity
public class Manager extends Users implements Serializable
{   
    /** Creates a new instance of Manager */
    public Manager()
    {
    }
    
    public Manager(String username,String password)
    {
       super(username,password);
    }
    
    public Manager(UsersDetailedTO to) {
        super(to);
    }

    public UsersDetailedTO getDetailedData() {
        return null;
    }
}
