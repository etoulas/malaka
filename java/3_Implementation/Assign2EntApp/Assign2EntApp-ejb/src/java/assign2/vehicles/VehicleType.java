/*
 * VehicleType.java
 *
 * Created on 16 October 2006, 22:45
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package assign2.vehicles;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;

/**
 * Entity class VehicleType
 * 
 * @author Gerard Gigliotti
 */
@Entity
public class VehicleType implements Serializable
{

    @Id
    private String code;
    @Column()
    private String description;
    @Column()
    private Integer seats;
    
    /** Creates a new instance of VehicleType */
    public VehicleType()
    {
    }

    /**
     * Gets the code of this VehicleType.
     * 
     * @return the code
     */
    public String getId()
    {
        return this.code;
    }

    /**
     * Sets the code of this VehicleType to the specified value.
     * 
     * @param code the new code
     */
    public void setId(String id)
    {
        this.code = id;
    }

    /**
     * Returns a hash code value for the object.  This implementation computes 
     * a hash code value based on the code fields in this object.
     * 
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (this.code != null ? this.code.hashCode() : 0);
        return hash;
    }

    /**
     * Determines whether another object is equal to this VehicleType.  The result is 
     * <code>true</code> if and only if the argument is not null and is a VehicleType object that 
     * has the same code field values as this object.
     * 
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the code fields are not set
        if (!(object instanceof VehicleType)) {
            return false;
        }
        VehicleType other = (VehicleType)object;
        if (this.code != other.code && (this.code == null || !this.code.equals(other.code))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the code fields.
     * 
     * @return a string representation of the object.
     */
    @Override
    public String toString()
    {
        return "assign2.vehicles.VehicleType[id=" + code + "]";
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Integer getSeats()
    {
        return seats;
    }

    public void setSeats(Integer seats)
    {
        this.seats = seats;
    }
    
}
