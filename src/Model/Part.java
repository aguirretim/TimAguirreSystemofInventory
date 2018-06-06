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

public abstract class Part {
        private int PartID;
        private String Name;
        private double Price;
        private int InStock;
        private int Min;
        private int Max;


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.PartID;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Part other = (Part) obj;
        if (this.PartID != other.PartID) {
            return false;
        }
        return true;
    }

        /***********************************
         Getters and Setters
         ************************************/
        public int getPartID() {
            return PartID;
        }

        public void setPartID(int partID) {
            PartID = partID;
        }

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }

        public double getPrice() {
            return Price;
        }

        public void setPrice(double price) {
            Price = price;
        }

        public int getInStock() {
            return InStock;
        }

        public void setInStock(int inStock) {
            InStock = inStock;
        }

        public int getMin() {
            return Min;
        }

        public void setMin(int min) {
            Min = min;
        }

        public int getMax() {
            return Max;
        }

        public void setMax(int max) {
            Max = max;
        }


}