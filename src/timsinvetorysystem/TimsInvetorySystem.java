/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timsinvetorysystem;

import Model.Inhouse;
import Model.Outsourced;
import Model.Inventory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Tim
 */


public class TimsInvetorySystem extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View_Controller/Main.fxml"));
                      
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Inventory initInventory = new Inventory();
        /*initInventory.addPart(new Inhouse(111, 0, "tire", 9.99, 50,1, 100));
        initInventory.addPart(new Inhouse(222, 1, "screws", .50, 100,1, 100));
        initInventory.addPart(new Outsourced("TimCompany",333, 2, "Frame", 1.50, 40,1, 100));
        initInventory.addPart(new Outsourced("BOBCompany",444, 3, "Metalic Screen", .75, 20,1, 100));
       */
     
        launch(args);
    
    }
    
}
