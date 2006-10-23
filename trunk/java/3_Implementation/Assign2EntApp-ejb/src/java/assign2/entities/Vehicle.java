/*
 * Vehicle.java
 *
 * Created on 16 October 2006, 22:39
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package assign2.entities;

import assign2.entities.to.VehicleTO;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


/**
 * Entity class Vehicle
 *
 * @author Gerard Gigliotti
 */
@Entity
@NamedQueries(
{
    @NamedQuery(
    name="findAllVehicles",
            query="SELECT v FROM Vehicle v WHERE v.enabled = true"
            ),
            @NamedQuery(
    name="findVehicleById",
            query="SELECT v FROM Vehicle v WHERE v.id = :vehicleID"
            )
})
public class Vehicle implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String colour;
    @Column(name="VName")
    private String name;
    @ManyToOne()
    @JoinColumn(name="VehicleType")
    private VehicleType type;
    @ManyToOne()
    @JoinColumn(name="VehicleLicense")
    private VehicleLicense license;
    @Column(name="VYear")
    private Integer year;
    @Column(name="Status")
    private Boolean enabled;
    
    /** Creates a new instance of Vehicle */
    public Vehicle() {
    }
    
    public Vehicle(String colour, String name, VehicleType type, VehicleLicense license,Integer year) {
        this.colour = colour;
        this.name = name;
        this.type = type;
        this.license = license;
        this.year = year;
        this.setEnabled(true);
    }
    /**
     * Gets the id of this Vehicle.
     * @return the id
     */
    public Long getId() {
        return this.id;
    }
    
    /**
     * Sets the id of this Vehicle to the specified value.
     * @param id the new id
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * Returns a hash code value for the object.  This implementation computes
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }
    
    /**
     * Determines whether another object is equal to this Vehicle.  The result is
     * <code>true</code> if and only if the argument is not null and is a Vehicle object that
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehicle)) {
            return false;
        }
        Vehicle other = (Vehicle)object;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) return false;
        return true;
    }
    
    /**
     * Returns a string representation of the object.  This implementation constructs
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "assign2.vehicles.Vehicle[id=" + id + "]";
    }
    
    public String getColour() {
        return colour;
    }
    
    public void setColour(String colour) {
        this.colour = colour;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public VehicleType getType() {
        return type;
    }
    
    public void setType(VehicleType type) {
        this.type = type;
    }
    
    public Integer getYear() {
        return year;
    }
    
    public void setYear(Integer year) {
        this.year = year;
    }
    
    public VehicleLicense getLicense() {
        return license;
    }
    
    public void setLicense(VehicleLicense license) {
        this.license = license;
    }
    
    public VehicleTO getData() {
        VehicleTO to = new VehicleTO();
        to.setColour(colour);
        to.setName(name);
        to.setLicense(license.getData());
        to.setType(type.getData());
        to.setYear(year);
        to.setEnabled(getEnabled());
        to.setId(id);
        return to;
    }
    
    public Boolean getEnabled() {
        return enabled;
    }
    
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
