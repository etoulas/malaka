
package assign2.session;

import assign2.entities.to.BookingDetailsTO;
import javax.ejb.Remote;


/**
 * This is the business interface for ManageBookings enterprise bean.
 */
@Remote
public interface BookingManagerRemote {
    void createBooking(BookingDetailsTO bookingTO);
    
}
