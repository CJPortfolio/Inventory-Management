//Student ID: cjw220005
//Name: Christopher Wiratman
package InventoryManagement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
        //Prompt user for username and password
        
        User user;

        String username, password, systemOption;

        Scanner scnr = new Scanner(System.in);

        //System.out.println(InventoryManagementSecurity.GetPasswordHash("La Cucaracha"));


        do
        {
            System.out.print("Enter username: ");

            username = scnr.nextLine();

            System.out.print("Enter password: ");

            password = scnr.nextLine();

            System.out.println();

            //Authenticate User

            user = InventoryManagementSecurity.AuthenticateUser(username, password);
            
            if(user == null)
            {
                System.out.println("Invalid username or password!");
                System.out.print("Press enter to continue or \"Exit\" to exit: ");
                //scnr.nextLine();
                systemOption = scnr.nextLine();

                if(systemOption.compareToIgnoreCase("Exit") == 0)
                {
                    System.exit(0);
                }
            }

            else if(username.equals("admin") && password.equals("admin"))
            {
                System.out.println("Welcome Admin!\n");

            }
            else
            {
                System.out.println("Welcome " + user.firstName + " " + user.lastName + "!\n");
            }
        }
        while(user == null);

        //TODO read the file to get the menu items/commands
        //to get the commands based on order from the file
            //Default command if no menu items is exit as an option
            //Depending on manager authority, commands only with
            //manager authority are displayed

            // Pathname: "C:\\Users\\cjwir\\OneDrive\\Documents\\GitHub\\InventoryManagement\\InventoryManagement\\InventoryManagement\\src\\main\\java\\InventoryManagement\\Inventory.dat"

        ProductCatalog productCatalog = new ProductCatalog();

        String inventoryFile = "C:\\Users\\cjwir\\OneDrive\\Documents\\GitHub\\InventoryManagement\\InventoryManagement\\InventoryManagement\\src\\main\\java\\InventoryManagement\\Inventory.dat";

        try (BufferedReader br = new BufferedReader(new FileReader(inventoryFile))) {
            String line = null;

            int productID = 0;
            String productName = null;
            double productCost = 0.0;
            int productQuantity = 0;
            int margin = 0;
            Product product;


            while ((line = br.readLine()) != null) 
            {
                
                String[] data = line.split(", ");

                productID = Integer.parseInt(data[0]);
                productName = data[1];
                productCost = Double.parseDouble(data[2]);
                productQuantity = Integer.parseInt(data[3]);
                margin = Integer.parseInt(data[4]);

                product = new Product(productID, productName, productCost, productQuantity, margin);

                productCatalog.productCatalog.add(product);

                //System.out.println(productName);
        
            }
        }
        catch (IOException e)
        {
            System.out.println("Error with inventory file");
        }




        
            

        //TODO implement the MenuList object function StartMenu
        //to display the commands based on the order in the file.

        String menuHeader = "Inventory Management System Menu";

        MenuList menuItems = new MenuList(menuHeader);

        String menuListFile = "C:\\Users\\cjwir\\OneDrive\\Documents\\GitHub\\InventoryManagement\\InventoryManagement\\InventoryManagement\\src\\main\\java\\InventoryManagement\\MenuList.dat";

        try (BufferedReader br = new BufferedReader(new FileReader(menuListFile))) {
            String line = null;

            String commandDescription;
            Boolean isRestricted;
            String commandName;

            int order = 0;


            while ((line = br.readLine()) != null) 
            {
                
                String[] data = line.split(", ");

                commandDescription = data[0];
                isRestricted = Boolean.parseBoolean(data[1]);
                commandName = data[2];

                Command command = Command.CreateCommandDynamically(productCatalog, user, commandName);

                MenuItem menuItem = new MenuItem(command, ++order, commandDescription, isRestricted);

                menuItems.menuList.add(menuItem);
        
            }

            Command exitCommand = Command.CreateCommandDynamically(productCatalog, user, "ExitCommand");

            MenuItem exitItem = new MenuItem(exitCommand, ++order, "Exit", false);

            menuItems.menuList.add(exitItem);
        }
        catch (IOException e)
        {
            System.out.println("Error with menu list file");
        }


        int option = -1;



        while (true)
        {
            menuItems.StartMenu(user);

            
            try
            {
                scnr = new Scanner(System.in);

                option = scnr.nextInt() - 1;
                
                Command selectedCommand = menuItems.menuList.get(option).command;
                String nameOfSelectedCommand = selectedCommand.getClass().getSimpleName();

                if(nameOfSelectedCommand.equals("ExitCommand"))
                {
                    scnr.close();
                }

                selectedCommand.Execute();

            }
            catch(InputMismatchException e)
            {
                System.out.println("Invalid Input");

                scnr = new Scanner(System.in);

            }
            catch(IndexOutOfBoundsException e)
            {
                System.out.println("Invalid Command");

                scnr = new Scanner(System.in);
            }
        
        
        }

        
    }

    
}
