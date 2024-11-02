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
 * ProductCatalog
 */
public class ProductCatalog {

    //TODO implement the ProductCatalog methods and fields. Add a collection to hold Product objects

    public static ArrayList<Product> productCatalog;
    
    public ProductCatalog()
    {
        this.productCatalog = new ArrayList<>();
    }

    //Adds a product if product does not exist on records
    public static void AddUpdateProduct(Product product)
    {
        //TODO add a product to file or update it in the file


        if(!FindProduct(product.ID))
        {
            //Adds product to list
            productCatalog.add(product);

            File inventoryFile = new File("C:\\Users\\cjwir\\OneDrive\\Documents\\GitHub\\InventoryManagement\\InventoryManagement\\InventoryManagement\\src\\main\\java\\InventoryManagement\\Inventory.dat");
            try 
            {
                BufferedWriter writer = new BufferedWriter(new FileWriter(inventoryFile, true));
                writer.write("\n" + product.ID + ", " + product.Name + ", " + product.getCost() + ", " + product.getQuantity() + ", " + product.getMargin());
                writer.close();
            } 
            catch (IOException ex) 
            {
                System.out.println("Error with file");
            }

        }
        else
        {
            System.out.println("Product already exists");
        }
        
    }

    //TODO create an overload of the AddUpdateProduct method
    //This overload function modifies an existing product already on file
    public static void AddUpdateProduct(Product modifiedProduct, String productName) 
    {
        
        //Check if product exists first to be able to modify the product
        if(!FindProduct(productName))
        {
            System.out.println("Product does not exist");
            return;
        }

        //Find index of product in list and replace the element with the modified product
        int indexOfProduct = FindIndexOfProduct(productName);
        //System.out.println("Index of product in list: " + indexOfProduct);
        productCatalog.set(indexOfProduct, modifiedProduct);

        
        //Create File object to read to and tempFile to write and replace inventoryFile
        File inventoryFile = new File("C:\\Users\\cjwir\\OneDrive\\Documents\\GitHub\\InventoryManagement\\InventoryManagement\\InventoryManagement\\src\\main\\java\\InventoryManagement\\Inventory.dat");
        File tempFile = new File("tempFile.dat");
    
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(inventoryFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            String currentLine;

            
            //Check if the first line is null and if so assume it is an empty file
            //and return back to command selection
            if((currentLine = reader.readLine()) == null)
            {
                System.out.println("Empty file, no user to delete");
                reader.close();
                writer.close();
                return;
            }

        
            //Check if first line contains the product to replace with modified product
            if(currentLine.contains(productName))
            {
                //If first line contains product to be modified, writes the modified new product to the file
                writer.write(modifiedProduct.ID + ", " + modifiedProduct.Name + ", " + modifiedProduct.getCost() + ", " + modifiedProduct.getQuantity() + ", " + modifiedProduct.getMargin());
            }

            //Writes the first line if it doesn't contain the product to be modified
            else
            {
                writer.write(currentLine);
            }


            //Goes through the file and checks if the line it is currently
            //reading contains the product to be modified's name
            while((currentLine = reader.readLine()) != null)
            {
                //System.out.println(currentLine);

                //Writes the modified product instead of the product to be modified
                //if the product contains the product name
                if(currentLine.contains(productName))
                {
                    writer.write("\n" + modifiedProduct.ID + ", " + modifiedProduct.Name + ", " + modifiedProduct.getCost() + ", " + modifiedProduct.getQuantity() + ", " + modifiedProduct.getMargin());
                }
                //Writes the current line if condition is not met
                else
                {
                    writer.write(System.lineSeparator() + currentLine);
                }
            }

            //Closes reader and writer files
            //Deletes old inventory file and renames the
            //temp file to the old inventory file
            reader.close();
            writer.close();
            inventoryFile.delete();
            tempFile.renameTo(inventoryFile);
        }

        catch(IOException e)
        {
            System.out.println("Error with file");
        }
        
    }

