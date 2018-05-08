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
//abstract?
public class Part {
        private int PartID;
        private String Name;
        private double Price;
        private int InStock;
        private int Min;
        private int Max;

        /***********************************
        Constructor
        ************************************/

        public Part(int partID, String name, double price, int inStock, int min, int max) {
        PartID = partID;
        Name = name;
        Price = price;
        InStock = inStock;
        Min = min;
        Max = max;
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