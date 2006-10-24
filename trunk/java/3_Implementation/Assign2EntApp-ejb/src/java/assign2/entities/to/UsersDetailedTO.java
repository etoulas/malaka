/*
 * UsersDetailedTO.java
 *
 * Created on 19 October 2006, 14:44
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package assign2.entities.to;

/**
 *
 * @author Gerard Gigliotti
 */

public class UsersDetailedTO
{
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private AddressTO address;
    
    /** Creates a new instance of UsersDetailedTO */

    public UsersDetailedTO() {
        
    }
    
    public UsersDetailedTO(String username,String password,String firstName,String lastName,String phoneNumber,AddressTO address)
    {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
    
    public String getUsername()
    {
        return username;
    }
    
    public void setUsername(String username)
    {
        this.username = username;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public String getFirstName()
    {
        return firstName;
    }
    
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    
    public String getLastName()
    {
        return lastName;
    }
    
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    
    public String getPhoneNumber()
    {
        return phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }
    
    public AddressTO getAddress()
    {
        return address;
    }
    
    public void setAddress(AddressTO address)
    {
        this.address = address;
    }
    
}
