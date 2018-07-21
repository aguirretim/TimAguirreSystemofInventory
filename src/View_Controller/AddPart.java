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
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
 @FXML
 private int inventoryCount;
 @FXML
 private int minCount;
 @FXML
 private int maxCount;
 @FXML
 private int partCount;


 
 Inventory initInventory = new Inventory();



 /***********************************
 Changing screens and scenes with buttons.
 ************************************/



 public boolean validateMinMax() {
  
  minCount = Integer.parseInt(minText.getText());
  maxCount = Integer.parseInt(maxText.getText());
  
  if (Integer.parseInt(minText.getText()) > Integer.parseInt(maxText.getText())) {
   Alert alert = new Alert(Alert.AlertType.INFORMATION);
   alert.setTitle("Information Dialog");
   alert.setHeaderText("Error");
   alert.setContentText("The maximum must have a value greater than minimum!");
   alert.showAndWait();
   System.out.println("The maximum must have a value greater than minimum!");
   return false;
  } else {
   return true;
  }
 }

 public boolean validateInventory() {
 minCount = Integer.parseInt(minText.getText());
 maxCount = Integer.parseInt(maxText.getText());
inventoryCount = Integer.parseInt(invText.getText());

  if ((inventoryCount < minCount) || (inventoryCount > maxCount)) {
   Alert alert = new Alert(Alert.AlertType.INFORMATION);
   alert.setTitle("Information Dialog");
   alert.setHeaderText("Error");
   alert.setContentText("Inventory must be between the minimum or maximum value for that Part!");
   alert.showAndWait();
   System.out.println("Inventory must be between the minimum or maximum value for that Part!");
   return false;
  } else {
   return true;
  }
 }

 @FXML
 private void outsourcedButtonAction(ActionEvent event) {
  machCompLbl.setText("Company Name");
 }

 @FXML
 private void inHouseButtonAction(ActionEvent event) {
  machCompLbl.setText("Machine ID");
 }

 @FXML
 private void cancelButtonAction(ActionEvent event) throws IOException {
  Alert alert = new Alert(AlertType.CONFIRMATION);

alert.setHeaderText("Cancel creating this Part?");
alert.setContentText("Are you sure you want to cancel?");

Optional<ButtonType> result = alert.showAndWait();
if (result.get() == ButtonType.OK){
    // ... user chose OK
    cancelButton.getScene().getWindow().hide();
}
    }

 @FXML
 private void saveButtonAction(ActionEvent event) throws IOException {
     
     

  
     int lastRow=initInventory.getParts().size()-1; 
     int partID;  
     try {
      partID=initInventory.getParts().get(lastRow).getPartID()+1;}
    catch (ArrayIndexOutOfBoundsException e){
      partID=1;
    
    }
     
      
       
     
     
  if (validateMinMax() && validateInventory()) {

   if (inHouseButton.isSelected()) {
    initInventory.addPart(new Inhouse(
     Integer.parseInt(
      machineidText.getText()),
     partID,
     nameText.getText(),
     Double.parseDouble(pricecostText.getText()),
     Integer.parseInt(invText.getText()),
     Integer.parseInt(minText.getText()),
     Integer.parseInt(maxText.getText())));
    saveButton.getScene().getWindow().hide();
   } else if (outsourcedRadioButton.isSelected()) {
    initInventory.addPart(new Outsourced(
     machineidText.getText(),
     partID,
     nameText.getText(),
     Double.parseDouble(pricecostText.getText()),
     Integer.parseInt(invText.getText()),
     Integer.parseInt(minText.getText()),
     Integer.parseInt(maxText.getText())));
    saveButton.getScene().getWindow().hide();
   } else {
    System.out.println("Something weird happaned with creating a part");
   }

  }



 }
 /**
  * Initializes the controller class.
  */

 @Override
 public void initialize(URL url, ResourceBundle rb) {

 }

}