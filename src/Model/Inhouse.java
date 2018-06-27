
package Model;
//needs to be a subclass of part with extends
public class Inhouse extends Part {

    private int MachineID;
    /***********************************
     Constructor
     ************************************/
    public Inhouse(int MachineID, 
            int partID, String name, double price, int inStock,
            int min, int max) {
        
        this.MachineID = MachineID;
        setPartID(partID);
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


}