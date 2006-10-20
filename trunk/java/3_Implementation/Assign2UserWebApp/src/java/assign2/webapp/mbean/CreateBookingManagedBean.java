/*
 * CreateBookingManagedBean.java
 *
 * Created on October 20, 2006, 1:07 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package assign2.webapp.mbean;

import assign2.entities.to.BookingDetailsTO;
import assign2.session.BookingManagerRemote;
import java.util.Date;
import javax.ejb.EJB;

/**
 *
 * @author ramu01
 */
public class CreateBookingManagedBean {
    
    @EJB
    private BookingManagerRemote bm;
    
    private String contactName;
    private String customerName;
    private Date pickupDate;
    
    /** Creates a new instance of CreateBookingManagedBean */
    public CreateBookingManagedBean() {
    }
    
    public String createBooking() {
        
        BookingDetailsTO bto = new BookingDetailsTO();
        bto.setContactName(this.getContactName());
        bto.setCustomerName(this.getCustomerName());
        bto.setPickupDate(this.getPickupDate());
        
        bm.createBooking(bto);
        
        return "success";
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
