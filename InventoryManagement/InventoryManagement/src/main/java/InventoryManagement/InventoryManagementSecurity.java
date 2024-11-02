//Student ID: cjw220005
//Name: Christopher Wiratman
package InventoryManagement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 * InventoryManagementSecurity
 */
public class InventoryManagementSecurity 
{

    public static User AuthenticateUser(String username, String password) {
        //Case for admin authority
        if((username.equalsIgnoreCase("admin")) && 
        (password.equalsIgnoreCase("admin")))
        {
            return new User(username, GetPasswordHash(password), true);
        }
        
        //TODO get the password hash using GetPasswordHash() method then try to find the user in Users.dat file
        

        //Password checking did not implement
        //String passwordHash = GetPasswordHash(password);
        //username = "jlast";
        //password = "58c536ed8facc2c2a293a18a48e3e120";
        
        //GetPasswordHash function is not implemented
        //for unit testing
        
        String filePasswordHash;
        String fileUsername;
        String firstName, lastName;
        Boolean isManager;


        //Makes file for scanning
        Scanner scnr = null;
        try {
            File file = new File("C:\\Users\\cjwir\\OneDrive\\Documents\\GitHub\\InventoryManagement\\InventoryManagement\\InventoryManagement\\src\\main\\java\\InventoryManagement\\Users.dat");
            scnr = new Scanner(file);   
        } catch (FileNotFoundException e) {
            
            //File not found exception thrown if file not found
            System.out.println("File not found");
            System.exit(0);
        }
        
        Scanner lineScnr;
        

        //Goes through file and scans for each line of data
        while(scnr.hasNextLine())
        {    
            String line = scnr.nextLine();
            lineScnr = new Scanner(line);
            lineScnr.useDelimiter(",");
            
            firstName = lineScnr.next().trim();
            lastName = lineScnr.next().trim();

            fileUsername = lineScnr.next().trim();
            filePasswordHash = lineScnr.next().trim();
            isManager = Boolean.parseBoolean(lineScnr.next().trim());

            //Boolean condition to check if the username and 
            //password hash is found in the file

            if((fileUsername.equalsIgnoreCase(username)) && 
                (filePasswordHash.equalsIgnoreCase(GetPasswordHash(password))))
            {
                scnr.close();
                lineScnr.close();

                
                return new User(firstName, lastName, username, GetPasswordHash(password), isManager);
            }
            
        }
        scnr.close();
        
        return null;
    }

    public static void AddNewUser(User newUser)
    {
        //Done
        //Actual Implementation
            //TODO hash password and save username and hashed password to Users.dat
            

            try 
            {
                FileWriter file = new FileWriter("C:\\Users\\cjwir\\OneDrive\\Documents\\GitHub\\InventoryManagement\\InventoryManagement\\InventoryManagement\\src\\main\\java\\InventoryManagement\\Users.dat",true);
                file.write(System.lineSeparator() + newUser.getFirstName() + ", " +  newUser.getLastName() + ", " +  newUser.getUsername() + ", " + newUser.gethashedPassword() + ", " + newUser.getManagerRole().toString()); 
                file.close();
            } 
            catch (FileNotFoundException e) {
                
                //File not found exception thrown if file not found
                System.out.println("File not found");
                System.exit(0);
            } 
            catch (IOException ex) 

            {
                //File not found exception thrown if file not found
                System.out.println("Error writing to the file");
                System.exit(0);
            }

        
        
        //Unit Test Implementation
            //TODO make mock data for the unit test's function
            //call to take in.

         
        
    }

