/*
 * Booking.java
 *
 * Created on 18 October 2006, 13:13
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package assign2.entities;

import assign2.entities.to.BookingDetailsTO;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Temporal;
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 * Entity class Booking
 * 
 * @author Gerard Gigliotti
 */
@Entity

@Table(name="BOOKING")
public class Booking implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length=60)
    private String contactName;
    @Column(length=60)
    private String customerName;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date pickupDate;
    @Column
    private Boolean processed;
    @OneToOne(cascade=CascadeType.ALL)
    private Address pickupAddress;
    @OneToOne(cascade=CascadeType.ALL)
    private Address dropoffAddress;
    @ManyToOne()
    private VehicleType vehicleType;
    @ManyToOne()
    private Driver driver;
    @ManyToOne()
    private Users customer;
    @Column()
    private String specialRequirements;
    @Column
    private String freeField;
    @ManyToOne
    private BookingType bookingType;
    
    /** Creates a new instance of Booking */
    public Booking()
    {
    }

    public Booking(BookingDetailsTO bookingTO) {
        this.setContactName(bookingTO.getContactName());
        this.setCustomerName(bookingTO.getCustomerName());
        this.setPickupDate(bookingTO.getPickupDate());
        this.setBookingType(new BookingType(bookingTO.getBookingType()));
        this.setPickupAddress(new Address(bookingTO.getPickupAddress()));
        this.setProcessed(bookingTO.getProcessed());
    }
    /**
     * Gets the id of this Booking.
     * @return the id
     */
    public Long getId()
    {
        return this.id;
    }

    /**
     * Sets the id of this Booking to the specified value.
     * @param id the new id
     */
    public void setId(Long id)
    {
        this.id = id;
    }

    /**
     * Returns a hash code value for the object.  This implementation computes 
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    /**
     * Determines whether another object is equal to this Booking.  The result is 
     * <code>true</code> if and only if the argument is not null and is a Booking object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Booking)) {
            return false;
        }
        Booking other = (Booking)object;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString()
    {
        return "assign2.bookings.Booking[id=" + id + "]";
    }

    public String getContactName()
    {
        return contactName;
    }

    public void setContactName(String contactName)
    {
        this.contactName = contactName;
    }

    public String getCustomerName()
    {
        return customerName;
    }

    public void setCustomerName(String customerName)
    {
        this.customerName = customerName;
    }

    public Date getPickupDate()
    {
        return pickupDate;
    }

    public void setPickupDate(Date pickupDate)
    {
        this.pickupDate = pickupDate;
    }

    public Address getPickupAddress()
    {
        return pickupAddress;
    }

    public void setPickupAddress(Address pickupAddress)
    {
        this.pickupAddress = pickupAddress;
    }

    public Address getDropoffAddress()
    {
        return dropoffAddress;
    }

    public void setDropoffAddress(Address dropoffAddress)
    {
        this.dropoffAddress = dropoffAddress;
    }

    public VehicleType getVehicleType()
    {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType)
    {
        this.vehicleType = vehicleType;
    }

    public Driver getDriver()
    {
        return driver;
    }

    public void setDriver(Driver driver)
    {
        this.driver = driver;
    }

    public Users getCustomer()
    {
        return customer;
    }

    public void setCustomer(Users customer)
    {
        this.customer = customer;
    }

    public String getSpecialRequirements()
    {
        return specialRequirements;
    }

    public void setSpecialRequirements(String specialRequirements)
    {
        this.specialRequirements = specialRequirements;
    }

    public String getFreeField()
    {
        return freeField;
    }

    public void setFreeField(String freeField)
    {
        this.freeField = freeField;
    }

    public BookingType getBookingType()
    {
        return bookingType;
    }

    public void setBookingType(BookingType bookingType)
    {
        this.bookingType = bookingType;
    }

    public Boolean getProcessed() {
        return processed;
    }

    public void setProcessed(Boolean processed) {
        this.processed = processed;
    }
    
}
