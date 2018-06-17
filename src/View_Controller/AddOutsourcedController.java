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
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Tim
 */
public class AddOutsourcedController implements Initializable {
    @FXML
    private Button cancelButton;
            
    @FXML
    private RadioButton outsourcedRadioButton;
    
    @FXML
    private RadioButton inHouseButton;
    
        
        @FXML
    private void inHouseButtonAction(ActionEvent event) throws IOException {
          Stage stage;
          Parent root;
          stage=(Stage) inHouseButton.getScene().getWindow();
          root = FXMLLoader.load(getClass().getResource("/View_Controller/AddInhouse.fxml"));
        //Create a new scene with roo and set the stage
           Scene scene = new Scene(root);
           stage.setScene(scene);
           stage.show();}

    
        @FXML
    private void outsourcedButtonAction(ActionEvent event) throws IOException {
          Stage stage;
          Parent root;
          stage=(Stage) outsourcedRadioButton.getScene().getWindow();
          root = FXMLLoader.load(getClass().getResource("/View_Controller/AddOutsourced.fxml"));
        //Create a new scene with roo and set the stage
           Scene scene = new Scene(root);
           stage.setScene(scene);
           stage.show();}
    
    @FXML
    private void cancelButtonAction(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        stage=(Stage) cancelButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/View_Controller/Main.fxml"));
        //Create a new scene with roo and set the stage
           Scene scene = new Scene(root);
           stage.setScene(scene);
           stage.show();}
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
