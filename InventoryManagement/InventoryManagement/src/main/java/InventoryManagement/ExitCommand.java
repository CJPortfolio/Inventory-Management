package InventoryManagement;

public class ExitCommand extends Command
{

    public ExitCommand(ProductCatalog productCatalog, User loggedOnUser)
    {
        //Calls the parent class(Command) constructor
        super(productCatalog, loggedOnUser);

    }

    @Override
    public void Execute() {
        // TODO Add the code that will execute this command
        System.exit(0);
    }
}
