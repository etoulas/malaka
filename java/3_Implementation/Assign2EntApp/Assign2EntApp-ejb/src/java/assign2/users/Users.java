/*
 * Users.java
 *
 * Created on 16 October 2006, 16:28
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package assign2.users;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;

/**
 * Entity class Users
 * 
 * @author Gerard Gigliotti
 */
@Entity
public class Users implements Serializable
{

    @Id
    private String username;
    @Column(length=60)
    private String password;
    
    /** Creates a new instance of Users */
    public Users()
    {
    }
    
    public Users(String username,String password)
    {
        this.username = username;
        this.password = password;
    }

    /**
     * Gets the username of this Users.
     * @return the username
     */
    public String getusername()
    {
        return this.username;
    }

    /**
     * Sets the username of this Users to the specified value.
     * @param username the new username
     */
    public void setusername(String username)
    {
        this.username = username;
    }

    public int hashCode()
    {
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
    public boolean equals(Object object)
    {
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
    public String toString()
    {
        return "assign2.users.Users[username=" + username + "]";
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
    
}
