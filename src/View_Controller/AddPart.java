/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View_Controller;

import Model.Inhouse;
import Model.Outsourced;
import Model.Inventory;
import Model.Part;
import java.io.IOException;
import static java.lang.Double.parseDouble;
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
public class AddPart implements Initializable {
  
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

Inventory initInventory = new Inventory();

 @FXML
 private void outsourcedButtonAction(ActionEvent event)  {
 machCompLbl.setText("Company Name");
 }

 @FXML
 private void inHouseButtonAction(ActionEvent event) {
 machCompLbl.setText("Machine ID");
 }

 @FXML
 private void cancelButtonAction(ActionEvent event) throws IOException {
    cancelButton.getScene().getWindow().hide();
  }
 
 
 //Depending on what is selected it creates a  
  @FXML
 private void saveButtonAction(ActionEvent event) throws IOException {
   if (inHouseButton.isSelected()){
           initInventory.addPart(new Inhouse(
                   Integer.parseInt(
           machineidText.getText()),
           initInventory.getParts().size()+1,
           nameText.getText(),
           Double.parseDouble(pricecostText.getText()),
           Integer.parseInt(invText.getText()),
           Integer.parseInt(minText.getText()),
           Integer.parseInt(maxText.getText())));
           saveButton.getScene().getWindow().hide();        
   }
   
   else if (outsourcedRadioButton.isSelected()){
           initInventory.addPart(new Outsourced(
           machineidText.getText(),
           initInventory.getParts().size()+1,
           nameText.getText(),
           Double.parseDouble(pricecostText.getText()),
           Integer.parseInt(invText.getText()),
           Integer.parseInt(minText.getText()),
           Integer.parseInt(maxText.getText())));
           saveButton.getScene().getWindow().hide();
   } else{
    System.out.println("Something weird happaned with creating a part");  
   }
   
          
  }
  /**
   * Initializes the controller class.
   */

 @Override
 public void initialize(URL url, ResourceBundle rb) {
 
 }

}