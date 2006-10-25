/*
 * listRequestedBookingsBean.java
 *
 * Created on October 24, 2006, 10:06 PM
 *
 */

package assign2.webapp.mbean;

import assign2.entities.to.AddressTO;
import assign2.entities.to.BookingTypeTO;
import assign2.session.BookingManagerRemote;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author et
 */
public class listRequestedBookingsBean {
    
    @EJB
    BookingManagerRemote bm;
    
    private DataModel model;
    
    /** Creates a new instance of listRequestedBookingsBean */
    public listRequestedBookingsBean() {
    }
    
    public DataModel getRequestedBookings() {
        this.setModel(new ListDataModel(bm.getAllRequestedBookings()));
        return this.getModel();
    }

    public DataModel getModel() {
        return model;
    }

    public void setModel(DataModel model) {
        this.model = model;
    }
    
}
