//Student ID: cjw220005
//Name: Christopher Wiratman
package InventoryManagement;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * MenuList
 */
public class MenuList {

    protected ArrayList<MenuItem> menuList;

    public MenuList(String menuHeader)
    {
        menuList = new ArrayList<>();
        System.out.println(menuHeader);

    }

    //Function opens a file and adds new menu item data
    //to the file and to list
    public void AddMenuItem(MenuItem menuItem)
    {
        menuList.add(menuItem);

        File file = new File("C:\\\\Users\\\\cjwir\\\\OneDrive\\\\Documents\\\\GitHub\\\\InventoryManagement\\\\InventoryManagement\\\\InventoryManagement\\\\src\\\\main\\\\java\\\\InventoryManagement\\\\MenuList.dat");

        try
        {
            FileWriter fr = new FileWriter(file, true);
            fr.write(menuItem.description + ", " + menuItem.isRestricted + ", " + menuItem.getClass().getSimpleName());

        }
        catch(IOException Exception)
        {
            System.out.println("File does not exist or error writing to file");
        }


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