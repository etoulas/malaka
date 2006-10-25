/*
 * processBookingBean.java
 *
 * Created on October 24, 2006, 5:36 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package assign2.webapp.mbean;

import assign2.entities.to.BookingDetailsTO;
import assign2.session.BookingManagerRemote;
import javax.ejb.EJB;

/**
 *
 * @author et
 */
public class processBookingBean {
    
    @EJB
    BookingManagerRemote bm;
    
    Long selectedBooking;
    
    
    /**
     * Creates a new instance of processBookingBean
     */
    public processBookingBean() {
    }
    
    public BookingDetailsTO getBookingDetailsById(Long selectedBooking) {
        return bm.getBookingDetailsById(selectedBooking);
    }
    
}