    //Overloaded with an integer
    public static boolean RemoveProduct(int productId)
    {
        boolean isSuccess = false;

        //Check if product exists first to be able to modify the product
        if(!FindProduct(productId))
        {
            System.out.println("Product does not exist");
            return isSuccess ;
        }

        //TODO Make implementation here
        

        //Find index of product in list and replace the element with the modified product
        int indexOfProduct = FindIndexOfProduct(productId);
        //System.out.println("Index of product in list: " + indexOfProduct);
        productCatalog.remove(indexOfProduct);

        
        //Create File object to read to and tempFile to write and replace inventoryFile
        File inventoryFile = new File("C:\\Users\\cjwir\\OneDrive\\Documents\\GitHub\\InventoryManagement\\InventoryManagement\\InventoryManagement\\src\\main\\java\\InventoryManagement\\Inventory.dat");
        File tempFile = new File("tempFile.dat");
    
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(inventoryFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            String currentLine;
            String splitline[];

            
            //Check if the first line is null and if so assume it is an empty file
            //and return back to command selection
            if((currentLine = reader.readLine()) == null)
            {
                System.out.println("Empty file, no user to delete");
                reader.close();
                writer.close();
                return isSuccess;
            }

            splitline = currentLine.split(", ");
            
            int IDlookedAt = Integer.parseInt(splitline[0]);
        
            //Check if first line contains the product to replace with modified product
            if(!(IDlookedAt == productId))
            {
                //If first line does not have product ID then write that first line
                writer.write(currentLine);            
            }
            //If the current line has the product ID to remove
            //Skip the first line and move to the second line
            //and write that line to the temp file
            else
            {
                currentLine = reader.readLine();
                writer.write(currentLine);
            }

            //Writes the first line if it doesn't contain the product to be modified


            //Goes through the file and checks if the line it is currently
            //reading contains the product id

            while((currentLine = reader.readLine()) != null)
            {
                //Splits the current line into 5 different data elements
                //and assigns the first element/product id to be the ID to look at
                splitline = currentLine.split(", ");
                IDlookedAt = Integer.parseInt(splitline[0]);
 
                //If first line does not have product ID then write that line
                if(!(IDlookedAt == productId))
                {
                    writer.write(System.lineSeparator() + currentLine);            
                }
            }

            //Closes reader and writer files
            //Deletes old inventory file and renames the
            //temp file to the old inventory file
            reader.close();
            writer.close();
            inventoryFile.delete();
            tempFile.renameTo(inventoryFile);
        }

        catch(IOException e)
        {
            System.out.println("Error with file");
        }

        //TODO END OF IMPLEMENTATION
        
        //Check if product was removed from list
        //if so, makes isSuccess true
        if(!FindProduct(productId))
        {
            isSuccess = true;
        }
        return isSuccess; 
    }

    //TODO create an overload of the RemoveProduct method to remove by product name
    //Overloaded with a string
    public static boolean RemoveProduct(String productName)
    {
        boolean isSuccess = false; 

        if(!FindProduct(productName))
        {
            System.out.println("Product does not exist");
            return isSuccess;
        }

        //TODO Make implementation here

        //Finds index of product
        int index = FindIndexOfProduct(productName);

        //Removes product found on index in the list
        productCatalog.remove(index);

        //Create File object to read to and tempFile to write and replace inventoryFile
        File inventoryFile = new File("C:\\Users\\cjwir\\OneDrive\\Documents\\GitHub\\InventoryManagement\\InventoryManagement\\InventoryManagement\\src\\main\\java\\InventoryManagement\\Inventory.dat");
        File tempFile = new File("tempFile.dat");
    
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(inventoryFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            String currentLine;

            
            //Check if the first line is null and if so assume it is an empty file
            //and return back to command selection
            if((currentLine = reader.readLine()) == null)
            {
                System.out.println("Empty file, no user to delete");
                reader.close();
                writer.close();
                return isSuccess;
            }
        
            //Check if first line contains the product to replace with modified product
            if(!(currentLine.contains(productName)))
            {
                //If first line does not have product ID then write that first line
                writer.write(currentLine);            
            }
            //If the current line has the product ID to remove
            //Skip the first line and move to the second line
            //and write that line to the temp file
            else
            {
                currentLine = reader.readLine();
                writer.write(currentLine);
            }

            //Writes the first line if it doesn't contain the product to be modified


            //Goes through the file and checks if the line it is currently
            //reading contains the product id

            while((currentLine = reader.readLine()) != null)
            {
                //Splits the current line into 5 different data elements
                //and assigns the first element/product id to be the ID to look at
                
 
                //If first line does not have product ID then write that line
                if(!(currentLine.contains(productName)))
                {
                    writer.write(System.lineSeparator() + currentLine);            
                }
            }

            //Closes reader and writer files
            //Deletes old inventory file and renames the
            //temp file to the old inventory file
            reader.close();
            writer.close();
            inventoryFile.delete();
            tempFile.renameTo(inventoryFile);
        }

        catch(IOException e)
        {
            System.out.println("Error with file");
        }

        //TODO END OF IMPLEMENTATION


        //Check if product was removed from list
        if(!FindProduct(productName))
        {
            isSuccess = true;
        }
        return isSuccess; 
    }

