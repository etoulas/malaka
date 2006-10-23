
package assign2.session;

import assign2.entities.to.VehicleTO;
import javax.ejb.Local;


/**
 * This is the business interface for VehicleManager enterprise bean.
 */
@Local
public interface VehicleManagerLocal
{
    java.util.List<assign2.entities.to.VehicleTypeTO> getAllVehicleTypeTOs();

    java.util.List<assign2.entities.to.VehicleLicenseTO> getAllVehicleLicenseTOs();

    void createVehicle(VehicleTO to);

    assign2.entities.to.VehicleTypeTO getVehicleTypeTO(String code);

    assign2.entities.to.VehicleLicenseTO getVehicleLicenseTO(Long id);

    java.util.List<assign2.entities.to.VehicleTO> getAllVehicleTOs();

    void modifyVehicle(VehicleTO to);

}
