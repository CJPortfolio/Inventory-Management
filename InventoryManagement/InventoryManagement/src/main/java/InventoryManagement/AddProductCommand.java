//Student ID: cjw220005
//Name: Christopher Wiratman
package InventoryManagement;

import java.util.Scanner;

/**
 * AddCommand
 */
public class AddProductCommand extends Command
{
    //TODO: add necessary fields to this class

    public AddProductCommand(ProductCatalog productCatalog, User loggedOnUser)
    {
        //Calls the parent class(Command) constructor
        super(productCatalog, loggedOnUser);

    }

    @Override
    public void Execute() {
        // TODO Add the code that will execute this command
        //This function will, being from AddProductCommand,
        //add a product to the product catalog and file

        int ID, quantity, margin;
        double cost;
        String name;

        Scanner scnr = new Scanner(System.in);

        //Prompts user for data for new product
        // Mock Data: 3424, Smart Watch, 20.45, 23, 80
        System.out.println("Enter the new product's ID: ");        
        ID = scnr.nextInt();
        System.out.println("Enter the new product's name: ");
        scnr.nextLine();
        name = scnr.nextLine();

        System.out.println("Enter the new product's cost: ");
        cost = scnr.nextDouble();

        System.out.println("Enter the new product's quantity: ");
        quantity = scnr.nextInt();

        System.out.println("Enter the new product's margin: ");
        margin = scnr.nextInt();

        //Makes new product
        Product product = new Product(ID, name, cost, quantity, margin);

        //Checks if product already exists
        //if so returns back to main
        if(productCatalog.FindProduct(name) == true)
        {
            System.out.println("Product already exists");
            return;
        }

        //Calls the AddUpdateProduct function
        ProductCatalog.AddUpdateProduct(product);

        //Checks if product was successfully added
        
        if(productCatalog.FindProduct(name) == true)
        {
            System.out.println("Product successfuly added");
        }
        else
        {
            System.out.println("Product could not be added");
        }

        scnr.close();
        
    }
}