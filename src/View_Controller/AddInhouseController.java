/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View_Controller;

import Model.Inhouse;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Tim
 */
public class AddInhouseController implements Initializable {
    
    public interface PartAdder {
        void addPart(Part p);
    }
    
    private PartAdder partAdder;

    public void setPartAdder(PartAdder adder) {
        this.partAdder = adder;
    }

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



 /***********************************
 Changing screens and scenes with buttons.
 ************************************/



 @FXML
 private void outsourcedButtonAction(ActionEvent event) throws IOException {
  Stage stage;
  Parent root;
  stage = (Stage) outsourcedRadioButton.getScene().getWindow();
  root = FXMLLoader.load(getClass().getResource("/View_Controller/AddOutsourced.fxml"));
  //Create a new scene with roo and set the stage
  Scene scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
 }

 @FXML
 private void inHouseButtonAction(ActionEvent event) throws IOException {
  Stage stage;
  Parent root;
  stage = (Stage) inHouseButton.getScene().getWindow();
  root = FXMLLoader.load(getClass().getResource("/View_Controller/AddInhouse.fxml"));
  //Create a new scene with roo and set the stage
  Scene scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
 }

 @FXML
 private void cancelButtonAction(ActionEvent event) throws IOException {
   Stage stage;
   Parent root;
   stage = (Stage) cancelButton.getScene().getWindow();
   root = FXMLLoader.load(getClass().getResource("/View_Controller/Main.fxml"));
   //Create a new scene with roo and set the stage
   Scene scene = new Scene(root);
   stage.setScene(scene);
   stage.show();
  }
 
  @FXML
 private void saveButtonAction(ActionEvent event) throws IOException {
   
   Part part = 
        new Inhouse(
            Integer.parseInt(machineidText.getText()), 
            0,  // will be changed when added to the inventory
            nameText.getText(), 
            Double.parseDouble(pricecostText.getText()), 
            Integer.parseInt(invText.getText()),
            Integer.parseInt(minText.getText()),
            Integer.parseInt(maxText.getText())
   );
          
   partAdder.addPart(part);
   
   Stage stage;
   Parent root;
   stage = (Stage) saveButton.getScene().getWindow();
   root = FXMLLoader.load(getClass().getResource("/View_Controller/Main.fxml"));
   //Create a new scene with roo and set the stage
   Scene scene = new Scene(root);
   stage.setScene(scene);
   stage.show();
   
  }
  /**
   * Initializes the controller class.
   */

 @Override
 public void initialize(URL url, ResourceBundle rb) {
 }

}