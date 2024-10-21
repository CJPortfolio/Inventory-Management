//Student ID: cjw220005
//Name: Christopher Wiratman
package InventoryManagement;

import java.util.Scanner;

public class DeleteUserCommand extends Command
{

    public DeleteUserCommand(ProductCatalog productCatalog, User loggedOnUser)
    {
        //Calls the parent class(Command) constructor
        super(productCatalog, loggedOnUser);

    }

    @Override
    public void Execute() {
        // TODO Add the code that will execute this command

        //1. Ask for the username

        Scanner scnr = new Scanner(System.in);

        System.out.println("Enter the user to delete:");

        String userName = scnr.next();

        //2. Find user in file
        //3. Write to a new file every line except the one containing the user to delete
        //4. Assign the new file's name/path to be the old file's name/path;

        InventoryManagementSecurity.RemoveUser(userName);

        

    }
}
