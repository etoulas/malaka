/*
 * UserManagerBean.java
 *
 * Created on 24. Oktober 2006, 15:06
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package assign2.session;

import assign2.entities.Driver;
import assign2.entities.Manager;
import assign2.entities.to.DriverDetailedTO;
import assign2.entities.to.ManagerDetailedTO;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

        

/**
 *
 * @author Thorsten
 */
@Stateless
public class UserManagerBean implements assign2.session.UserManagerRemote, assign2.session.UserManagerLocal {
    
    @PersistenceContext
    EntityManager em;
    
    /** Creates a new instance of UserManagerBean */
    public UserManagerBean() {
    }
    
    
public void createManager(ManagerDetailedTO to)    
{
    Manager m = new Manager(to);
    em.persist(m);
}

public void createDriver(DriverDetailedTO to) {
    Driver d = new Driver(to);
    em.persist(d);
}

    
    
    
}
