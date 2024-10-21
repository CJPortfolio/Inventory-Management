//Student ID: cjw220005
//Name: Christopher Wiratman
package InventoryManagement;

/**
 * This class represent a line in Inventory.dat file
 */
public class Product 
{
    //TODO Add the following fields and a constructor to set the fields: 
    //                          Id (int, this is the unique product id)
    //                          Name (string)
    //                          Cost(double)
    //                          Quantity(int)
    //                          Margin(int as a percentage)

    protected int ID;
    protected String Name;
    protected double Cost;
    protected int Quantity;
    protected int Margin;

    public Product(int id, String name, double cost, int quantity, int margin)
    {
        this.ID = id;
        this.Name = name;
        this.Cost = cost;
        this.Quantity = quantity;
        this.Margin = margin;
    }

    public void setID (int id)
    {
        this.ID = id;
    }

    public int getID()
    {
        return this.ID;
    }

    public void setName(String name)
    {
        this.Name = name;
    }

    public String getName()
    {
        return this.Name;
    }

    public void setCost(double cost) {
        this.Cost = cost;
    }

    public double getCost()
    {
        return this.Cost;
    }

    public void setQuantity(int quantity)
    {
        this.Quantity = quantity;
    }

    public int getQuantity()
    {
        return this.Quantity;
    }

    public void setMargin(int margin)
    {
        this.Margin = margin;
    }

    public int getMargin()
    {
        return this.Margin;
    }
    

}