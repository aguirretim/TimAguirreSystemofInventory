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

public class Product {
    private ArrayList <Part> associatedParts = new ArrayList<>();
    private int ProductID;
    private String Name;
    private double Price;
    private int InStock;
    private int Min;
    private int Max;

    /***********************************
     Constructor
     * @param part
     * @param productID
     * @param name
     * @param price
     * @param inStock
     * @param min
     * @param max
     ************************************/
    public Product(ArrayList part, int productID, String name, double price, int inStock, int min, int max) {
        associatedParts = part;
        ProductID = productID;
        Name = name;
        Price = price;
        InStock = inStock;
        Min = min;
        Max = max;
    }

    /***********************************
     Constructor
     * @param other
     ************************************/
    public Product(Product other) {
        associatedParts = other.associatedParts;
        ProductID = other.ProductID;
        Name = other.Name;
        Price = other.Price;
        InStock = other.InStock;
        Min = other.Min;
        Max = other.Max;
    }


    public void addAssociatedPart(Part part) {
        //associatedParts.add(part);
        // to avoid dup.
        if(associatedParts.indexOf(part)<0)associatedParts.add(part);
    }

    public boolean removeAssociatedPart(int partid) {
        boolean found = false;
        for(Part p: this.associatedParts) {
            if(partid==p.getPartID()) {
                this.associatedParts.remove(p);
                found = true;
            }
        }
        return found;
    }

    public Part lookupAssociatedPart(int partid) {
        for(Part p: this.associatedParts) {
            if(partid==p.getPartID()) return p;
        }
        return null;
    }



    /***********************************
     Getters
     * @return 
     ************************************/

    public int getProductID() {
        return ProductID;
    }

    public String getName() {
        return Name;
    }

    public double getPrice() {
        return Price;
    }

    public int getInStock() {
        return InStock;
    }

    public int getMin() {
        return Min;
    }

    public int getMax() {
        return Max;
    }

    /***********************************
     Setters
     * @param part
     ************************************/

    public void setProductID(int productID) {
        ProductID = productID;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public void setInStock(int inStock) {
        InStock = inStock;
    }

    public void setMin(int min) {
        Min = min;
    }

    public void setMax(int max) {
        Max = max;
    }

}

