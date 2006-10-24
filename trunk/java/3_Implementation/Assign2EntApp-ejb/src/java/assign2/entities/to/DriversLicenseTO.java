/*
 * DriversLicenseTO.java
 *
 * Created on 19 October 2006, 15:39
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package assign2.entities.to;

/**
 *
 * @author Gerard Gigliotti
 */
public class DriversLicenseTO
{
    
    private String type;
    private String description;
    
    /** Creates a new instance of DriversLicenseTO */
    public DriversLicenseTO()
    {
    }
    
    public void setType(String type) {
       this.type = type; 
    }

    public String getType () {
        return this.type;
    }
    
    public void setDescription(String descr) {
        this.description = descr;
    }

    public String getDescription () {
        return this.description;
    }
    
}
