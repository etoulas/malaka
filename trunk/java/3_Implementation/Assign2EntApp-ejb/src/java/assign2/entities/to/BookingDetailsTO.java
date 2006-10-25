/*
 * BookingDetailsTO.java
 *
 * Created on October 20, 2006, 12:53 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package assign2.entities.to;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author ramu01
 */
public class BookingDetailsTO {
    
    private Long id;
    private String contactName;
    private String customerName;
    private Date pickupDate;
    private Date dropoffDate;
    private BookingTypeTO bookingType;
    private AddressTO pickupAddress;
    private AddressTO dropoffAddress;
    private Boolean processed;
    
    /** Creates a new instance of BookingDetailsTO */
    public BookingDetailsTO() {
    }
    
    public BookingDetailsTO(Long id, 
                            String contactName,
                            String customerName,
                            Date pickupDate,
                            BookingTypeTO bookingType,
                            AddressTO pickupAddress,
                            AddressTO dropoffAddress,
                            Boolean processed)
    {
        this.setId(id);
        this.setContactName(contactName);
        this.setCustomerName(customerName);
        this.setPickupDate(pickupDate);
        this.setBookingType(bookingType);
        this.setPickupAddress(pickupAddress);
        this.setDropoffAddress(dropoffAddress);
        this.setProcessed(processed);
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
    
    public AddressTO getPickupAddress() {
        return pickupAddress;
    }
    
    public void setPickupAddress(AddressTO pickupAddress) {
        this.pickupAddress = pickupAddress;
    }
    
    public AddressTO getDropoffAddress() {
        return dropoffAddress;
    }
    
    public void setDropoffAddress(AddressTO dropoffAddress) {
        this.dropoffAddress = dropoffAddress;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public BookingTypeTO getBookingType() {
        return bookingType;
    }
    
    public void setBookingType(BookingTypeTO bookingType) {
        this.bookingType = bookingType;
    }
    
    public Boolean getProcessed() {
        return processed;
    }
    
    public void setProcessed(Boolean processed) {
        this.processed = processed;
    }

    public Date getDropoffDate() {
        return dropoffDate;
    }

    public void setDropoffDate(Date dropoffDate) {
        this.dropoffDate = dropoffDate;
    }
}
