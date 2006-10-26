/*
 * Corporate.java
 *
 * Created on 16 October 2006, 21:47
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package assign2.entities;

import assign2.entities.to.CorporateDetailedTO;
import assign2.entities.to.CorporateTO;
import assign2.entities.to.UsersDetailedTO;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * Entity class Corporate
 * 
 * @author Gerard Gigliotti
 */
@Entity
@NamedQueries(
{    
    @NamedQuery(
    name="findAllCustomers",
            query="SELECT c FROM Corporate c WHERE c.enabled = true"
            ),

    @NamedQuery(
    name="findCustomerByUsername",
            query="SELECT c FROM Corporate c WHERE c.username = :username"
            )
})

public class Corporate extends Users implements Serializable
{   
    @Column(length=100)
    private String companyName;
    
    /** Creates a new instance of Corporate */
    public Corporate()
    {
    }
 
    public Corporate(CorporateDetailedTO to) {
        super(to);
        this.companyName = to.getCompanyName();
    }
    
    public Corporate(String username,String password)
    {
       super(username,password);
    }

    public String getCompanyName()
    {
        return companyName;
    }

    public void setCompanyName(String companyName)
    {
        this.companyName = companyName;
    }

    public UsersDetailedTO getDetailedData() {
        return null;
    }
    
    public CorporateTO getData() {
        CorporateTO to = new CorporateTO(getUsername(),getFirstName(),getLastName());
        return to;
    }

}
