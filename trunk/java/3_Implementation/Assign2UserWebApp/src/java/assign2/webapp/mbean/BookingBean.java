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
import assign2.entities.to.BookingTypeTO;
import assign2.session.BookingManagerRemote;
import assign2.webapp.bean.Address;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

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
    private Date dropoffDate;
    private Long selectedBookingType;
    private String selectedBookingTypeName;
    private List<SelectItem> bookingTypes;
    // address data
    private String pickupCity;
    private String pickupCountry;
    private String pickupCountryState;
    private Integer pickupPostCode;
    private String pickupStreet;
    private String pickupStreetNumber;
    private String pickupSuburb;
    
    private String dropoffCity;
    private String dropoffCountry;
    private String dropoffCountryState;
    private Integer dropoffPostCode;
    private String dropoffStreet;
    private String dropoffStreetNumber;
    private String dropoffSuburb;
    /** Creates a new instance of CreateBookingManagedBean */
    public BookingBean() {
    }
    
    public String confirmBooking() {
        
        String nextView;
        
        BookingTypeTO btto = bm.getBookingTypeById(this.selectedBookingType);
        
        AddressTO pickupAto = new AddressTO();
        pickupAto.setCity(this.pickupCity);
        pickupAto.setCountry(this.pickupCountry);
        pickupAto.setCountryState(this.pickupCountryState);
        pickupAto.setPostCode(this.pickupPostCode);
        pickupAto.setStreet(this.pickupStreet);
        pickupAto.setStreetNumber(this.pickupStreetNumber);
        pickupAto.setSuburb(this.pickupSuburb);


        //dropoff address is optional for booking type hourly
        AddressTO dropOffAto = new AddressTO();
        dropOffAto.setCity(this.dropoffCity);
        dropOffAto.setCountry(this.dropoffCountry);
        dropOffAto.setCountryState(this.dropoffCountryState);
        dropOffAto.setPostCode(this.dropoffPostCode);
        dropOffAto.setStreet(this.dropoffStreet);
        dropOffAto.setStreetNumber(this.dropoffStreetNumber);
        dropOffAto.setSuburb(this.dropoffSuburb);      
        
        BookingDetailsTO bto = new BookingDetailsTO();
        bto.setContactName(this.getContactName());
        bto.setCustomerName(this.getCustomerName());
        bto.setDropoffDate(this.getDropoffDate());
        bto.setPickupDate(this.getPickupDate());
        bto.setBookingType(btto);
        bto.setPickupAddress(pickupAto);
        bto.setDropoffAddress(dropOffAto);
        
        bm.createNewBooking(bto);
        
        return "success";
    }
    
    public void validateBookingType(FacesContext context, 
        UIComponent toValidate, Object value) {
        /*
        String message = "";
        Long bookingTypeId = (Long) value;
        if(bookingTypeId.equals(new Long(1)) && !this.isDropoffAddressComplete(toValidate)) {
            ((UIInput)toValidate).setValid(false);
            message = "Transfers must have a drop off address and drop off date";
            context.addMessage(toValidate.getClientId(context),
                new FacesMessage(message));
        }
        */
    }
    
    public List getBookingTypes() {
        if (this.bookingTypes == null || this.bookingTypes.size() == 0) {
            this.bookingTypes = new ArrayList<SelectItem>();
            List<BookingTypeTO> types = bm.getAllBookingTypes();
            for (BookingTypeTO to : types) {
                this.bookingTypes.add(new SelectItem(to.getId().toString(), to.getDescription()));
            }
        }
        
        return this.bookingTypes;
    }
    
    public String confirmBack() {
        return "confirmBack";
    }
    
    public String continueBooking() {
        BookingTypeTO bto = bm.getBookingTypeById(this.getSelectedBookingType());
        this.selectedBookingTypeName = bto.getDescription();
        return "confirm";
    }
    
    /*
    private Boolean isDropoffAddressComplete(UIComponent component) {
        Boolean isComplete = false;
        if ((component.findComponent("dropStreet"). != null && this.getDropoffCountry().length() > 0) &&
                (this.getDropoffCity() != null && this.getDropoffCity().length() > 0) &&
                (this.getDropoffCountryState() != null && this.getDropoffCountryState().length() > 0) &&
                (this.getDropoffPostCode() != null && this.getDropoffPostCode() > 0) &&
                (this.getDropoffStreet() != null && this.getDropoffStreet().length() > 0) &&
                (this.getDropoffStreetNumber() != null && this.getDropoffStreetNumber().length() > 0) &&
                (this.getDropoffSuburb() != null && this.getDropoffSuburb().length() > 0)
                ) {
            isComplete = true;
        }
        return isComplete;
    }
    */

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

    public Long getSelectedBookingType() {
        return selectedBookingType;
    }

    public void setSelectedBookingType(Long selectedBookingType) {
        this.selectedBookingType = selectedBookingType;
    }

    public Date getDropoffDate() {
        return dropoffDate;
    }

    public void setDropoffDate(Date dropoffDate) {
        this.dropoffDate = dropoffDate;
    }

    public String getSelectedBookingTypeName() {
        return selectedBookingTypeName;
    }

    public void setSelectedBookingTypeName(String selectedBookingTypeName) {
        this.selectedBookingTypeName = selectedBookingTypeName;
    }

    public String getPickupCity() {
        return pickupCity;
    }

    public void setPickupCity(String pickupCity) {
        this.pickupCity = pickupCity;
    }

    public String getPickupCountry() {
        return pickupCountry;
    }

    public void setPickupCountry(String pickupCountry) {
        this.pickupCountry = pickupCountry;
    }

    public String getPickupCountryState() {
        return pickupCountryState;
    }

    public void setPickupCountryState(String pickupCountryState) {
        this.pickupCountryState = pickupCountryState;
    }

    public Integer getPickupPostCode() {
        return pickupPostCode;
    }

    public void setPickupPostCode(Integer pickupPostCode) {
        this.pickupPostCode = pickupPostCode;
    }

    public String getPickupStreet() {
        return pickupStreet;
    }

    public void setPickupStreet(String pickupStreet) {
        this.pickupStreet = pickupStreet;
    }

    public String getPickupStreetNumber() {
        return pickupStreetNumber;
    }

    public void setPickupStreetNumber(String pickupStreetNumber) {
        this.pickupStreetNumber = pickupStreetNumber;
    }

    public String getPickupSuburb() {
        return pickupSuburb;
    }

    public void setPickupSuburb(String pickupSuburb) {
        this.pickupSuburb = pickupSuburb;
    }

    public String getDropoffCity() {
        return dropoffCity;
    }

    public void setDropoffCity(String dropoffCity) {
        this.dropoffCity = dropoffCity;
    }

    public String getDropoffCountry() {
        return dropoffCountry;
    }

    public void setDropoffCountry(String dropoffCountry) {
        this.dropoffCountry = dropoffCountry;
    }

    public String getDropoffCountryState() {
        return dropoffCountryState;
    }

    public void setDropoffCountryState(String dropoffCountryState) {
        this.dropoffCountryState = dropoffCountryState;
    }

    public Integer getDropoffPostCode() {
        return dropoffPostCode;
    }

    public void setDropoffPostCode(Integer dropoffPostCode) {
        this.dropoffPostCode = dropoffPostCode;
    }

    public String getDropoffStreet() {
        return dropoffStreet;
    }

    public void setDropoffStreet(String dropoffStreet) {
        this.dropoffStreet = dropoffStreet;
    }

    public String getDropoffStreetNumber() {
        return dropoffStreetNumber;
    }

    public void setDropoffStreetNumber(String dropoffStreetNumber) {
        this.dropoffStreetNumber = dropoffStreetNumber;
    }

    public String getDropoffSuburb() {
        return dropoffSuburb;
    }

    public void setDropoffSuburb(String dropoffSuburb) {
        this.dropoffSuburb = dropoffSuburb;
    }
}
