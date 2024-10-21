//Student ID: cjw220005
//Name: Christopher Wiratman
package InventoryManagement;

/**
 * MenuItem
 */
public class MenuItem 
{

    //Constructor that takes in a command, the option number, 
    //a description for the command and the Boolean for if it is restricted to managers only

    protected Command command;
    protected int optionNumber;
    protected String description;
    protected Boolean isRestricted;

    public MenuItem(Command command, 
                    int optionNumber, 
                    String description, 
                    Boolean isRestricted)
    {
        //TODO Finish the implementation of this class

        this.command = command;
        this.optionNumber = optionNumber;
        this.description = description;
        this.isRestricted = isRestricted;

        //System.out.println("Menu item created with command " + command.getClass().getSimpleName());
    }



}