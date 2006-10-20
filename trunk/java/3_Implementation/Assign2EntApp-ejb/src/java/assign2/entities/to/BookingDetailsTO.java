/*
 * BookingDetailsTO.java
 *
 * Created on October 20, 2006, 12:53 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package assign2.entities.to;

import java.util.Date;

/**
 *
 * @author ramu01
 */
public class BookingDetailsTO {
    private String contactName;
    private String customerName;
    private Date pickupDate;
    
    /** Creates a new instance of BookingDetailsTO */
    public BookingDetailsTO() {
        
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(Date pickupDate) {
        this.pickupDate = pickupDate;
    }
    
}
