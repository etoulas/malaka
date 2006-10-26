/*
 * Address.java
 *
 * Created on 16 October 2006, 20:53
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package assign2.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import assign2.entities.to.*;
/**
 * Entity class Address
 * 
 * @author Gerard Gigliotti
 */
@Entity
public class Address implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length=4)
    private Integer postCode;
    @Column(length=20)
    private String countryState;
    @Column(length=20)
    private String city;
    @Column(length=50)
    private String country;
    @Column(length=5)
    private String streetNumber;
    @Column(length=100)
    private String street;
    @Column(length=100)
    private String suburb;
    
    
    /** Creates a new instance of Address */
    public Address()
    {
    }
    
    public Address(AddressTO to) {
        
        
        this.setPostCode(to.getPostCode());
        this.setCity(to.getCity());
        this.setCountry(to.getCountry());
        this.setCountryState(to.getCountryState());
        this.setStreet(to.getStreet());
        this.setStreetNumber(to.getStreetNumber());
        this.setSuburb(to.getSuburb());
        
    }

    /**
     * Gets the id of this Address.
     * @return the id
     */
    public Long getId()
    {
        return this.id;
    }

    /**
     * Sets the id of this Address to the specified value.
     * @param id the new id
     */
    public void setId(Long id)
    {
        this.id = id;
    }

    /**
     * Returns a hash code value for the object.  This implementation computes 
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    /**
     * Determines whether another object is equal to this Address.  The result is 
     * <code>true</code> if and only if the argument is not null and is a Address object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address)object;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString()
    {
        return "assign2.users.Address[id=" + id + "]";
    }
    
    public AddressTO getData()
    {
        return null;
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
