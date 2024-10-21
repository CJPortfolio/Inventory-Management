//Student ID: cjw220005
//Name: Christopher Wiratman
package InventoryManagement;
import java.util.ArrayList;

/**
 * ProductCatalog
 */
public class ProductCatalog {

    //TODO implement the ProductCatalog methods and fields. Add a collection to hold Product objects

    public ArrayList<Product> productCatalog;
    
    public ProductCatalog()
    {
        this.productCatalog = new ArrayList<>();
    }

    //Add or update a product if already exists
    public void AddUpdateProduct(Product product)
    {
        //TODO if product exists, update file

        if(FindProduct(product.ID) == true)
        {
            
        }
        else
        {
            this.productCatalog.add(product);
        }
    
        //TODO add a product to file or update it in the file
    }

    //TODO create an overload of the AddUpdateProduct method
    // public void AddUpdateProduct(....) 
    // {

    // }

    public boolean RemoveProduct(int productId)
    {
        boolean isSuccess = true; 

        return isSuccess; 
    }

    //TODO create an overload of the RemoveProduct method to remove by product name
    public boolean RemoveProduct(String productName)
    {
        boolean isSuccess = true; 

         return isSuccess; 
    }

    public boolean FindProduct(int productId)
    {
        boolean isSuccess = false;
        for (Product product : productCatalog) 
        {
            if(product.ID == productId )
            {
                isSuccess = true;
                break;
            }
        }

        return isSuccess; 
    }

    //TODO create an overload of the FindProduct method to find product by product name
    public boolean FindProduct(String productName)
    {
        boolean isSuccess = false;

        /* 
         Id     Name         Cost      Quantity        Retail 
         ---------------------------------------------------- 
         3424   Smart Watch  $20.45    23              $36.81 
        */
        
        for (Product product : productCatalog) 
        {
            if(product.Name.equals(productName))
            {
                isSuccess = true;
                break;
            }
        }

        return isSuccess; 
    }

    //Print information about a product including retail price (cost + (margin*cost/100))
    public String PrintProductInformation(int productId)
    {
        String productInformation = null;

        for (Product product : productCatalog) 
        {
            if(FindProduct(productId) == true)
            {
                productInformation = "";
                productInformation += (product.ID + "  " + product.Name + "  " + product.Cost + "        " + product.Quantity);
                break;
            }
        }

        return productInformation;
    }

    //Print all product information in the inventory
    public String PrintInventoryList()
    {
        StringBuilder inventoryInformation = new StringBuilder();

        for (Product product : productCatalog) 
        {
            inventoryInformation.append(product.ID + "  " + product.Name + "  " + product.Cost + "        " + product.Quantity);
            inventoryInformation.append("\n");
        }

        return inventoryInformation.toString(); 
    }
}