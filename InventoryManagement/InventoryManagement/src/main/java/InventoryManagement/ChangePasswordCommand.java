package InventoryManagement;

import java.util.Scanner;

//TODO: Implement this class

public class ChangePasswordCommand extends Command

{
    public ChangePasswordCommand(ProductCatalog productCatalog, User loggedOnUser)
    {
        //Calls the parent class(Command) constructor
        super(productCatalog, loggedOnUser);

    }


    @Override
    public void Execute()
    {
        // TODO Add the code that will execute this command

        String userName, currentPassword, 
        newPassword;

        Scanner scnr = new Scanner(System.in);


        //Gets username
        System.out.println("Please enter the username: ");
        userName = scnr.next();
        scnr.nextLine();

        //Gets current password
        System.out.println("Please enter the current password: ");
        currentPassword = scnr.nextLine();
        
        //Gets new password
        System.out.println("Please enter the new password: ");
        newPassword = scnr.nextLine();

        InventoryManagementSecurity.ChangePassword(userName, currentPassword, newPassword);

        scnr.close();
        //This function will replace the old password of the user in the
        //file with the new password.
    }
}


