/*
 * listRequestedBookingsBean.java
 *
 * Created on October 24, 2006, 10:06 PM
 *
 */

package assign2.webapp.mbean;

import assign2.entities.to.BookingDetailsTO;
import assign2.session.BookingManagerRemote;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
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
    
    public String selectProcessBooking() {
        System.out.println(model.getRowData().toString());
        BookingDetailsTO bto = (BookingDetailsTO) this.model.getRowData();
        //System.out.println("Adding Booking to Session. Variable ProcessBooking");
        // Add bto to session
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("ProcessBooking", bto);
        System.out.println("Session[ProcessBooking]: ");
        System.out.println(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ProcessBooking"));
        return "process_booking";
    }
    
    public String assignDriverVehicle() {
        // TODO
        return "success";
    }
    
    public DataModel getModel() {
        return model;
    }
    
    public void setModel(DataModel model) {
        this.model = model;
    }

}
