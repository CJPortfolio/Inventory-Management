package InventoryManagement;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
        //THIS IS JUST AN EXAMPLE ON HOW TO AUTHENTICATE AND CREATE A COMMAND DYNAMICALLY. 
        //REMOVE CODE AND CHANGE AS NEEDED.

        //Authenticate the user and get a user object back
        User user = InventoryManagementSecurity.AuthenticateUser("admin", "admin"); 
        
        ProductCatalog  productCatalog = new ProductCatalog(); 
        
        //TODO: You will have to read the information below from the MenuList.dat file instead of hardcoding it here.
        String          commandClassName    = "AddProductCommand"; 
        int             optionNumber        = 1; 
        String          description         = "Add Product"; 
        Boolean         isRestricted        = true; 

        Command dynamicCommand = Command.CreateCommandDynamically(productCatalog, user, commandClassName); 

        System.out.println("The command concrete type is " + dynamicCommand.getClass().getSimpleName());
        
        MenuItem menuItem = new MenuItem(dynamicCommand, optionNumber, description, isRestricted); 

        //Add all created MenuItems to a MenuList. Array list usage is permitted.
    }
}
