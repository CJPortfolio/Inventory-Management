//Student ID: cjw220005
//Name: Christopher Wiratman
package InventoryManagement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * MenuList
 */
public class MenuList {

    protected static ArrayList<MenuItem> menuList;

    public MenuList(String menuHeader)
    {
        menuList = new ArrayList<>();
        System.out.println(menuHeader);

    }

    //Function opens a file and adds new menu item data
    //to the file and to list
    public static void AddMenuItem(MenuItem menuItem)
    {
        //Assigns the menu item to be added's option number to be the last one
        menuItem.optionNumber = menuList.size();

        //Assigns the exit item to an item object temporarily
        MenuItem ExitItem = menuList.get(menuList.size() - 1);
        
        //Assigns the exit item's option number to be the next size of the list 
        //when the menu item to be added gets added
        ExitItem.optionNumber = menuList.size() + 1;

        //Assigns the new menu item to the previous exit item's index in the list
        menuList.set(menuList.size() - 1, menuItem);

        //Adds the exit item to the last menu item in the list to be the last menu item
        menuList.add(ExitItem);

        File file = new File("C:\\\\Users\\\\cjwir\\\\OneDrive\\\\Documents\\\\GitHub\\\\InventoryManagement\\\\InventoryManagement\\\\InventoryManagement\\\\src\\\\main\\\\java\\\\InventoryManagement\\\\MenuList.dat");

        try
        {
            BufferedWriter fw = new BufferedWriter(new FileWriter(file, true));
            BufferedReader fr = new BufferedReader(new FileReader(file));
            String firstLine = fr.readLine();
            if(firstLine == null)
            {
                fw.write(menuItem.description + ", " + menuItem.isRestricted + ", " + menuItem.getClass().getSimpleName());
            }
            else
            {
                fw.write(System.lineSeparator() + menuItem.description + ", " + menuItem.isRestricted + ", " + menuItem.command.getClass().getSimpleName());
            }

            fw.close();
            fr.close();

        }
        catch(IOException Exception)
        {
            System.out.println("File does not exist or error writing to file");
        }


    }

    public static Boolean findMenuItem(MenuItem menuItem)
    {
        Boolean isSuccess = false;
        //Go through and try to find the menu item
        for (MenuItem itemLookedAt : menuList) {

            //If found returns true
            if(itemLookedAt.description.equals(menuItem.description))
            {
                isSuccess = true;
                return isSuccess;
            }
            
        }
        //If the entire list has been gone through and 
        //the menu item has not been found
        //returns false
        return isSuccess;
    }

    public void StartMenu(User user)
    {
        //TODO Display menu items based on user type, prompt user for command, execute selected command.

        

        for (MenuItem menu : menuList) 
        {
            if(user.isManager == true)
            {
                System.out.println(menu.optionNumber + "- " + menu.description);
            }
            
            else if(menu.isRestricted == false)
            {
                System.out.println(menu.optionNumber + "- " + menu.description);

            }
        }

        System.out.println("Enter your selection: ");
            
    }
}