/*
 * Driver.java
 *
 * Created on 16 October 2006, 22:08
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package assign2.users;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

/**
 * Entity class Driver
 * 
 * @author Gerard Gigliotti
 */
@Entity
public class Driver extends Users implements Serializable
{   
    @ManyToOne
    @JoinColumn
    private DriversLicense license;
    
    /** Creates a new instance of Driver */
    public Driver()
    {
    } 

    public DriversLicense getLicense()
    {
        return license;
    }

    public void setLicense(DriversLicense license)
    {
        this.license = license;
    }
}
