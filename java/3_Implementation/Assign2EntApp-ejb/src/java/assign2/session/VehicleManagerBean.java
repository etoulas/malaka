/*
 * VehicleManagerBean.java
 *
 * Created on 21 October 2006, 01:06
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package assign2.session;

import assign2.entities.Vehicle;
import assign2.entities.VehicleLicense;
import assign2.entities.VehicleType;
import assign2.entities.to.VehicleLicenseTO;
import assign2.entities.to.VehicleTO;
import assign2.entities.to.VehicleTypeTO;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Gerard Gigliotti
 */
@Stateless
public class VehicleManagerBean implements assign2.session.VehicleManagerRemote, assign2.session.VehicleManagerLocal
{
    @PersistenceContext
    EntityManager em;
    
    /** Creates a new instance of VehicleManagerBean */
    public VehicleManagerBean()
    {
    }
    
    public void createVehicle(VehicleTO to)
    {
        Vehicle v = new Vehicle();
        v.setColour(to.getColour());
        v.setName(to.getName());
        v.setYear(to.getYear());
        v.setType( getVehicleType(to.getType().getCode()));
        v.setLicense(getVehicleLicense(to.getLicense().getId()));  
        em.persist(v);
    }
    
    public VehicleType getVehicleType(String code)
    {
        VehicleType vt = em.find(VehicleType.class,code);
        return vt;
    }
    
    public VehicleTypeTO getVehicleTypeTO(String code)
    {
        VehicleType vt = getVehicleType(code);
        return vt.getData();
    }
       
    public VehicleLicense getVehicleLicense(Long id)
    {
        VehicleLicense vl = em.find(VehicleLicense.class,id);
        return vl;
    }

    public VehicleLicenseTO getVehicleLicenseTO(Long id)
    {
         VehicleLicense vl = getVehicleLicense(id);
         return vl.getData();
    }
    
    public List<VehicleTO> getAllVehicleTOs()
    {
        List<VehicleTO> results = new ArrayList<VehicleTO>();
        Query allVehicleTypesQuery = em.createNamedQuery("findAllVehicles");
         List dbResults = allVehicleTypesQuery.getResultList();
        for (int i = 0; i < dbResults.size(); i++)
        {
            Vehicle v = (Vehicle)dbResults.get(i);
            results.add(v.getData());
        }
        return results;
    }
    /*This method cycles through the getVehicle Methods and returns the tranfer objects for all vehicle types.*/
    public List<VehicleTypeTO> getAllVehicleTypeTOs()
    {
        List<VehicleTypeTO> results = new ArrayList<VehicleTypeTO>();
        Query allVehicleTypesQuery = em.createNamedQuery("findAllVehicleTypes");
        List dbResults = allVehicleTypesQuery.getResultList();
        
        for (int i = 0; i < dbResults.size(); i++)
        {
            VehicleType vt = (VehicleType)dbResults.get(i);
            results.add(vt.getData());
        }

        return results;
    }
    
    /*This method cycles through all Vehicle Licenses and returns them as TOs.*/
    public List<VehicleLicenseTO> getAllVehicleLicenseTOs()
    {
        List<VehicleLicenseTO> results = new ArrayList<VehicleLicenseTO>();
        Query allVehicleLicensesQuery = em.createNamedQuery("findAllVehicleLicenses");
        List dbResults = allVehicleLicensesQuery.getResultList();
        
        for (int i = 0; i < dbResults.size(); i++)
        {
            VehicleLicense vl = (VehicleLicense)dbResults.get(i);
            results.add(vl.getData());
        }
        return results;
    }
}
