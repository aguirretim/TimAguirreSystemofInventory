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

//needs to be a subclass of part with extends
public class Outsourced extends Part {
    
    private String companyName;
   
   
    
    
    /***********************************
     Constructor
     ************************************/

    public Outsourced(String companyName, int partID, String name, double price, int inStock,int min, int max) {
        this.companyName = companyName;        
        setPartID(++partID);
        setName(name);
        setPrice(price);
        setInStock(inStock);
        setMin(min);
        setMax(max);
    }
            
    /***********************************
     Getters and Setters
     ************************************/
     
    
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

}

