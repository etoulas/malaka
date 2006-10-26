/*
 * AddressTO.java
 *
 * Created on 19 October 2006, 14:46
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package assign2.entities.to;

import assign2.entities.Address;

/**
 *
 * @author Gerard Gigliotti
 */
public class AddressTO
{
    private Long id;
    private Integer postCode;
    private String countryState;
    private String city;
    private String country;
    private String streetNumber;
    private String street;
    private String suburb;
    
    /** Creates a new instance of AddressTO */
    public AddressTO()
    {
    }

    public AddressTO(Address a) {
        
        this.id = a.getId();
        this.postCode = a.getPostCode();
        this.countryState = a.getCountryState();
        this.city = a.getCity();
        this.country = a.getCountry();
        this.streetNumber = a.getStreetNumber();
        this.street = a.getStreet();
        this.suburb = a.getSuburb();
        
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
