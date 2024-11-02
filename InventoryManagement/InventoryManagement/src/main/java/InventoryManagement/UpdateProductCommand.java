
//Student ID: cjw220005
//Name: Christopher Wiratman

package InventoryManagement;
import java.util.Scanner;


public class UpdateProductCommand extends Command
{
    public UpdateProductCommand(ProductCatalog productCatalog, User loggedOnUser)
    {
        //Calls the parent class(Command) constructor
        super(productCatalog, loggedOnUser);

    }

    @Override
    public void Execute() {
        // TODO Add the code that will execute this command
        Scanner scnr = new Scanner(System.in);

        System.out.println("Enter the name of the product you want to modify: ");
        String productName = scnr.nextLine();

        int ID, quantity, margin;
        double cost;
        String name;

        //Prompts user for data for modified product
        // Mock Data: 3424, Smart Watch, 20.45, 23, 80
        System.out.println("Enter the different/same ID for the product: ");        
        ID = scnr.nextInt();
        System.out.println("Enter the different/same name for the product: ");
        scnr.nextLine();
        name = scnr.nextLine();

        System.out.println("Enter the different/same cost for the product: ");
        cost = scnr.nextDouble();

        System.out.println("Enter the different/same quantity for the quantity: ");
        quantity = scnr.nextInt();

        System.out.println("Enter the different/same margin for the product: ");
        margin = scnr.nextInt();

        Product ModifiedProduct = new Product(ID, name, cost, quantity, margin);

        ProductCatalog.AddUpdateProduct(ModifiedProduct, productName);

        if(ProductCatalog.FindProduct(productName))
        {
            System.out.println("Product successfuly modified");
        }
        else
        {
            System.out.println("Product could not be modified");
        }

    }
}