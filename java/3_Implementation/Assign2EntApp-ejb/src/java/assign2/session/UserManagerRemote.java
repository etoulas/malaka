
package assign2.session;

import assign2.entities.to.DriverDetailedTO;
import assign2.entities.to.ManagerDetailedTo;
import javax.ejb.Remote;


/**
 * This is the business interface for UserManager enterprise bean.
 */
@Remote
public interface UserManagerRemote {
    
    public void createManager(ManagerDetailedTo to);
    
    public void createDriver(DriverDetailedTO to);
}
