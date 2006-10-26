/*
 * UserManagerBean.java
 *
 * Created on 24. Oktober 2006, 15:06
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package assign2.session;

import assign2.entities.Address;
import assign2.entities.Corporate;
import assign2.entities.Driver;
import assign2.entities.DriversLicense;
import assign2.entities.Manager;
import assign2.entities.Users;
import assign2.entities.to.AddressTO;
import assign2.entities.to.CorporateDetailedTO;
import assign2.entities.to.CorporateTO;
import assign2.entities.to.CustomerTO;
import assign2.entities.to.DriverDetailedTO;
import assign2.entities.to.DriverTO;
import assign2.entities.to.DriversLicenseTO;
import assign2.entities.to.ManagerDetailedTO;
import assign2.entities.to.ManagerTO;
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
    
    
    
    // Customer Stuff ------------------------------------------------------------------------
    
    public void createCustomer(CorporateDetailedTO to) {
        Corporate c = new Corporate(to);
        em.persist(c);
    }
    
    public List<CorporateTO> getAllCustomerTOs() {
        
        List<CorporateTO> results = new ArrayList<CorporateTO>();
        
        Query allCustomerQuery = em.createNamedQuery("findAllCustomers");
        List dbResults = allCustomerQuery.getResultList();
        
        for (int i = 0; i < dbResults.size(); i++) {
            Corporate m = (Corporate)dbResults.get(i);
            results.add(m.getData());
        }
        
        return results;
        
    }
    
    private Corporate getCustomer(String username) {
        Corporate m;
        System.out.println("getCustomer: " + username);
        Query VehicleByIDQuery = em.createNamedQuery("findCustomerByUsername");
        VehicleByIDQuery.setParameter("username",username);
        List <Corporate>dbResults = VehicleByIDQuery.getResultList();
        m = dbResults.get(0);
        System.out.println("getCustomer - Customer: " + m.getFirstName() + " " + m.getLastName());
        return m;
    }
    
    public void modifyCustomer(CorporateDetailedTO to) {
        Corporate m = getCustomer(to.getUsername());
        m.setFirstName(to.getFirstName());
        m.setLastName(to.getLastName());
        m.setPassword(to.getPassword());
        m.setPhoneNumber(to.getPhoneNumber());
        m.setAddress(new Address( to.getAddress() ) );
    }
    
    public CorporateDetailedTO getCustomerDetailedTO(String username){
        
        System.out.println("getCorporateDetailedTO user: " + username);
        
        Corporate m = getCustomer(username);
        
        CorporateDetailedTO mto = new CorporateDetailedTO();
        
        mto.setFirstName(m.getFirstName());
        mto.setLastName(m.getLastName());
        mto.setUsername(m.getUsername());
        mto.setPassword(m.getPassword());
        mto.setPhoneNumber(m.getPhoneNumber());
        mto.setAddress(new AddressTO(m.getAddress()));
        
        return mto;
        
    }
    
        
    
    
    
    
    
    // Drivers Stuff ------------------------------------------------------------------------
    
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
    
    

    public List<DriverTO> getAllDriverTOs() {
        
        List<DriverTO> results = new ArrayList<DriverTO>();
        
        Query allDriverQuery = em.createNamedQuery("findAllDrivers");
        List dbResults = allDriverQuery.getResultList();
        
        for (int i = 0; i < dbResults.size(); i++) {
            Driver d = (Driver)dbResults.get(i);
            results.add(d.getData());
        }
        
        return results;
        
    }
    
      private Driver getDriver(String username) {
        Driver d;
        Query DriverByIDQuery = em.createNamedQuery("findDriverByUsername");
        DriverByIDQuery.setParameter("username",username);
        List <Driver>dbResults = DriverByIDQuery.getResultList();
        d = dbResults.get(0);
        return d;
    }
    
    public void modifyDriver(DriverDetailedTO to) {
        Driver d = getDriver(to.getUsername());
        d.setFirstName(to.getFirstName());
        d.setLastName(to.getLastName());
        d.setPassword(to.getPassword());
        d.setPhoneNumber(to.getPhoneNumber());
        d.setAddress(new Address( to.getAddress() ) );
    }
    
    public DriverDetailedTO getDriverDetailedTO(String username){
        
        
        Driver m = getDriver(username);
        
        DriverDetailedTO dto = new DriverDetailedTO();
        
        dto.setFirstName(m.getFirstName());
        dto.setLastName(m.getLastName());
        dto.setUsername(m.getUsername());
        dto.setPassword(m.getPassword());
        dto.setPhoneNumber(m.getPhoneNumber());
        dto.setAddress(new AddressTO(m.getAddress()));
        
        return dto;
        
    }
    
    
    
    // Manager Stuff
    
    public void createManager(ManagerDetailedTO to) {
        Manager m = new Manager(to);
        em.persist(m);
    }
    
    
    public List<ManagerTO> getAllManagerTOs() {
        
        List<ManagerTO> results = new ArrayList<ManagerTO>();
        
        Query allManagerQuery = em.createNamedQuery("findAllManagers");
        List dbResults = allManagerQuery.getResultList();
        
        for (int i = 0; i < dbResults.size(); i++) {
            Manager m = (Manager)dbResults.get(i);
            results.add(m.getData());
        }
        
        return results;
        
    }
    
    private Manager getManager(String username) {
        Manager m;
        System.out.println("getManager: " + username);
        Query VehicleByIDQuery = em.createNamedQuery("findManagerByUsername");
        VehicleByIDQuery.setParameter("username",username);
        List <Manager>dbResults = VehicleByIDQuery.getResultList();
        m = dbResults.get(0);
        System.out.println("getManager - Manager: " + m.getFirstName() + " " + m.getLastName());
        return m;
    }
    
    public void modifyManager(ManagerDetailedTO to) {
        Manager m = getManager(to.getUsername());
        m.setFirstName(to.getFirstName());
        m.setLastName(to.getLastName());
        m.setPassword(to.getPassword());
        m.setPhoneNumber(to.getPhoneNumber());
        m.setAddress(new Address( to.getAddress() ) );
    }
    
    public ManagerDetailedTO getManagerDetailedTO(String username){
        
        System.out.println("getManagerDetailedTO user: " + username);
        
        Manager m = getManager(username);
        
        ManagerDetailedTO mto = new ManagerDetailedTO();
        
        mto.setFirstName(m.getFirstName());
        mto.setLastName(m.getLastName());
        mto.setUsername(m.getUsername());
        mto.setPassword(m.getPassword());
        mto.setPhoneNumber(m.getPhoneNumber());
        mto.setAddress(new AddressTO(m.getAddress()));
        
        return mto;
        
    }
    
        
    
    
// General Stuff
    
    
    public void deleteUser(String username) {
        Users u = getUser(username);
        u.setEnabled(false);
        em.persist(u);
    }
    
    private Users getUser(String username) {
        Users u;
        Query VehicleByIDQuery = em.createNamedQuery("findUserByUsername");
        VehicleByIDQuery.setParameter("username",username);
        List <Users>dbResults = VehicleByIDQuery.getResultList();
        u = dbResults.get(0);
        return u;
    }
    
    
}
