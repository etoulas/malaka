/*
 * Driver.java
 *
 * Created on 16 October 2006, 22:08
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package assign2.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import assign2.entities.to.*;
import java.util.Collection;
import javax.persistence.OneToMany;

/**
 * Entity class Driver
 * 
 * @author Gerard Gigliotti
 */
@Entity
public class Driver extends Users implements Serializable
{   
    @OneToMany(mappedBy="driver")
    private Collection<Booking> assignedBookings;
    @ManyToOne  //(cascade=CascadeType.ALL)
    //@JoinColumn
    private DriversLicense license;
    
    /** Creates a new instance of Driver */
    public Driver()
    {
    } 
    
    public Driver(DriverDetailedTO to) {
        super(to);
        this.setLicense(new DriversLicense(to.getLicense()));
    }

    public DriversLicense getLicense()
    {
        return license;
    }

    public void setLicense(DriversLicense license)
    {
        this.license = license;
    }
    
    public UsersDetailedTO getDetailedData()
    {
        UsersDetailedTO to = new DriverDetailedTO(username,password,firstName,lastName,phoneNumber,address.getData(),license.getData());
        return to;
    }
}
