/*
 * processBookingBean.java
 *
 * Created on October 24, 2006, 5:36 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
                    <h:outputText id="pickupTime"
                                  value="#{processBookingBean.pickupTime}">
                        <f:convertDateTime type="time" pattern="HH:mm"/>
                    </h:outputText>

 */

package assign2.webapp.mbean;

import assign2.entities.to.AddressTO;
import assign2.entities.to.BookingDetailsTO;
import assign2.entities.to.BookingTypeTO;
import assign2.entities.to.VehicleTO;
import assign2.session.BookingManagerRemote;
import assign2.session.VehicleManagerRemote;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 *
 * @author et
 */
public class processBookingBean {
    
    @EJB
    BookingManagerRemote bm;
    VehicleManagerRemote vm;
    
    Long selectedBooking;
    
    private Long id;
    private String contactName;
    private String customerName;
    private Date pickupDate;
    //private Time pickupTime;
    private Date dropoffDate;
    //private Time dropoffTime;
    private String bookingType;
    
    private Integer pickupPostCode;
    private String pickupCountryState;
    private String pickupCity;
    private String pickupCountry;
    private String pickupStreetNumber;
    private String pickupStreet;
    private String pickupSuburb;
    
    private Integer dropoffPostCode;
    private String dropoffCountryState;
    private String dropoffCity;
    private String dropoffCountry;
    private String dropoffStreetNumber;
    private String dropoffStreet;
    private String dropoffSuburb;
    
    private List<SelectItem> vehicles;
    
    private Boolean processed;
    
    /**
     * Creates a new instance of processBookingBean
     */
    public processBookingBean() {
        BookingDetailsTO bto = (BookingDetailsTO) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ProcessBooking");
        this.setId(bto.getId());
        this.setContactName(bto.getContactName());
        this.setCustomerName(bto.getCustomerName());
        this.setPickupDate(bto.getPickupDate());
        //this.setPickupTime(bto.getPickupTime());
        this.setDropoffDate(bto.getDropoffDate());
        //this.setDropoffTime(bto.getDropoffTime());
        this.setBookingType(bto.getBookingType().getDescription());
        // pickup address
        if (bto.getPickupAddress() != null) {
        this.setPickupPostCode(bto.getPickupAddress().getPostCode());
        this.setPickupCountryState(bto.getPickupAddress().getCountryState());
        this.setPickupCity(bto.getPickupAddress().getCity());
        this.setPickupCountry(bto.getPickupAddress().getCountry());
        this.setPickupStreetNumber(bto.getPickupAddress().getStreetNumber());
        this.setPickupStreet(bto.getPickupAddress().getStreet());
        this.setPickupSuburb(bto.getPickupAddress().getSuburb());
        }
        // dropoff address
        if (bto.getDropoffAddress() != null) {
        this.setDropoffPostCode(bto.getDropoffAddress().getPostCode());
        this.setDropoffCountryState(bto.getDropoffAddress().getCountryState());
        this.setDropoffCity(bto.getDropoffAddress().getCity());
        this.setDropoffCountry(bto.getDropoffAddress().getCountry());
        this.setDropoffStreetNumber(bto.getDropoffAddress().getStreetNumber());
        this.setDropoffStreet(bto.getDropoffAddress().getStreet());
        this.setDropoffSuburb(bto.getDropoffAddress().getSuburb());
        this.setProcessed(bto.getProcessed());
        }
    }

    public String assignDriverVehicle() {
        return "success";
    }
    
    public List getVehicles() {
        BookingDetailsTO bto = (BookingDetailsTO) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ProcessBooking");
        if (this.vehicles == null || this.vehicles.size() == 0) {
            this.vehicles = new ArrayList<SelectItem>();
            
            List<VehicleTO> vtoList = vm.getVehiclesByBookingType(bto.getBookingType());
            
            for (VehicleTO vto : vtoList) {
                this.vehicles.add(new SelectItem(vto.getId().toString(), vto.getName()));
            }
        }
        return this.vehicles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

//    public Time getPickupTime() {
//        return pickupTime;
//    }

//    public void setPickupTime(Time pickupTime) {
//        this.pickupTime = pickupTime;
//    }

    public Date getDropoffDate() {
        return dropoffDate;
    }

    public void setDropoffDate(Date dropoffDate) {
        this.dropoffDate = dropoffDate;
    }

//    public Time getDropoffTime() {
//        return dropoffTime;
//    }
//
//    public void setDropoffTime(Time dropoffTime) {
//        this.dropoffTime = dropoffTime;
//    }

    public String getBookingType() {
        return bookingType;
    }

    public void setBookingType(String bookingType) {
        this.bookingType = bookingType;
    }

    public Integer getPickupPostCode() {
        return pickupPostCode;
    }

    public void setPickupPostCode(Integer pickupPostCode) {
        this.pickupPostCode = pickupPostCode;
    }

    public String getPickupCountryState() {
        return pickupCountryState;
    }

    public void setPickupCountryState(String pickupCountryState) {
        this.pickupCountryState = pickupCountryState;
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

    public String getPickupStreetNumber() {
        return pickupStreetNumber;
    }

    public void setPickupStreetNumber(String pickupStreetNumber) {
        this.pickupStreetNumber = pickupStreetNumber;
    }

    public String getPickupStreet() {
        return pickupStreet;
    }

    public void setPickupStreet(String pickupStreet) {
        this.pickupStreet = pickupStreet;
    }

    public String getPickupSuburb() {
        return pickupSuburb;
    }

    public void setPickupSuburb(String pickupSuburb) {
        this.pickupSuburb = pickupSuburb;
    }

    public Integer getDropoffPostCode() {
        return dropoffPostCode;
    }

    public void setDropoffPostCode(Integer dropoffPostCode) {
        this.dropoffPostCode = dropoffPostCode;
    }

    public String getDropoffCountryState() {
        return dropoffCountryState;
    }

    public void setDropoffCountryState(String dropoffCountryState) {
        this.dropoffCountryState = dropoffCountryState;
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

    public String getDropoffStreetNumber() {
        return dropoffStreetNumber;
    }

    public void setDropoffStreetNumber(String dropoffStreetNumber) {
        this.dropoffStreetNumber = dropoffStreetNumber;
    }

    public String getDropoffStreet() {
        return dropoffStreet;
    }

    public void setDropoffStreet(String dropoffStreet) {
        this.dropoffStreet = dropoffStreet;
    }

    public String getDropoffSuburb() {
        return dropoffSuburb;
    }

    public void setDropoffSuburb(String dropoffSuburb) {
        this.dropoffSuburb = dropoffSuburb;
    }

    public Boolean getProcessed() {
        return processed;
    }

    public void setProcessed(Boolean processed) {
        this.processed = processed;
    }

}
