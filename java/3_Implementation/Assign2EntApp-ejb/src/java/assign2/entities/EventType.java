/*
 * EventType.java
 *
 * Created on 18 October 2006, 20:22
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package assign2.entities;

import assign2.entities.to.EventTypeTO;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * Entity class EventType
 *
 * @author Gerard Gigliotti
 */
@Entity
@NamedQueries({
    @NamedQuery(
    name="findEventType",
            query="SELECT ev FROM EventType ev"),
            @NamedQuery(
    name="findEventTypeByBookingID",
            query="SELECT ev FROM EventType ev WHERE ev.type = :type"),
            @NamedQuery(
    name="findEventTypeByID",
            query="SELECT ev FROM EventType ev WHERE ev.id = :id")
}
)
public class EventType implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String description;
    @ManyToOne
    @JoinColumn(name="bookingType")
    private BookingType type;
    
    /** Creates a new instance of EventType */
    public EventType() {
    }
    
    /**
     * Gets the id of this EventType.
     * @return the id
     */
    public Long getId() {
        return this.id;
    }
    
    /**
     * Sets the id of this EventType to the specified value.
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
     * Determines whether another object is equal to this EventType.  The result is
     * <code>true</code> if and only if the argument is not null and is a EventType object that
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EventType)) {
            return false;
        }
        EventType other = (EventType)object;
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
        return "assign2.bookings.EventType[id=" + id + "]";
    }
    
    public EventTypeTO getData() {
        EventTypeTO to = new EventTypeTO();
        to.setId(getId());
        to.setDescription(getDescription());
        return to;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
}
