//Student ID: cjw220005
//Name: Christopher Wiratman


package InventoryManagement;

import java.io.File;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void AuthenticatedUser()
    {
        String username = "jlast",
               password = "58c536ed8facc2c2a293a18a48e3e120";

        //Implemenatation of AuthenticateUser function uses already hashed password to
        //as password from user is unknown
        User AuthenticatedUser = InventoryManagementSecurity.AuthenticateUser(username, InventoryManagementSecurity.GetPasswordHash(password));

        assert(AuthenticatedUser != null);

    }

    @Test
    public void AddedNewUser()
    {
        //TODO hash currentPassword and save username and hashed currentPassword to Users.dat
        // Check if hash currentPassword was hashed

        String expectedusername = "jbest";
        String expectedhashedPassword = "293a18a48e3e12052058c536ed8facc2c";
        Boolean expectedManagerAuthority = false;

        User expectedUser = new User(expectedusername, expectedhashedPassword, expectedManagerAuthority);

        InventoryManagementSecurity.AddNewUser(expectedUser);

        User actualUser = InventoryManagementSecurity.AuthenticateUser(expectedusername, expectedhashedPassword);
        assertTrue(expectedUser.equals(actualUser));
        
    }

    @Test
    public void RemovedUser()
    {
        //Assert that the Users.dat file does not have the User object

        String username = "Captain America";

        String password = "Stars and stripes";

        InventoryManagementSecurity.RemoveUser(username);

        User actualUser = InventoryManagementSecurity.AuthenticateUser(username, password);
        
        assertTrue(actualUser == null);

    }
    
    @Test
    public void ChangedPasswordTest()
    {


        String username = "kWest";
        String currentPassword = "808andHeartbreaks";
        String enteredCurrentPassword = "808andHeartbreaks";
        String newPassword = "Vultures";
        
        //New Hashed Password: 5686a9b4d63335d6142508e6f2eb18ec
        String newHashedPassword = InventoryManagementSecurity.GetPasswordHash(newPassword);
        //Original Hashed Password: 1f7dfe590ac46d1f403b312c5b96ea1b
        String originalHashedPassword = InventoryManagementSecurity.GetPasswordHash(currentPassword);
    
    //Two Test Cases 
        //1. The case where the password they entered is the same as the password on file
        //      Call the function and test that the password on file is the new password
        InventoryManagementSecurity.ChangePassword(username, enteredCurrentPassword, newPassword);
        User expectedUser = new User(username, newHashedPassword, false);
        User actualUser = InventoryManagementSecurity.AuthenticateUser(username, newHashedPassword);
        //Asserts that user was changed
        assertEquals(null, actualUser);

        
        //2. The case where the password they entered is different from the password on file
        //      Call the function and test that the password on file was not changed
        enteredCurrentPassword = "Kim Kardashian";
        InventoryManagementSecurity.ChangePassword(username, enteredCurrentPassword, newPassword);
        expectedUser = new User(username, originalHashedPassword, false);
        actualUser = InventoryManagementSecurity.AuthenticateUser(username, originalHashedPassword);
        //Asserts that user was not changed
        assertEquals(expectedUser, actualUser);

    }

    @Test
    public void AddedMenuItem()
    {
        //Function adds a menu item to the file list of menu items (MenuList.dat).
            //Filepath: 
            //C:\Users\cjwir\OneDrive\Documents\GitHub\InventoryManagement\InventoryManagement\InventoryManagement\src\main\java\InventoryManagement\MenuList.dat
        
        //Format is: Description, Boolean flag for only managers, Name of the menu command
            //Data is comma seperated.


        //Steps to test:
            //1. Make an expected Menu Item object and Command object
            //2. Call AddMenuItem function to add Menu Item object to MenuList.dat file
            //3. Call a function to get the MenuItem object (returns either null or with MenuItem object)
            //4. Assert that the function to get the added MenuItem object returned with that
                //object and not null

            //Mock Data
            String menuHeader = "Inventory Management System Menu";
            MenuList menuList = new MenuList(menuHeader);
            ProductCatalog pCatalog = new ProductCatalog();
            String username = "Eminem",
                   //Password: "TheeMarshallMathers"
                   hashedPassword = "9dc10ab6197cd591896d5effb09f2994";
            Boolean isManager = true;
            User user = new User(username,hashedPassword, isManager);
            AddProductCommand addProductCommand = new AddProductCommand(pCatalog, user);
            String menuItemDescription = "Add New Product";
            int optionNumber = 0;

            MenuItem menuItem = new MenuItem(addProductCommand, optionNumber, menuItemDescription, isManager);
            menuList.AddMenuItem(menuItem);



        //TODO Check if a MenuItem object was added to the file
            //Assert that retrieving an expected added MenuItem object returned true.
            assertTrue(FindMenuItem(addProductCommand, menuItemDescription, isManager));
    }

    
    

    @Test
    public void RemovedProduct()
    {
        //Function removes a product from the producty inventory file (Inventory.dat)
            //Filepath: 
            //C:\Users\cjwir\OneDrive\Documents\GitHub\InventoryManagement\InventoryManagement\InventoryManagement\src\main\java\InventoryManagement\Inventory.dat
        
        //Format is: Product Unique ID (int), Product Name (string), 
        //Cost (double), Quantity (int) and Margin (int, integer that represents margin percentage).
            //Data is comma seperated.

        //Steps to test:
            //1. Make an expected Product object
            //2. Call function to remove Product object in the Inventory.dat file
            //3. Call a function to find the Product Unique ID (int)
            //4. Assert function returns false(Product was not found)

        //Mock Data
        String productName = "Mobile Phone";

        ProductCatalog productCatalog = new ProductCatalog();

        //TODO Check if the Product object is not in the file.
            //Assert that retrieving an expected Product object returned false(was not found).

        assertTrue(productCatalog.RemoveProduct(productName));
        
    }

    @Test
    public void FoundProduct()
    {
        //Function finds a product from the producty inventory file (Inventory.dat)
            //Filepath: 
            //C:\Users\cjwir\OneDrive\Documents\GitHub\InventoryManagement\InventoryManagement\InventoryManagement\src\main\java\InventoryManagement\Inventory.dat
        
        //Format is: Product Unique ID (int), Product Name (string), 
        //Cost (double), Quantity (int) and Margin (int, integer that represents margin percentage).
        
        //Steps to test:
            //1. Make an expected Unique Product ID (int)
            //2. Call FindProduct function to find Unique Product ID
            //3. Assert the returned value true

        ProductCatalog productCatalog = new ProductCatalog();

        int productId = 435;


        //TODO Check if the Product object is in the file.
            //Assert that finding an expected Product object 
            //was true.

        assertTrue(productCatalog.FindProduct(productId));
    }

    @Test
    public void PrintedProductInformation()
    {
        //Function that prints product's information in a format similar as(not exact spacing):
        /*
        Id     Name         Cost       Quantity       Retail 
        ---------------------------------------------------- 
        3424   Smart Watch  $20.45     23             $36.81 
        */

        //Steps to test:
            //1. Make an expected detailed string for output
            //2. Make an actual output string
            //3. Call PrintProductInformation to print into the actual output string
            //4. Assert the actual output string is equal to the expected output string

        //Mock Data
        int productId = 6798;
        String name = "Gaming Mouse";
        double cost = 20.56;
        int quantity = 10;
        int margin = 30;
        String expectedOutput = null;

        Product product = new Product(productId, name, cost, quantity, margin);

        ProductCatalog productCatalog = new ProductCatalog();

        productCatalog.AddUpdateProduct(product);


        //TODO Check if the output buffer from the terminal printed the 
        //correct output for displaying the product's information.
            //Assert that the output buffer is equal to the expected output string.

        assertEquals(expectedOutput, productCatalog.PrintProductInformation(productId));
    }

    @Test
    public void PrintedInventoryList()
    {
        //Function that prints the product inventory
        //and their information in a format similar as(not exact spacing):
        /*
        Id     Name         Cost       Quantity       Retail 
        ---------------------------------------------------- 
        3424   Smart Watch  $20.45     23             $36.81 
        *(Assume more products and their information listed here and below)
        
        */

        //*Like PrintProductInformation but on a bigger scale
        //Steps to test:
            //1. Make an expected detailed string for output
            //2. Make an actual output string
            //3. Call PrintProductInformation to print into the actual output string
            //4. Assert the actual output string is equal to the expected output string
        
        
        ProductCatalog productCatalog = new ProductCatalog();
        String expectedListOutput = "";
        productCatalog.PrintInventoryList();
        //TODO Check if the output buffer from the terminal printed the 
        //correct output for displaying the product's information.
            //Assert that the output buffer is equal to the expected output string.
        assertEquals(expectedListOutput, productCatalog.PrintInventoryList());
    }

    //Function that returns true if the Menu Item in MenuList.dat was found
    public Boolean FindMenuItem(Command expectedCommand, String expectedMenuItemDescription, Boolean expectedManagerRole)
    {
        Scanner scnr = null;
        try {
            File file = new File
            ("C:\\Users\\cjwir\\OneDrive\\Documents\\GitHub\\InventoryManagement\\InventoryManagement\\InventoryManagement\\src\\main\\java\\InventoryManagement\\MenuList.dat");
            scnr = new Scanner(file);   
        } catch (Exception e) {
            System.out.println("File not found");
            System.exit(0);
        }

        Scanner lineScnr = null;

        String actualMenuItemDescription;
        Boolean actualManagerRole;
        String actualCommandName;

        while(scnr.hasNextLine())
        {
            String line = scnr.nextLine();
            lineScnr = new Scanner(line);
            lineScnr.useDelimiter(", ");

            actualMenuItemDescription = lineScnr.next().trim();
            actualManagerRole = Boolean.parseBoolean(lineScnr.next().trim());
            actualCommandName = lineScnr.next().trim();

            if(actualMenuItemDescription.equals(expectedMenuItemDescription) &&
            actualManagerRole.equals(expectedManagerRole) &&
            actualCommandName.equals(expectedCommand.getClass().getSimpleName()))
            {
                    scnr.close();
                    lineScnr.close();
                    return true;
            }
        }

        scnr.close();
        return false;
    } 

}
