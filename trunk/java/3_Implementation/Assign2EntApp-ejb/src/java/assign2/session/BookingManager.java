/*
 * ManageBookingsBean.java
 *
 * Created on October 20, 2006, 12:52 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package assign2.session;

import assign2.entities.Address;
import assign2.entities.Booking;
import assign2.entities.BookingType;
import assign2.entities.EventType;
import assign2.entities.Vehicle;
import assign2.entities.to.BookingDetailsTO;
import assign2.entities.to.BookingTO;
import assign2.entities.to.BookingTypeTO;
import assign2.entities.to.EventTypeTO;
import assign2.entities.to.VehicleTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
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
    @EJB
    VehicleManagerLocal vm;
    /** Creates a new instance of ManageBookingsBean */
    public BookingManager() {
        
    }
    
    public void createNewBooking(BookingDetailsTO bookingTO) {
        bookingTO.setProcessed(false);
        Booking booking = new Booking();
        booking.setContactName(bookingTO.getContactName());
        booking.setCustomerName(bookingTO.getCustomerName());
        booking.setDropoffDate(bookingTO.getDropoffDate());
        booking.setPickupDate(bookingTO.getPickupDate());
        booking.setBookingType(getBookingTypeByIdEntity(bookingTO.getBookingType().getId()));
        booking.setPickupAddress(new Address(bookingTO.getPickupAddress()));
        booking.setDropoffAddress(new Address(bookingTO.getDropoffAddress()));
        booking.setVehicleType(vm.getVehicleType(bookingTO.getVehicleType().getCode()));
        booking.setEventType(getEventEntityById(bookingTO.getEventType().getId()));
        booking.setFreeField(bookingTO.getFreeNotes());
        booking.setContactName(bookingTO.getPhoneNumber());
        em.persist(booking);
    }
    
    private BookingType getBookingTypeByIdEntity(Long id) {
        Query q = em.createNamedQuery("findBookingTypeByID");
        q.setParameter("id", id);
        BookingType bt = (BookingType) q.getSingleResult();
        return bt;
    }
    
    public BookingTypeTO getBookingTypeById(Long id) {
        return getBookingTypeByIdEntity(id).getData();
    }
    
    public EventTypeTO getEventTypeById(Long id) {
        return getEventEntityById(id).getData();
    }
    
    public EventType getEventEntityById(Long id) {
        Query q = em.createNamedQuery("findEventTypeByID");
        q.setParameter("id",id);
        EventType to = (EventType)q.getSingleResult();
                return to;
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
    
    public BookingDetailsTO getBookingDetailsById(Long id) {
        Query q = em.createNamedQuery("findBookingDetailsByID");
        q.setParameter("id", id);
        Booking b = (Booking) q.getSingleResult();
        return b.getData();
    }
    
    public List<BookingDetailsTO> getAllRequestedBookings() {
        List<BookingDetailsTO> requestedBookings = new ArrayList<BookingDetailsTO>();
        
        Query q = em.createNamedQuery("findRequestedBookings");
        q.setParameter("proc", Boolean.FALSE);
        List results = q.getResultList();
        
        for (Object item : results) {
            requestedBookings.add( ((Booking) item).getData() );
        }
        
        return requestedBookings;
    }
    
    /*This method will retrieve all bookings that occur within a timeframe */
    public List<BookingDetailsTO> getBookingsInTimeFrame(Date pickupDate,Date dropoffDate) {
        Query q = em.createNamedQuery("findBookingByDates");
        q.setParameter("pickupDate1",pickupDate,javax.persistence.TemporalType.TIMESTAMP);
        q.setParameter("dropoffDate1",dropoffDate,javax.persistence.TemporalType.TIMESTAMP);
        q.setParameter("pickupDate2",pickupDate,javax.persistence.TemporalType.TIMESTAMP);
        q.setParameter("dropoffDate2",dropoffDate,javax.persistence.TemporalType.TIMESTAMP);
        List barray = q.getResultList();
        List bookingTOs = new ArrayList();
        
        for (Object item : barray) {
            bookingTOs.add( ((Booking) item).getData());
        }
        
        return bookingTOs;
    }
    
    //This method gets all availible vehicles in a particular time period.
    public List<VehicleTO> getVehiclesAvailableInTimeFrame(Date pickupDate,Date dropoffDate) {
        ArrayList bookings = (ArrayList)getBookingsInTimeFrame(pickupDate,dropoffDate);
        
        ArrayList allVehicles = (ArrayList)vm.getAllVehicleTOs();
        ArrayList returnVehicles = new ArrayList();
        
        for(int i = 0;i<bookings.size()-1;i++) {
            Booking b =(Booking)bookings.get(i);
            BookingTO bt = b.getSimpleData();
            
            for(int j=0;j<allVehicles.size()-1;i++) {
                Vehicle vh = (Vehicle)allVehicles.get(j);
                VehicleTO v = vh.getData();
                
                if (bt.getVehicle().equals(v)) {
                    returnVehicles.add(v);
                }
            }
        }
        return null;
    }
    
    //Get All Event
    public List<EventTypeTO> getAllEventTypes() {
        Query q = em.createNamedQuery("findEventType");
        List eventType = q.getResultList();
        List eTO = new ArrayList();
        
        for (Object item : eventType) {
            eTO.add(((EventType)item).getData());
        }
        
        return eTO;
    }
    
    public List<EventTypeTO> getEventTypeFromBookingType(BookingTypeTO bt) {
        Query q = em.createNamedQuery("findEventTypeByBookingID");
        q.setParameter("type",getBookingTypeByIdEntity(bt.getId()));
        List eventType = q.getResultList();
        List eTO = new ArrayList();
        
        for (Object item : eventType) {
            eTO.add(((EventType)item).getData());
        }
        
        return eTO;
    }
    
}
