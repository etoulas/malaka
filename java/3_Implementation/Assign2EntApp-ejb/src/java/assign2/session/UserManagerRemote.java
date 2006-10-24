
package assign2.session;

import assign2.entities.to.DriverDetailedTO;
import assign2.entities.to.ManagerDetailedTO;
import javax.ejb.Remote;


/**
 * This is the business interface for UserManager enterprise bean.
 */
@Remote
public interface UserManagerRemote {
    
    public void createManager(ManagerDetailedTO to);
    
    public void createDriver(DriverDetailedTO to);
}
