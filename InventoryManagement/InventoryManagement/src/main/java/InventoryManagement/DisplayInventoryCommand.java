package InventoryManagement;

//TODO: Implement this class

public class DisplayInventoryCommand extends Command
{

    public DisplayInventoryCommand(ProductCatalog productCatalog, User loggedOnUser)
    {
        //Calls the parent class(Command) constructor
        super(productCatalog, loggedOnUser);

    }

    @Override
    public void Execute() {
        // TODO Add the code that will execute this command

    }
}