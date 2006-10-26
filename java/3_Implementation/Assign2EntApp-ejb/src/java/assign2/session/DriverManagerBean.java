/*
 * DriverManagerBean.java
 *
 * Created on October 26, 2006, 1:50 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package assign2.session;

import assign2.entities.Driver;
import assign2.entities.to.BookingDetailsTO;
import assign2.entities.to.DriverDetailedTO;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;

/**
 *
 * @author ramu01
 */
@Stateless
public class DriverManagerBean implements assign2.session.DriverManagerRemote, assign2.session.DriverManagerLocal {
    
    @PersistenceContext
    EntityManager em;
    
    /** Creates a new instance of DriverManagerBean */
    public DriverManagerBean() {
   
    }
    
    public List<DriverDetailedTO> getFreeDrivers(BookingDetailsTO bto) {
        Query q = em.createNamedQuery("getAssignedDriversByPickupDate");
        q.setParameter("pickupDate", bto.getPickupDate(), TemporalType.TIMESTAMP);
        List<Driver> drivers = (List<Driver>) q.getResultList();
        
        Query blockedDriversQuery = em.createNamedQuery("getAssignedDriversByDropoffDate");
        q.setParameter("dropoffDate", bto.getDropoffDate(), TemporalType.TIMESTAMP);
        List<Driver> blockedDrivers = (List<Driver>) blockedDriversQuery.getResultList();
        
        List<DriverDetailedTO> freeDrivers = new ArrayList<DriverDetailedTO>();
        for (Driver d : drivers) {
            if (blockedDrivers.contains(d)) {
                drivers.remove(d);
            }
            else {
                freeDrivers.add((DriverDetailedTO) d.getDetailedData());
            }
        }
        return freeDrivers;
    }
}
