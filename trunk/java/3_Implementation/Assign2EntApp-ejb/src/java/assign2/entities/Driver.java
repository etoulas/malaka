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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * Entity class Driver
 *
 * @author Gerard Gigliotti
 */
@Entity
@NamedQueries(
{    
    @NamedQuery(
    name="findAllDrivers",
            query="SELECT d FROM Driver d WHERE d.enabled = true"
            ),

    @NamedQuery(
        name="getAssignedDriversByDropoffDate",
        query="SELECT DISTINCT d FROM Driver d, IN (d.assignedBookings) AS b WHERE b.pickupDate >= :dropoffDate AND b.dropoffDate <= :dropOffDate")
})
    @NamedQuery(
    name="findDriverByUsername",
            query="SELECT d FROM Driver d WHERE d.username = :username"
            )
})

public class Driver extends Users implements Serializable {
    @OneToMany(mappedBy="driver")
    private Collection<Booking> assignedBookings;
    @ManyToOne  //(cascade=CascadeType.ALL)
    //@JoinColumn
    private DriversLicense license;
    
    /** Creates a new instance of Driver */
    public Driver() {
    }
    
    public Driver(DriverDetailedTO to) {
        super(to);
        this.setLicense(new DriversLicense(to.getLicense()));
    }
    
    public DriversLicense getLicense() {
        return license;
    }
    
    public void setLicense(DriversLicense license) {
        this.license = license;
    }
    
    public UsersDetailedTO getDetailedData() {
        UsersDetailedTO to = new DriverDetailedTO(username,password,firstName,lastName,phoneNumber,address.getData(),license.getData());
        return to;
    }
    
    public DriverTO getData() {
        DriverTO to = new DriverTO(getUsername(),getFirstName(),getLastName());
        return to;
    }
}
