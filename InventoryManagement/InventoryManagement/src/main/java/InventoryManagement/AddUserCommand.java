package InventoryManagement;

import java.util.Scanner;

public class AddUserCommand extends Command
{
    public AddUserCommand(ProductCatalog productCatalog, User loggedOnUser)
    {
        //Calls the parent class(Command) constructor
        super(productCatalog, loggedOnUser);

    }


    @Override
    public void Execute()
    {
        // TODO Add the code that will execute this command


            //1. Prompt user for first name, last name, password
            //and if they are a manager or not

            Scanner scnr = new Scanner(System.in);
            
            System.out.println("Enter the first name:");
            String firstName = scnr.next();

            System.out.println("Enter the last name:");
            String lastName = scnr.next();

            System.out.println("Enter the username:");
            String userName = scnr.next();

            System.out.println("Enter the password:");
            String password = scnr.next();

            System.out.println("Enter true or false if they are a manager or not:");
            String isManager = scnr.next();

            User newUser = new User(firstName, lastName, userName, InventoryManagementSecurity.GetPasswordHash(password), Boolean.parseBoolean(isManager));

            //2. Open the file and and append the user info
            //to a new line at the bottom of the file

            InventoryManagementSecurity.AddNewUser(newUser);

            newUser = InventoryManagementSecurity.AuthenticateUser(userName, password);


            //3. Close the file and check if user successfully added

            if (newUser == null)
            {
                System.out.println("User could not be added");
            }
            else
            {
                System.out.println("User successfuly added");
            }

            
    }
}