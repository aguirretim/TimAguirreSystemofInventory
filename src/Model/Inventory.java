/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Tim
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private static ArrayList<Part> allParts = new ArrayList<>(); 
    private static ArrayList<Product> products = new ArrayList<>(); 
    private static int partCounter = 0;
    //private static int productCounter=0p
    
    private synchronized int getNewPartId(){
        return partCounter++;
    }
    
    private synchronized int getNewProductId(){
       return 3;
    }
    
    public void addProduct(Product product) {
        // the right way to do it
        //Product p = new Product(product);
        
        // the easy way
        Product p = product;
        p.setProductID(getNewProductId());
        //products.put(p.getProductID(), p);   
    }

    public boolean removeProduct(int productID) {
        
        Product found = products.remove(productID);
        return (found!=null);
        
    }
  
    public Product lookupProduct(int productID) {
        
        // the easy way
        return products.get(productID);
        // the right way to do it
        //return new Product(products.get(productID));
    }
    
    public void updateProduct(Product product) {
        //products.put(product.getProductID(), product);
    }
    
    public void addPart(Part part) {
       allParts.add(part);
    }
    
    public boolean deletePart(int partID) {
       // Part found = allPart.remove(partID);
        return (false);
    }
    
    public Part lookupPart(int partID) {
        return allParts.get(partID);
    }
    
    public void updatePart(Part part) {
        //allPart.put(part.getPartID(), part);
    }
    
    
    
    
}
