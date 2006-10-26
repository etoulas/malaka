/*
 * Users.java
 *
 * Created on 16 October 2006, 16:28
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package assign2.entities;

import assign2.entities.to.*;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 * Entity class Users
 *
 * @author Gerard Gigliotti
 */
@Entity
@NamedQueries(
{
    @NamedQuery(
    name="findUserByUsername",
            query="SELECT u FROM Users u WHERE u.username = :username"
            )
            
})
public abstract class Users implements Serializable {
    
    @Id
    protected String username;
    @Column(length=60)
    protected String password;
    @Column(length=60)
    protected String firstName;
    @Column(length=60)
    protected String lastName;
    @Column(length=10)
    protected String phoneNumber;
    @OneToOne(cascade=CascadeType.ALL)
    protected Address address;
    @Column(name="Status")
    private Boolean enabled;

    
    
    /** Creates a new instance of Users */
    public Users() {
        this.enabled = true;
    }
    
    public Users(UsersDetailedTO to) {
        
        this.enabled = true;
        this.setFirstName(to.getFirstName());
        this.setLastName(to.getLastName());
        this.setPassword(to.getPassword());
        this.setPhoneNumber(to.getPhoneNumber());
        this.setUsername(to.getUsername());
        
        Address a = new Address(to.getAddress());
        
        
        this.setAddress(a);
        
    }
    
    
    public Users(String username,String password) {
        this.username = username;
        this.setPassword(password);
    }
    
    /**
     * Gets the username of this Users.
     * @return the username
     */
    public String getUsername() {
        return this.username;
    }
    
    /**
     * Sets the username of this Users to the specified value.
     * @param username the new username
     */
    public void setUsername(String username) {
        this.username = username;
    }
    
    public int hashCode() {
        int hash = 0;
        hash += (this.username != null ? this.username.hashCode() : 0);
        return hash;
    }
    
    /**
     * Determines whether another object is equal to this Users.  The result is
     * <code>true</code> if and only if the argument is not null and is a Users object that
     * has the same username field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the username fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users)object;
        if (this.username != other.username && (this.username == null || !this.username.equals(other.username))) return false;
        return true;
    }
    
    /**
     * Returns a string representation of the object.  This implementation constructs
     * that representation based on the username fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "assign2.users.Users[username=" + username + "]";
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
    
    public Address getAddress() {
        return address;
    }
    
 /*   public void setAddress(AddressTO ato) {
        address.setCity(ato.getCity());
        address.setCountry(ato.getCountry());
        address.setCountryState(ato.getCountryState());
        address.setPostCode(ato.getPostCode());
        address.setStreet(ato.getStreet());
        address.setStreetNumber(ato.getStreetNumber());
        address.setSuburb(ato.getSuburb());
    }*/
    
    public void setAddress(Address a) {
        this.address = a;
    }
    
    public UsersTO getData() {
        UsersTO to = new UsersTO(getUsername(),getFirstName(),getLastName());
        return to;
    }
    
    public abstract UsersDetailedTO getDetailedData();

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
