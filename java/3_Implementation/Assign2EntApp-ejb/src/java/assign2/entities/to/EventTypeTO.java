/*
 * EventTypeTO.java
 *
 * Created on 26 October 2006, 01:47
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package assign2.entities.to;

/**
 *
 * @author Gerard
 */
public class EventTypeTO {
    private Long id;
    private String description;

    /** Creates a new instance of EventTypeTO */
    public EventTypeTO() {
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
    
}
