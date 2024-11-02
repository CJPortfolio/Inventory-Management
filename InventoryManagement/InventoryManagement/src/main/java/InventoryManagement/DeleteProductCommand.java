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

    //This function will, being from DeleteProductCommand,
    //delete a product to the product catalog and file
    @Override
    public void Execute() {
        // TODO Add the code that will execute this command

        Scanner scnr = new Scanner(System.in);

        //Prompts user for the product name to delete
        System.out.println("Enter the product name to delete: ");
        String productToDelete = scnr.nextLine();

        //Calls the function to remove the product and check it was
        //deleted
        if(ProductCatalog.RemoveProduct(productToDelete))
        {
            System.out.println("Product succesfuly removed");
        }
        else
        {
            System.out.println("Product could not be removed");
        }

    }
}
