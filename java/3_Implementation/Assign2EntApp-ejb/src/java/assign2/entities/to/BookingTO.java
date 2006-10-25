/*
 * BookingTO.java
 *
 * Created on 26 October 2006, 00:11
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package assign2.entities.to;

/**
 *
 * @author Gerard
 */
public class BookingTO {
    private String contactName;
    private String customerName;
    private VehicleTO vehicle;

    /** Creates a new instance of BookingTO */
    public BookingTO() {
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public VehicleTO getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleTO vehicle) {
        this.vehicle = vehicle;
    }
    
}
