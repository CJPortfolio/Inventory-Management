package InventoryManagement;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * InventoryManagementSecurity
 */
public class InventoryManagementSecurity 
{
    public static User AuthenticateUser(String username, String password)
    {
        User authenticatedUser = null;

        if((username.compareToIgnoreCase("admin") == 0) && 
           (GetPasswordHash(password).compareToIgnoreCase("58c536ed8facc2c2a293a18a48e3e120") == 0))
        {
            authenticatedUser = new User(username, GetPasswordHash(password), true); 
        }
        else
        {
            //TODO get the password hash using GetPasswordHash() method then try to find the user in Users.dat file
            //TODO set the authenticatedUser object if successfully authenticated
        }

        return authenticatedUser; //Change the return value based on authentication result
    }

    public static void AddNewUser(User newUser)
    {
        //TODO hash password and save username and hashed password to Users.dat
    }

    public static void RemoveUser(String userName)
    {
        //TODO remove username from Users.dat
    }

    public static void ChangePassword(String username, 
                                      String currentPassword, 
                                      String newPassword)
    {
        //TODO change the password only if current password match what is on records
    }

    public static String GetPasswordHash(String password) 
    {        
        String generatedPassword = null;
        
        try 
        {
            byte[] salt = new byte[] {12, -12, 65, 61, 
                                      2, -6, -90, 12, 
                                      4, -7, -87, 2, 
                                      34, -102, 3, 115};

            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            // Add password bytes to digest
            md.update(salt);
            // Get the hash's bytes
            byte[] bytes = md.digest(password.getBytes());
            // This bytes[] has bytes in decimal format;
            // Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            // Get complete hashed password in hex format
            generatedPassword = sb.toString();
        } 
        catch (NoSuchAlgorithmException e) 
        {
            e.printStackTrace();
        } 

        return generatedPassword;
    }
}