//Student ID: cjw220005
//Name: Christopher Wiratman
package InventoryManagement;

import java.util.Scanner;

public class AddMenuItemCommand extends Command {

    public AddMenuItemCommand(ProductCatalog productCatalog, User loggedOnUser) {
        super(productCatalog, loggedOnUser);
    }

    @Override
    public void Execute() {
        Scanner scnr = new Scanner(System.in);

        String description, nameOfMenuItem;
        int optionNumber = 0;
        Boolean isRestricted;

        //Mock Data: Display Product Information, false, DisplayProductInformationCommand

        //Prompts for description of Menu Item
        System.out.println("Enter the description of the menu item: ");
        description = scnr.nextLine();

        //Prompts for option number
        /* 
        System.out.println("Enter the number for the menu item's option (cannot be less than the greatest option number): ");
        optionNumber = scnr.nextInt();
        */

        //Prompts for if menu item is restricted to managers
        System.out.println("Enter true or false if menu item is restricted: ");
        isRestricted = Boolean.parseBoolean(scnr.next());

        //Prompts for name of Menu Item command
        System.out.println("Enter the menu item command's name: ");
        nameOfMenuItem = scnr.next();

        //Creates command and menu item
        Command command = Command.CreateCommandDynamically(productCatalog, loggedOnUser, nameOfMenuItem);
        MenuItem menuItem = new MenuItem(command, optionNumber, description, isRestricted);

        //Checks if menu item already exists
        if(MenuList.findMenuItem(menuItem))
        {
            System.out.println("Menu Item: " + menuItem.command.getClass().getSimpleName() + " already exists");
            return;
        }

        //Call function to add menu item created for menulist.dat file
        MenuList.AddMenuItem(menuItem);

        //Check if menu item was successfuly added
        if(MenuList.findMenuItem(menuItem))
        {
            System.out.println("Menu Item: " + menuItem.command.getClass().getSimpleName() + "was added");
        }
        else
        {
            System.out.println("Menu Item: " + menuItem.command.getClass().getSimpleName() + "could not be added");
        }

    }
}
