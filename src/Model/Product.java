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
    private ArrayList Part;
    private int ProductID;
    private String Name;
    private double Price;
    private int InStock;
    private int Min;
    private int Max;

    /***********************************
     Constructor
     ************************************/
    public Product(ArrayList part, int productID, String name, double price, int inStock, int min, int max) {
        Part = part;
        ProductID = productID;
        Name = name;
        Price = price;
        InStock = inStock;
        Min = min;
        Max = max;
    }


    public void addAssociatedPart(String part) {
        Part.add(part);
    }

    public void removeAssociatedPart() {

    }

    public void lookupAssociatedPart() {

    }



    /***********************************
     Getters
     ************************************/
    public ArrayList getPart() {
        return Part;
    }

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
     ************************************/
    public void setPart(ArrayList part) {
        Part = part;
    }

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

