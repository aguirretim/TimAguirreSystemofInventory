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
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventory {

    private static ObservableList<Part> allParts = FXCollections.observableArrayList();
    private static ObservableList<Product> allProducts = FXCollections.observableArrayList();
    private static int partCounter = 0;
    //private static int productCounter=0p

    private synchronized int getNewProductId() {
        return 3;
    }

    public void addProduct(Product product) {
        // the right way to do it
        //Product p = new Product(product);

        // the easy way
        /*Product p = product;
        p.setProductID(getNewProductId());*/
        //products.put(p.getProductID(), p);
        allProducts.add(product);
    }

    public boolean removeProduct(int productID) {

        //Product found = allProducts.reove(productID);
        //return (found != null);
        return false;
    }

    public Product lookupProduct(int productID) {

        // the easy way
        //return allProducts.get(productID);
                Product Fp = null;
        for(int i=0;i<allProducts.size();i++){
        if (productID==allProducts.get(i).getProductID()){
            Fp=allProducts.get(i);
        }
        
        }
        return Fp;
    }
        public Product lookupProductName(String productName) {
        Product Fp = null;
        for(int i=0;i<allProducts.size();i++){
        if (productName.equalsIgnoreCase(allProducts.get(i).getName())){
            
            Fp=allProducts.get(i);
        }
        
        }
        return Fp;
    }
        // the right way to do it
        //return new Product(allProducts.get(productID));
    

    public void updateProduct(Product product) {
        //products.put(product.getProductID(), product);
        allProducts.set(product.getProductID() - 1, product);
    }

    public void addPart(Part part) {
        allParts.add(part);
    }

    public void deletePart(Part part) {
       
        allParts.remove(part);
        //Part found = allParts.remove(partID);
          
         //return true;
       
     /*   if(partID<0 ||partID>=allParts.size()){
            return (false);
        }
        else {
            allParts.remove(partID - 1);
            return true;
        }*/
    }

    public Part lookupPart(int partID) {
        Part Fp = null;
        for(int i=0;i<allParts.size();i++){
        if (partID==allParts.get(i).getPartID()){
            Fp= allParts.get(i);
        }
        
        }
        return Fp;
    }
        public Part lookupPartName(String partName) {
        Part Fp = null;
        for(int i=0;i<allParts.size();i++){
        if (partName.equalsIgnoreCase(allParts.get(i).getName())){
            
            Fp=allParts.get(i);
        }
        
        }
        return Fp;
    }

    public void updatePart(Part part) {
        allParts.set(part.getPartID() - 1, part);
        //allParts.put(part.getPartID(), part);
    }

    public ObservableList<Part> getParts() {
        return allParts;
    }
    public ObservableList<Product> getProducts() {
        return allProducts;
    }

}
