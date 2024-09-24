package InventoryManagement;

/**
 * ProductCatalog
 */
public class ProductCatalog {

    //TODO implement the ProductCatalog methods and fields. Add a collection to hold Product objects
    public ProductCatalog()
    {

    }

    //Add or update a product if already exists
    public void AddUpdateProduct(Product product)
    {

    }

    //TODO create an overload of the AddUpdateProduct method
    // public void AddUpdateProduct(....) 
    // {

    // }

    public boolean RemoveProduct(int productId)
    {
        boolean isSuccess = false; 

        return isSuccess; 
    }

    //TODO create an overload of the RemoveProduct method to remove by product name
    // public boolean RemoveProduct(...)
    // {
    //     boolean isSuccess = false; 

    //     return isSuccess; 
    // }

    public boolean FindProduct(int productId)
    {
        boolean isSuccess = false; 

        return isSuccess; 
    }

    //TODO create an overload of the FindProduct method to find product by product name
    // public boolean FindProduct(...)
    // {
    //     boolean isSuccess = false; 

    //     return isSuccess; 
    // }

    //Print information about a product including retail price (cost + (margin*cost/100))
    public String PrintProductInformation(int productId)
    {
        String productInformation = null;

        return productInformation;
    }

    //Print all product information in the inventory
    public String PrintInventoryList()
    {
        StringBuilder inventoryInformation = new StringBuilder(); 

        return inventoryInformation.toString(); 
    }
}