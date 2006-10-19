
package assign2.users;

import javax.ejb.Remote;


/**
 * This is the business interface for UserManager enterprise bean.
 */
@Remote
public interface UserManagerRemote
{
    java.lang.String testEm();
    
}

