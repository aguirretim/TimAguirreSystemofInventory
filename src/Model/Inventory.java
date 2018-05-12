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
import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private final Map <Integer,Product> products = new HashMap <> ();
    private final Map <Integer, Part> allPart = new HashMap <> ();
    private static int partCounter = 0;
    private static int productCounter=0;
    
    private synchronized int getNewPartId(){
        return partCounter++;
    }
    
    private synchronized int getNewProductId(){
        return productCounter++;
    }
    
    public void addProduct(Product product) {
        // the right way to do it
        //Product p = new Product(product);
        
        // the easy way
        Product p = product;
        p.setProductID(getNewProductId());
        products.put(p.getProductID(), p);   
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
        products.put(product.getProductID(), product);
    }
    
    public void addPart(Part part) {
        Part p = part;
        p.setPartID(getNewPartId());
        this.allPart.put(p.getPartID(), p);   
    }
    
    public boolean deletePart(int partID) {
        Part found = allPart.remove(partID);
        return (found!=null);
    }
    
    public Part lookupPart(int partID) {
        return allPart.get(partID);
    }
    
    public void updatePart(Part part) {
        allPart.put(part.getPartID(), part);
    }
    
    
    
    
}
