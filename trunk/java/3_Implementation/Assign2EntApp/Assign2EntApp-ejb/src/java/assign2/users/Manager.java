/*
 * Manager.java
 *
 * Created on 16 October 2006, 22:05
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package assign2.users;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
}
