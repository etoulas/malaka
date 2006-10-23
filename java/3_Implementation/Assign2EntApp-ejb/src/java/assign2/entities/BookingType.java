/*
 * BookingType.java
 *
 * Created on 18 October 2006, 17:02
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package assign2.entities;

import assign2.entities.to.BookingTypeTO;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * Entity class BookingType
 *
 * @author Gerard Gigliotti
 */
@Entity
@NamedQueries({
    @NamedQuery(
    name="findAllBookingTypes",
            query="SELECT bt FROM BookingType bt"),
    @NamedQuery(
    name="findBookingTypeByID",
            query="SELECT bt FROM BookingType bt WHERE bt.id = :id")
})
public class BookingType implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length=200)
    private String description;
    
    /** Creates a new instance of BookingType */
    public BookingType() {
    }
    
    public BookingType(BookingTypeTO to) {
        this.setId(to.getId());
        this.setDescription(to.getDescription());
    }
    
    /**
     * Gets the id of this BookingType.
     * @return the id
     */
    public Long getId() {
        return this.id;
    }
    
    /**
     * Sets the id of this BookingType to the specified value.
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
     * Determines whether another object is equal to this BookingType.  The result is
     * <code>true</code> if and only if the argument is not null and is a BookingType object that
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BookingType)) {
            return false;
        }
        BookingType other = (BookingType)object;
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
        return "assign2.bookings.BookingType[id=" + id + "]";
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public BookingTypeTO getData() {
        
        BookingTypeTO to = new BookingTypeTO();
        to.setId(this.getId());
        to.setDescription(this.getDescription());
        return to;
    }
    
}
