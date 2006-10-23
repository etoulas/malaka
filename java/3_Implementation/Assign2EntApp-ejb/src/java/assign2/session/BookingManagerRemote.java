
package assign2.session;

import assign2.entities.to.BookingDetailsTO;
import javax.ejb.Remote;


/**
 * This is the business interface for ManageBookings enterprise bean.
 */
@Remote
public interface BookingManagerRemote {
    void createNewBooking(BookingDetailsTO bookingTO);

    java.util.List<assign2.entities.to.BookingTypeTO> getAllBookingTypes();

    assign2.entities.to.BookingTypeTO getBookingTypeById(Long id);
    
}
