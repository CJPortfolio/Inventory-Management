//Student ID: cjw220005
//Name: Christopher Wiratman
package InventoryManagement;

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

        

    }
}