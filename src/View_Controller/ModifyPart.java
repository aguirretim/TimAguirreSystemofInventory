/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View_Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Tim
 */
public class ModifyPart implements Initializable {
 
 /***********************************
 Variables for Buttons and Field.
 ************************************/

 @FXML
 private Button cancelButton;
 @FXML
 private Button saveButton;
 @FXML
 private RadioButton outsourcedRadioButton;
 @FXML
 private RadioButton inHouseButton;
 @FXML
 private TextField idText;
 @FXML
 private TextField nameText;
 @FXML
 private TextField invText;
 @FXML
 private TextField pricecostText;
 @FXML
 private TextField maxText;
 @FXML
 private TextField minText;
 @FXML
 private TextField machineidText;
 @FXML
 private Label machCompLbl;
 
 /***********************************
 Changing screens and scenes with buttons.
 ************************************/
    @FXML
    private void outsourcedButtonAction(ActionEvent event) throws IOException {
    machCompLbl.setText("Company Name");
    }

    
    @FXML
    private void inHouseButtonAction(ActionEvent event) throws IOException {
          machCompLbl.setText("Machine ID");
    }
    
    @FXML
    private void cancelButtonAction(ActionEvent event) throws IOException {
    cancelButton.getScene().getWindow().hide();
    }
    
    @FXML
 private void saveButtonAction(ActionEvent event) throws IOException {
     
     saveButton.getScene().getWindow().hide();  
 }
    
    public void transferData(String companyName, int MachineID, 
            int partID, String name, double price, int inStock,
            int min, int max){
    
            idText.setText(String.valueOf(partID) );
            nameText.setText(name);
            invText.setText(String.valueOf(inStock));
            pricecostText.setText(String.valueOf(price));
            maxText.setText(String.valueOf(min));
            minText.setText(String.valueOf(max));
          
            if (companyName == null){
                
                
                inHouseButton.setSelected(true);
            machineidText.setText(String.valueOf(MachineID));
            }
            else{
                outsourcedRadioButton.setSelected(true);
            machineidText.setText(companyName);   
            }
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
