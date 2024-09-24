package InventoryManagement;

import java.lang.reflect.Constructor;

/**
 * MenuItem
 */
public class MenuItem 
{
    public MenuItem(Command command, 
                    int optionNumber, 
                    String description, 
                    Boolean isRestricted)
    {
        //TODO Finish the implementation of this class

        System.out.println("Menu item created with command " + command.getClass().getSimpleName());
    }

}