package InventoryManagement;

import java.util.Scanner;

//TODO: Implement this class

public class DisplayProductInformationCommand extends Command
{    

    public DisplayProductInformationCommand(ProductCatalog productCatalog, User loggedOnUser)
    {
        //Calls the parent class(Command) constructor
        super(productCatalog, loggedOnUser);

    }

    @Override
    public void Execute() {
        // TODO Add the code that will execute this command

        

        Scanner scnr = new Scanner (System.in);

        //Prompt user for product ID

        System.out.println("Enter the product ID to display information");
        int productID = scnr.nextInt();

        //Print out product's information

        String productInfo = productCatalog.PrintProductInformation(productID);
        System.out.println(productInfo);



    }
}