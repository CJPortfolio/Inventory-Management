//Student ID: cjw220005
//Name: Christopher Wiratman
package InventoryManagement;

import java.lang.reflect.Constructor;
 
/**
 * Command
 */

/*
Abstract class does not allow for itself to be instantiated

Subclasses in the abstract class are based off of the abstract class

*/

public abstract class Command 
{
    //TODO: add necessary fields to this class

    protected ProductCatalog productCatalog;
    protected User loggedOnUser;

    //Constructor for Command class that gets the product catalog
    //and the logged on user
    
    public Command(ProductCatalog productCatalog, User loggedOnUser)
    {
        this.productCatalog = productCatalog;
        this.loggedOnUser = loggedOnUser;
    }


    public static Command CreateCommandDynamically(ProductCatalog productCatalog, User user, String commandClassName)
    {
        Class<?>    concreteCommandClass    = null;
        Command     command                 = null;
        String      packageName             = "InventoryManagement"; 

        try 
        {
            concreteCommandClass = Class.forName(packageName + "." + commandClassName);
            Constructor<?> con = concreteCommandClass.getConstructor(ProductCatalog.class, User.class);
            command = (Command)con.newInstance(productCatalog, user);
        } 
        catch (final Exception e) 
        {
            e.printStackTrace();
        }

        return command;
    }

    //An abstract method that must be overriden in subclasses of class Command
    public abstract void Execute(); 


}