
package assign2.session;

import assign2.entities.to.BookingDetailsTO;
import javax.ejb.Local;


/**
 * This is the business interface for ManageBookings enterprise bean.
 */
@Local
public interface BookingManagerLocal {
    void createNewBooking(BookingDetailsTO bookingTO);

    java.util.List<assign2.entities.to.BookingTypeTO> getAllBookingTypes();

    assign2.entities.to.BookingTypeTO getBookingTypeById(Long id);
    
}
