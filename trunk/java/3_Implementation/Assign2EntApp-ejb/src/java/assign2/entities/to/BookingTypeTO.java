/*
 * BookingTypeTO.java
 *
 * Created on October 23, 2006, 1:57 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package assign2.entities.to;

/**
 *
 * @author ramu01
 */
public class BookingTypeTO {
    
    private Long id;
    private String description;
    
    
    /** Creates a new instance of BookingTypeTO */
    public BookingTypeTO() {
    }
    
    public BookingTypeTO(Long id, String description) {
        this.setId(id);
        this.setDescription(description);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public BookingTypeTO getData() {
        return new BookingTypeTO(this.id, this.description);
    }
}
