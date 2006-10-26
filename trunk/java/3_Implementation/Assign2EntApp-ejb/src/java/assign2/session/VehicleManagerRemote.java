
package assign2.session;

import assign2.entities.to.BookingTypeTO;
import assign2.entities.to.VehicleLicenseTO;
import assign2.entities.to.VehicleTO;
import assign2.entities.to.VehicleTypeTO;
import java.util.List;
import javax.ejb.Remote;


/**
 * This is the business interface for VehicleManager enterprise bean.
 */
@Remote
public interface VehicleManagerRemote
{
    List<VehicleTypeTO> getAllVehicleTypeTOs();

    List<VehicleLicenseTO> getAllVehicleLicenseTOs();

    void createVehicle(VehicleTO to);

    assign2.entities.to.VehicleTypeTO getVehicleTypeTO(String code);

    assign2.entities.to.VehicleLicenseTO getVehicleLicenseTO(Long id);    

    java.util.List<assign2.entities.to.VehicleTO> getAllVehicleTOs();

    void modifyVehicle(VehicleTO to);

    List<VehicleTO> getVehiclesByBookingType(BookingTypeTO bto);

}
