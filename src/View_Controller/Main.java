/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View_Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import Model.Product;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;




/**
 *
 * @author Tim
 */
public class Main implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Button partsAddButton;
    @FXML
    private Button cancelButton;
    
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        
        if(event.getSource()==partsAddButton){
        //Get refrence to the buttons stage
        stage=(Stage) partsAddButton.getScene().getWindow();
        // Load up other FXML document
         root = FXMLLoader.load(getClass().getResource("/View_Controller/AddInhouse.fxml"));
               
        }
        
        else
            stage=(Stage) cancelButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/View_Controller/Main.fxml"));
        //Create a new scene with roo and set the stage
           Scene scene = new Scene(root);
           stage.setScene(scene);
           stage.show();
           
     System.out.println(event.getSource());
        
        ArrayList<Integer> LegsSeatBack= new ArrayList<Integer>();
                            
Product Chair = new Product(LegsSeatBack,01, "Chair",10.10,5,1,10);
        
        
        
        label.setText("event.getSource()");
        
        
    }
     
    @FXML
    private void partsAddButtonAction(ActionEvent event) throws IOException {
          Stage stage;
          Parent root;
          stage=(Stage) partsAddButton.getScene().getWindow();
          root = FXMLLoader.load(getClass().getResource("/View_Controller/AddInhouse.fxml"));
        //Create a new scene with roo and set the stage
           Scene scene = new Scene(root);
           stage.setScene(scene);
           stage.show();}
     
     
            
    @FXML
    private void partsModifyButtonAction(ActionEvent event) throws IOException {
          Stage stage;
          Parent root;
          stage=(Stage) partsAddButton.getScene().getWindow();
          root = FXMLLoader.load(getClass().getResource("/View_Controller/ModifyInhouse.fxml"));
        //Create a new scene with roo and set the stage
           Scene scene = new Scene(root);
           stage.setScene(scene);
           stage.show();}
    
    @FXML
    private void productAddButtonAction(ActionEvent event) throws IOException {
          Stage stage;
          Parent root;
          stage=(Stage) partsAddButton.getScene().getWindow();
          root = FXMLLoader.load(getClass().getResource("/View_Controller/Add Product.fxml"));
        //Create a new scene with roo and set the stage
           Scene scene = new Scene(root);
           stage.setScene(scene);
           stage.show();}
            
    @FXML
    private void productModifyButtonAction(ActionEvent event) throws IOException {
          Stage stage;
          Parent root;
          stage=(Stage) partsAddButton.getScene().getWindow();
          root = FXMLLoader.load(getClass().getResource("/View_Controller/ModifyProduct.fxml"));
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
    }    
    
}
