
//Student ID: cjw220005
//Name: Christopher Wiratman

package InventoryManagement;


public class UpdateProductCommand extends Command
{
    protected ProductCatalog productCatalog;

    protected User loggedOnUser;

    public UpdateProductCommand(ProductCatalog productCatalog, User loggedOnUser)
    {
        //Calls the parent class(Command) constructor
        super(productCatalog, loggedOnUser);

    }

    @Override
    public void Execute() {
        // TODO Add the code that will execute this command

    }
}