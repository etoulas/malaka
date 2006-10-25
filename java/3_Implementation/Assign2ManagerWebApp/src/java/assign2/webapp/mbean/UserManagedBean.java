/*
 * UserManagedBean.java
 *
 * Created on 24. Oktober 2006, 16:50
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package assign2.webapp.mbean;

import assign2.entities.to.AddressTO;
import assign2.entities.to.CorporateDetailedTO;
import assign2.entities.to.DriverDetailedTO;
import assign2.entities.to.DriversLicenseTO;
import assign2.entities.to.ManagerDetailedTO;
import assign2.entities.to.UsersDetailedTO;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import assign2.session.UserManagerRemote;
import javax.ejb.EJB;

/**
 *
 * @author Thorsten
 */

public class UserManagedBean {
    
    @EJB
    UserManagerRemote um;
    
    
    private String username;
    private String password;
    private String repPassword;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String company;
    private Long selectedLicenseType;
    private List<SelectItem> licenseTypes;

    // address data
    private Integer postCode;
    private String countryState;
    private String city;
    private String country;
    private String streetNumber;
    private String street;
    private String suburb;
    
    /**
     * Creates a new instance of UserManagedBean
     */
    public UserManagedBean() {
    }
    
    
    public String CreateManager() {
        
        AddressTO ato = createAddress();
        ManagerDetailedTO mto = new ManagerDetailedTO();
        createUser(mto);
        mto.setAddress(ato);
        um.createManager(mto);
        
        return "success";
    }
    

    public String CreateDriver() {
        
        AddressTO ato = createAddress();
        //DriverDetailedTO dto = (DriverDetailedTO)createUser();
        DriverDetailedTO dto = new DriverDetailedTO();
        createUser(dto);
        DriversLicenseTO dlto = um.getLicenseTypeById(this.selectedLicenseType);
        dto.setLicense(dlto);
        dto.setAddress(ato);
        um.createDriver(dto);
        
        return "success";
    }
    
        public String CreateCustomer() {
        
        AddressTO ato = createAddress();
        //CorporateDetailedTO cto = (CorporateDetailedTO)createUser();
        CorporateDetailedTO cto = new CorporateDetailedTO();
        createUser(cto);
        cto.setAddress(ato);
        cto.setCompanyName(this.company);
        um.createCustomer(cto);

        
        return "success";
    }

  
    public List getLicenseTypes() {
        
        if (this.licenseTypes == null) {
            this.licenseTypes = new ArrayList<SelectItem>();
            List<DriversLicenseTO> types = um.getAllLicenseTypes();
            for (DriversLicenseTO to : types) {
                this.licenseTypes.add(new SelectItem(to.getId().toString(), to.getType() ));
            }
        }
        return licenseTypes;
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
        
        uto.setFirstName(this.firstName);
        uto.setLastName(this.lastName);
        uto.setUsername(this.username);
        uto.setPassword(this.password);
        uto.setPhoneNumber(this.phoneNumber);
        
    }
    
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
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

    public String getRepPassword() {
        return repPassword;
    }

    public void setRepPassword(String repPassword) {
        this.repPassword = repPassword;
    }

    public Long getSelectedLicenseType() {
        return selectedLicenseType;
    }

    public void setSelectedLicenseType(Long selectedLicenseType) {
        this.selectedLicenseType = selectedLicenseType;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
    
    
    
}
