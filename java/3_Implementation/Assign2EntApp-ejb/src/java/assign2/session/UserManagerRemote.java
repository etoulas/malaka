
package assign2.session;

import assign2.entities.to.CorporateDetailedTO;
import assign2.entities.to.DriverDetailedTO;
import assign2.entities.to.DriversLicenseTO;
import assign2.entities.to.ManagerDetailedTO;
import java.util.List;
import javax.ejb.Remote;


/**
 * This is the business interface for UserManager enterprise bean.
 */
@Remote
public interface UserManagerRemote {
    
    public void createManager(ManagerDetailedTO to);
    
    public void createCustomer(CorporateDetailedTO to);
    
    public void createDriver(DriverDetailedTO to);
    
    public List<DriversLicenseTO> getAllLicenseTypes();
    
    public DriversLicenseTO getLicenseTypeById(long id);
}
