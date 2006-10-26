
package assign2.session;

import assign2.entities.to.CorporateDetailedTO;
import assign2.entities.to.CorporateTO;
import assign2.entities.to.CustomerDetailedTO;
import assign2.entities.to.DriverDetailedTO;
import assign2.entities.to.DriverTO;
import assign2.entities.to.DriversLicenseTO;
import assign2.entities.to.ManagerDetailedTO;
import assign2.entities.to.ManagerTO;
import java.util.List;
import javax.ejb.Remote;


/**
 * This is the business interface for UserManager enterprise bean.
 */
@Remote
public interface UserManagerRemote {
    
    // Customer stuff
    
    public void createCustomer(CorporateDetailedTO to);

    public List<CorporateTO> getAllCustomerTOs();
    
    public void modifyCustomer(CorporateDetailedTO to);
    
    public CorporateDetailedTO getCustomerDetailedTO(String username);
    
    
    
    
    // Drivers Stuff
    
    public void createDriver(DriverDetailedTO to);
    
    public List<DriversLicenseTO> getAllLicenseTypes();
    
    public DriversLicenseTO getLicenseTypeById(long id);

    public List<DriverTO> getAllDriverTOs();
    
    public void modifyDriver(DriverDetailedTO to);
    
    public DriverDetailedTO getDriverDetailedTO(String username);
    
    
    
    
    // Manager Stuff
    
    public void createManager(ManagerDetailedTO to);

    public List<ManagerTO> getAllManagerTOs();
    
    public void modifyManager(ManagerDetailedTO to);
    
    public ManagerDetailedTO getManagerDetailedTO(String username);
    
    // General Stuff
    
    public void deleteUser(String username);
}
