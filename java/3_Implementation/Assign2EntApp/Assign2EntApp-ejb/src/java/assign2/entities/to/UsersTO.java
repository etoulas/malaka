/*
 * UsersTO.java
 *
 * Created on 19 October 2006, 14:18
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package assign2.entities.to;

import java.io.Serializable;
/**
 *
 * @author Gerard Gigliotti
 */
public class UsersTO implements Serializable
{
    private String username;
    private String password;
    private String name;
    
    /** Creates a new instance of UsersTO */
    public UsersTO(String username,String password,String name)
    {
        this.setUsername(username);
        this.setPassword(password);
        this.setName(name);
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

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
    
}
