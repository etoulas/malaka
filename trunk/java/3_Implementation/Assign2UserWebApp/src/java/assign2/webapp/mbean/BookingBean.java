/*
 * CreateBookingManagedBean.java
 *
 * Created on October 20, 2006, 1:07 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package assign2.webapp.mbean;

import assign2.entities.to.AddressTO;
import assign2.entities.to.BookingDetailsTO;
import assign2.session.BookingManagerRemote;
import java.util.Date;
import javax.ejb.EJB;

/**
 *
 * @author ramu01
 */
public class BookingBean {
    
    @EJB
    private BookingManagerRemote bm;
    
    private String contactName;
    private String customerName;
    private Date pickupDate;
    // address data
    private Integer postCode;
    private String countryState;
    private String city;
    private String country;
    private String streetNumber;
    private String street;
    private String suburb;
    
    /** Creates a new instance of CreateBookingManagedBean */
    public BookingBean() {
    }
    
    public String confirmBooking() {
        
        AddressTO ato = new AddressTO();
        ato.setCity(this.getCity());
        ato.setCountry(this.getCountry());
        ato.setCountryState(this.getCountryState());
        ato.setPostCode(this.getPostCode());
        ato.setStreet(this.getStreet());
        ato.setStreetNumber(this.getStreetNumber());
        ato.setSuburb(this.getSuburb());
        
        BookingDetailsTO bto = new BookingDetailsTO();
        bto.setContactName(this.getContactName());
        bto.setCustomerName(this.getCustomerName());
        bto.setPickupDate(this.getPickupDate());
        bto.setPickupAddress(ato);
        
        bm.createNewBooking(bto);
        
        return "success";
    }
    
    public String confirmBack() {
        return "confirmBack";
    }
    
    public String continueBooking() {
        return "confirm";
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

    public Integer getPostCode() {
        return postCode;
    }

    public void setPostCode(Integer postCode) {
        this.postCode = postCode;
    }

    public String getCountryState() {
        return countryState;
    }

    public void setCountryState(String countryState) {
        this.countryState = countryState;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }
}
