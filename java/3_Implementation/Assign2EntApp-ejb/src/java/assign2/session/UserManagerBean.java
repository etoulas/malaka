/*
 * UserManagerBean.java
 *
 * Created on 24. Oktober 2006, 15:06
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package assign2.session;

import assign2.entities.Corporate;
import assign2.entities.Driver;
import assign2.entities.DriversLicense;
import assign2.entities.Manager;
import assign2.entities.to.CorporateDetailedTO;
import assign2.entities.to.DriverDetailedTO;
import assign2.entities.to.DriversLicenseTO;
import assign2.entities.to.ManagerDetailedTO;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

        

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

public List<DriversLicenseTO> getAllLicenseTypes() {
 
    List<DriversLicenseTO> licenseTypes = new ArrayList<DriversLicenseTO>();
    
    Query q = em.createNamedQuery("findAllDriversLicenseTypes");
    List results = q.getResultList();
    
    for (Object item : results) {
        licenseTypes.add( ((DriversLicense) item).getData());
    }
    
    return licenseTypes;
}    

 public DriversLicenseTO getLicenseTypeById(long id) {

        Query q = em.createNamedQuery("findLicenseTypeByID");
        q.setParameter("id", id);
        DriversLicense dl = (DriversLicense) q.getSingleResult();
        return dl.getData();
     
 }
 
     public void createCustomer(CorporateDetailedTO to) {
             Corporate c = new Corporate(to);
             em.persist(c);
     }
 
    
}