    public static void RemoveUser(String userName)
    {
        //TODO remove username from Users.dat

        File usersFile = new File("C:\\Users\\cjwir\\OneDrive\\Documents\\GitHub\\InventoryManagement\\InventoryManagement\\InventoryManagement\\src\\main\\java\\InventoryManagement\\Users.dat");
        File tempFile = new File("tempFile.dat");

        try 
        {

            BufferedReader reader = new BufferedReader(new FileReader(usersFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            
            String currentLine;

            //Read the first line, if line is null, return, otherwise continue
            if((currentLine = reader.readLine()) == null)
            {
                System.out.println("Empty file, no user to delete");
                reader.close();
                writer.close();
                return;
            }
            
            //First line gets written if it doesn't contain username
            if(!currentLine.contains(userName))
            {
                writer.write(currentLine);  
            }

            //Reads second line then writes to the temp file
            else
            {
                currentLine = reader.readLine();
                writer.write(currentLine);
            }

            

            //Read all the rest of the lines and copy them into the new file with line separation
            while((currentLine = reader.readLine()) != null)
            {
                if (currentLine.contains(userName)) continue;
            
                writer.write(System.lineSeparator() + currentLine);
            }

            reader.close();
            writer.close();
            usersFile.delete();
            tempFile.renameTo(usersFile);

            reader = new BufferedReader(new FileReader(usersFile));

            while((currentLine = reader.readLine()) != null)
            {
                if (currentLine.contains(userName))
                {
                    System.out.println("User could not be deleted");
                    break;
                }
            }

            System.out.println("User sucessfully deleted");
            reader.close();
        }
        catch(IOException e)
        {
            System.out.println("Error with file");
        }

    }

    public static void ChangePassword(String username, 
                                      String currentPassword, 
                                      String newPassword)
    {
        //TODO change the password only if current password match what is on records
        User userToAuthenticate;
        userToAuthenticate = InventoryManagementSecurity.AuthenticateUser(username, currentPassword);

        //old password: La Cucaracha
        //new password: Mr. Skibidi
        
        if(userToAuthenticate == null)
        {
            System.out.println("Password did not match what was on records");
        }
        else
        {
            File usersFile = new File("C:\\Users\\cjwir\\OneDrive\\Documents\\GitHub\\InventoryManagement\\InventoryManagement\\InventoryManagement\\src\\main\\java\\InventoryManagement\\Users.dat");
            File tempFile = new File("tempFile.dat");

            try
            {
                BufferedReader reader = new BufferedReader(new FileReader(usersFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
                String currentLine;

                if((currentLine = reader.readLine()) == null)
                {
                    System.out.println("Empty file, no user to delete");
                    reader.close();
                    writer.close();
                    return;
                }
            
                //First line gets written if it doesn't contain current password
                if(currentLine.contains(GetPasswordHash(currentPassword)))
                {
                    writer.write(userToAuthenticate.firstName + ", " + userToAuthenticate.lastName + ", " + username + ", " + GetPasswordHash(newPassword) + ", " + Boolean.toString(userToAuthenticate.isManager));
                }

                //Reads second line then writes to the temp file
                else
                {
                    currentLine = reader.readLine();
                    writer.write(currentLine);
                }


                while((currentLine = reader.readLine()) != null)
                {
                    if (!currentLine.contains(GetPasswordHash(currentPassword))) 
                    {
                        writer.newLine();
                        writer.write(currentLine);

                        System.out.println(currentLine);
                    }
                    else if(currentLine.contains(GetPasswordHash(currentPassword)))
                    {
                        writer.write("\n" + userToAuthenticate.firstName + ", " + userToAuthenticate.lastName + ", " + username + ", " + GetPasswordHash(newPassword) + ", " + Boolean.toString(userToAuthenticate.isManager));
                    }
                }

                reader.close();
                writer.close();
                usersFile.delete();
                tempFile.renameTo(usersFile);
            }

            catch(IOException e)
            {
                System.out.println("Error with file");
            }

            userToAuthenticate = InventoryManagementSecurity.AuthenticateUser(username, newPassword);

            if(userToAuthenticate == null)
            {
                System.out.println("Password could not be changed");
            }
            else
            {
                System.out.println("Password successfully changed");

            }
        }

        


        
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