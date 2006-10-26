/*
 * EditDriverManagedBean.java
 *
 * Created on 26. Oktober 2006, 16:09
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package assign2.webapp.mbean;

import assign2.entities.to.AddressTO;
import assign2.entities.to.DriverDetailedTO;
import assign2.entities.to.ManagerDetailedTO;
import assign2.entities.to.UsersDetailedTO;
import assign2.session.UserManagerRemote;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;

/**
 *
 * @author Thorsten
 */
public class EditDriverManagedBean {
    
      
    @EJB
    UserManagerRemote um;
    
    
    private String username;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    
    // address data
    private Integer postCode;
    private String countryState;
    private String city;
    private String country;
    private String streetNumber;
    private String street;
    private String suburb;
    
    private DriverDetailedTO dto;
    
    /**
     * Creates a new instance of EditManagerManagedBean
     */
     /** Creates a new instance of EditDriverManagedBean */
    public EditDriverManagedBean() {
            
        this.dto =  (DriverDetailedTO)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("EditManagerSession");
       
        this.username = dto.getUsername();
        this.firstName = dto.getFirstName();
        this.lastName = dto.getLastName();
        this.phoneNumber = dto.getPhoneNumber();

        this.postCode = dto.getAddress().getPostCode();
        this.street = dto.getAddress().getStreet();
        this.streetNumber = dto.getAddress().getStreetNumber();
        this.suburb = dto.getAddress().getSuburb();
        this.city = dto.getAddress().getCity();
        this.country = dto.getAddress().getCountry();
        this.countryState = dto.getAddress().getCountryState();
        
    }
    
    public String EditDriver() {
        
        AddressTO ato = createAddress();
        DriverDetailedTO dto = new DriverDetailedTO();
        createUser(dto);
        dto.setAddress(ato);
        um.modifyDriver(dto);

        return "success";
    }
    
    private AddressTO createAddress() {
        
        AddressTO ato = new AddressTO();
        
        ato.setCity(this.getCity());
        ato.setCountry(this.getCountry());
        ato.setCountryState(this.getCountryState());
        ato.setPostCode(this.getPostCode());
        ato.setStreet(this.getStreet());
        ato.setStreetNumber(this.getStreetNumber());
        ato.setSuburb(this.getSuburb());

        return ato;
    }
 
    private void createUser(UsersDetailedTO uto) {
        
        uto.setFirstName(this.getFirstName());
        uto.setLastName(this.getLastName());
        uto.setUsername(this.getUsername());
        uto.setPhoneNumber(this.getPhoneNumber());
        
    }

    public String CancelEditDriver() {
        return "cancel";
    }

    public String ChangePassword() {
        
        //Add DriverDetailedTO to session
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("ChangePasswordSession", this.dto );

        return "password";
    } 
        
   public String DeleteDriver() {
       
       um.deleteUser(this.username);
       return "success";
   }
    
    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getPostCode() {
        return postCode;
    }

    public void setPostCode(Integer postCode) {
        this.postCode = postCode;
    }

    public String getCountryState() {
        return countryState;
    }

    public void setCountryState(String countryState) {
        this.countryState = countryState;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }
    
    
    
}
