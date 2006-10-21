/*
 * ManageBookingsBean.java
 *
 * Created on October 20, 2006, 12:52 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package assign2.session;

import assign2.entities.Booking;
import assign2.entities.to.BookingDetailsTO;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ramu01
 */
@Stateless
public class BookingManager implements assign2.session.BookingManagerRemote, assign2.session.BookingManagerLocal {
    
    @PersistenceContext
    EntityManager em;
    
    /** Creates a new instance of ManageBookingsBean */
    public BookingManager() {
        
    }
    
    public void createNewBooking(BookingDetailsTO bookingTO) {
        Booking booking = new Booking(bookingTO);
        em.persist(booking);
    }
}
