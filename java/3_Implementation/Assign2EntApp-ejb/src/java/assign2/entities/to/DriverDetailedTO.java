/*
 * DriverDetailedTO.java
 *
 * Created on 19 October 2006, 15:35
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package assign2.entities.to;

/**
 *
 * @author Gerard Gigliotti
 */
public class DriverDetailedTO extends UsersDetailedTO
{
    private DriversLicenseTO license;
    /**
     * Creates a new instance of DriverDetailedTO
     */
    
    public DriverDetailedTO() {
        super();
    }
    
    public DriverDetailedTO(String username,String password,String firstName,String lastName,String phoneNumber, AddressTO address,DriversLicenseTO license)
    {
        super(username,password,firstName,lastName,phoneNumber, address);
        this.license = license;
    }
    
    public DriversLicenseTO getLicense() {
        return this.license;
    }

    public void setLicense(DriversLicenseTO lto) {
       this.license = lto;
    }

    
}
