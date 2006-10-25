
package assign2.session;

import assign2.entities.to.BookingDetailsTO;
import assign2.entities.to.BookingTypeTO;
import java.util.List;
import javax.ejb.Remote;


/**
 * This is the business interface for ManageBookings enterprise bean.
 */
@Remote
public interface BookingManagerRemote {
    void createNewBooking(BookingDetailsTO bookingTO);
    
    BookingTypeTO getBookingTypeById(Long id);
    BookingDetailsTO getBookingDetailsById(Long id);
    
    List<BookingTypeTO> getAllBookingTypes();
    List<BookingDetailsTO> getAllRequestedBookings();
    
}