    public static boolean FindProduct(int productId)
    {
        boolean isSuccess = false;
        for (Product product : productCatalog) 
        {
            if(product.ID == productId )
            {
                System.out.println(product.ID);
                isSuccess = true;
                return isSuccess;
            }
        }

        return isSuccess; 
    }

    //TODO create an overload of the FindProduct method to find product by product name
    public static boolean FindProduct(String productName)
    {
        boolean isSuccess = false;
        
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

    public static int FindIndexOfProduct(String productName)
    {
        int index = -1;

        for (int i = 0; i < productCatalog.size(); ++i) 
        {
            if(productCatalog.get(i).Name.equals(productName))
            {
                return i;
            }
        }

        return index;
    }


    public static int FindIndexOfProduct(int productID)
    {
        int index = -1;

        for (int i = 0; i < productCatalog.size(); ++i) 
        {
            if(productCatalog.get(i).ID == productID)
            {
                return i;
            }
        }

        return index;
    }

    //Print information about a product including retail price (cost + (margin*cost/100))
    public String PrintProductInformation(int productId)
    {
        /* 
         Id     Name         Cost      Quantity        Retail 
         ---------------------------------------------------- 
         3424   Smart Watch  $20.45    23              $36.81 
        */
    
        //Initalize the string to be empty to add header and information to it
        String productInformation = "";

        //Check if product exists
        //If not return with statement "Product was not found"
        if(!FindProduct(productId))
        {
            productInformation += "Product was not found";
            return productInformation;
        }

        //Add Header to string
        productInformation += String.format("%-6s %-20s %-12s %-10s %-10s\n", "Id", "Name", "Cost", "Quantity", "Retail") +
        "-------------------------------------------------------------\n";

        for(int i = 0; i < productCatalog.size(); ++i)
        {
            if(productCatalog.get(i).ID == productId)
            {
                //Add organized data to string
                productInformation += 
                String.format("%-6d %-20s $%-11.2f %-10d $%-10.2f",
                productCatalog.get(i).ID, productCatalog.get(i).Name, productCatalog.get(i).Cost, productCatalog.get(i).Quantity, (productCatalog.get(i).Cost + (productCatalog.get(i).Margin * productCatalog.get(i).Cost/100)));
            }
        }

        return productInformation;
    }

    //Print all product information in the inventory
    public String PrintInventoryList()
    {

        /* 
         Id     Name         Cost      Quantity        Retail 
         ---------------------------------------------------- 
         3424   Smart Watch  $20.45    23              $36.81 
        */

        //Make StringBuilder type
        StringBuilder inventoryInformation = new StringBuilder();

        //Append header to start adding data to display
        inventoryInformation.append(String.format("%-6s %-20s %-12s %-10s %-10s\n", "Id", "Name", "Cost", "Quantity", "Retail") + "-------------------------------------------------------------\n");

        //Go through list getting and appending data
        for(int i = 0; i < productCatalog.size(); ++i)
        {
           //Add organized data to string
           inventoryInformation.append(String.format("%-6d %-20s $%-11.2f %-10d $%-10.2f %n",
           productCatalog.get(i).ID, productCatalog.get(i).Name, productCatalog.get(i).Cost, productCatalog.get(i).Quantity, (productCatalog.get(i).Cost + (productCatalog.get(i).Margin * productCatalog.get(i).Cost/100))));
        }

        /* 
        for (Product product : productCatalog) 
        {
            inventoryInformation
            .append(product.ID).append("  ")
            .append(product.Name).append("  ")
            .append(product.Cost).append("        ")
            .append(product.Quantity).append("\n");
        }
        */

        return inventoryInformation.toString(); 
    }
}