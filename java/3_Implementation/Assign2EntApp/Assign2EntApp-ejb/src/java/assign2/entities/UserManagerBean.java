/*
 * UserManagerBean.java
 *
 * Created on 16 October 2006, 16:33
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package assign2.users;

import assign2.entities.Corporate;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Gerard Gigliotti
 */
@Stateless
public class UserManagerBean implements assign2.users.UserManagerRemote, assign2.users.UserManagerLocal
{
    @PersistenceContext
private EntityManager em;
    
    /** Creates a new instance of UserManagerBean */
    public UserManagerBean()
    {
    }
    
    public String testEm()
    {        
        Corporate um = new Corporate("ggotti","test");
        um.setCompanyName("Limited");
        em.persist(um);
        return um.getusername();
    }
}
