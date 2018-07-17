/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View_Controller;

import Model.Inhouse;
import Model.Inventory;
import Model.Outsourced;
import java.io.IOException;
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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Tim
 */
public class AddProductController implements Initializable {

    
    
 /***********************************
 Variables for Buttons and Field.
 ************************************/
 
    
    
 @FXML
 private Button cancelButton;
 @FXML
 private Button saveButton;
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
 
 Inventory initInventory = new Inventory();
 
 
 /***********************************
 Changing screens and scenes with buttons.
 ************************************/


@FXML
 private void cancelButtonAction(ActionEvent event) throws IOException {
  Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

alert.setHeaderText("Cancel creating this Product?");
alert.setContentText("Are you sure you want to cancel?");

Optional<ButtonType> result = alert.showAndWait();
if (result.get() == ButtonType.OK){
    // ... user chose OK
    cancelButton.getScene().getWindow().hide();
}
    }

 @FXML
 private void saveButtonAction(ActionEvent event) throws IOException {

  


   /*if (inHouseButton.isSelected()) {
    initInventory.addPart(new Inhouse(
     Integer.parseInt(
      machineidText.getText()),
     initInventory.getParts().size() + 1,
     nameText.getText(),
     Double.parseDouble(pricecostText.getText()),
     Integer.parseInt(invText.getText()),
     Integer.parseInt(minText.getText()),
     Integer.parseInt(maxText.getText())));
    saveButton.getScene().getWindow().hide();
   } else if (outsourcedRadioButton.isSelected()) {
    initInventory.addPart(new Outsourced(
     machineidText.getText(),
     initInventory.getParts().size() + 1,
     nameText.getText(),
     Double.parseDouble(pricecostText.getText()),
     Integer.parseInt(invText.getText()),
     Integer.parseInt(minText.getText()),
     Integer.parseInt(maxText.getText())));
    saveButton.getScene().getWindow().hide();
   } else {
    System.out.println("Something weird happaned with creating a part");
   }*/

 }
 /**
  * Initializes the controller class.
  */
 @Override
 public void initialize(URL url, ResourceBundle rb) {
  // TODO
 }

}