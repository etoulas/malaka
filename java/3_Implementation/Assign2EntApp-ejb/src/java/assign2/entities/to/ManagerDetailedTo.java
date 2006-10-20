/*
 * ManagerDetailedTo.java
 *
 * Created on 19 October 2006, 16:06
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package assign2.entities.to;

/**
 *
 * @author Gerard Gigliotti
 */
public class ManagerDetailedTo extends UsersDetailedTO
{
    
    /**
     * Creates a new instance of ManagerDetailedTo
     */
    public ManagerDetailedTo(String username,String password,String firstName,String lastName,String phoneNumber,AddressTO address)
    {
         super(username,password,firstName,lastName,phoneNumber,address);
    }
    
}
