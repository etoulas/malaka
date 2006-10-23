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
import assign2.entities.BookingType;
import assign2.entities.to.BookingDetailsTO;
import assign2.entities.to.BookingTypeTO;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
        bookingTO.setProcessed(false);
        Booking booking = new Booking(bookingTO);
        em.persist(booking);
    }
    
    public BookingTypeTO getBookingTypeById(Long id) {
        Query q = em.createNamedQuery("findBookingTypeByID");
        q.setParameter("id", id);
        BookingType bt = (BookingType) q.getSingleResult();
        return bt.getData();
    }
    
    public List<BookingTypeTO> getAllBookingTypes() {
        List<BookingTypeTO> bookingTypes = new ArrayList<BookingTypeTO>();
        Query q = em.createNamedQuery("findAllBookingTypes");
        List results = q.getResultList();
        
        for (Object item : results) {
            bookingTypes.add( ((BookingType) item).getData());
        }
        
        return bookingTypes;
    }
}
