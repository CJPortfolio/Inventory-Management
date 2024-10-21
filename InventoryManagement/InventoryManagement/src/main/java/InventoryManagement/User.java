//Student ID: cjw220005
//Name: Christopher Wiratman
package InventoryManagement;

/**
 * User
 */
public class User 
{
    //TODO: add necessary fields to your program

    protected String username, hashedPassword, firstName, lastName;
    protected boolean isManager;

    public User(String username, String hashedPassword, boolean isManager)
    {       
        this.username = username;
        this.hashedPassword = hashedPassword;
        this.isManager = isManager;
    }

    public User(String firstName, String lastName, String username, String hashedPassword, boolean isManager)
    {       
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.hashedPassword = hashedPassword;
        this.isManager = isManager;
    }

    public String getFirstName()
    {
        return this.firstName;
    }

    public String getLastName()
    {
        return this.lastName;
    }

    public String getUsername()
    {
        return username;
    }

    public Boolean getManagerRole()
    {
        return isManager;
    }

    public String gethashedPassword()
    {
        return hashedPassword;
    }

    @Override
    public boolean equals(Object other) {
        if(!(other instanceof User)) return false;

        User otherUser = (User)(other);

        //Boolean condition that returns the result of comparing the
        //User's respective values
        return 
        (
            this.username.equals(otherUser.username) && 
            this.hashedPassword.equals(otherUser.hashedPassword) &&
            this.isManager == otherUser.isManager
        );
    }

  
}