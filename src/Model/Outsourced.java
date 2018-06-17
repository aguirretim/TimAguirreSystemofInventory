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
   
    private  int MachineID;
    
    
    /***********************************
     Constructor
     ************************************/

    public Outsourced(String companyName,int MachineID, int partID, String name, double price, int inStock,int min, int max) {
        this.companyName = companyName;
        MachineID = MachineID;
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
     public int getMachineID() {
        return MachineID;
    }

    public void setMachineID(int machineID) {
        MachineID = machineID;
    }
    
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

}

