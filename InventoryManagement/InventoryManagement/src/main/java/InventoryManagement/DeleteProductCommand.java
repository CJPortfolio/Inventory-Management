//Student ID: cjw220005
//Name: Christopher Wiratman
package InventoryManagement;

import java.util.Scanner;

//TODO: Implement this class

public class DeleteProductCommand extends Command
{
    public DeleteProductCommand(ProductCatalog productCatalog, User loggedOnUser)
    {
        //Calls the parent class(Command) constructor
        super(productCatalog, loggedOnUser);

    }

    @Override
    public void Execute() {
        // TODO Add the code that will execute this command

        Scanner scnr = new Scanner(System.in);


        System.out.println("Enter the product to delete: ");

        String productToDelete = scnr.next();

        //This function will, being from DeleteProductCommand,
        //delete a product to the product catalog and file

    }
}
