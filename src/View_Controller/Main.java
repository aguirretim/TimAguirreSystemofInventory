/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View_Controller;

import Model.Inventory;
import Model.Part;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import Model.Product;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private Button partsModifyButton;
    @FXML
    private Button productsAddButton;
    @FXML
    private Button productsModifyButton;

    @FXML
    private TableView<Part> partTable;
    @FXML
    private TableColumn<Part,Integer> partIdCol;
    @FXML
    private TableColumn<Part,String> partNameCol;
    @FXML
    private TableColumn<Part,Integer> partInventoryCol;
    @FXML
    private TableColumn<Part,Double> partPriceCol;
    
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
          stage=(Stage) partsModifyButton.getScene().getWindow();
          root = FXMLLoader.load(getClass().getResource("/View_Controller/ModifyInhouse.fxml"));
        //Create a new scene with roo and set the stage
           Scene scene = new Scene(root);
           stage.setScene(scene);
           stage.show();}
    
    @FXML
    private void productAddButtonAction(ActionEvent event) throws IOException {
          Stage stage;
          Parent root;
          stage=(Stage) productsAddButton.getScene().getWindow();
          root =  FXMLLoader.load(getClass().getResource("/View_Controller/AddProduct.fxml"));
        //Create a new scene with roo and set the stage
           Scene scene = new Scene(root);
           stage.setScene(scene);
           stage.show();}
            
    @FXML
    private void productModifyButtonAction(ActionEvent event) throws IOException {
          Stage stage;
          Parent root;
          stage=(Stage) productsModifyButton.getScene().getWindow();
          root = FXMLLoader.load(getClass().getResource("/View_Controller/ModifyProduct.fxml"));
        //Create a new scene with roo and set the stage
           Scene scene = new Scene(root);
           stage.setScene(scene);
           stage.show();}

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
       Inventory starter = new Inventory();
       
       ArrayList<Part> startingParts = new ArrayList<>();
       
       startingParts.add(starter.lookupPart(0));
       startingParts.add(starter.lookupPart(1));
       startingParts.add(starter.lookupPart(2));
       startingParts.add(starter.lookupPart(3));
       
       ObservableList<Part> starterPartsOl = FXCollections.observableArrayList(startingParts);
       
       partTable.setItems(starterPartsOl);
       partIdCol.setCellValueFactory(new PropertyValueFactory<>("PartID"));
       partNameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
       partInventoryCol.setCellValueFactory(new PropertyValueFactory<>("InStock"));
       partPriceCol.setCellValueFactory(new PropertyValueFactory<>("Price"));
       
    }    
}

