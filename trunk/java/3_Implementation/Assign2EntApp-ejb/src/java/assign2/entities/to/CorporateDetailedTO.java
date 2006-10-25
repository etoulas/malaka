/*
 * CorporateDetailedTO.java
 *
 * Created on 19 October 2006, 16:13
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package assign2.entities.to;

/**
 *
 * @author Gerard Gigliotti
 */
public class CorporateDetailedTO extends UsersDetailedTO
{
    
    private String companyName; 
    /** Creates a new instance of CorporateDetailedTO */

    public CorporateDetailedTO() {
        
    }
    
 /*   public CorporateDetailedTO(String username,String password,String firstName,String lastName,String phoneNumber,AddressTO address, String companyName)
    {
         super(username,password,firstName,lastName,phoneNumber,address);
         this.setCompanyName(companyName);
    }
*/
    
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    
}
