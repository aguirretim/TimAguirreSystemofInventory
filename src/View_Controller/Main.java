/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View_Controller;

import Model.Inhouse;
import Model.Inventory;
import Model.Outsourced;
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
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;


/**
 *
 * @author Tim
 */
public class Main implements Initializable {

    ObservableList < Part > partList;
    @FXML
    public ObservableList<Part> dataTable=FXCollections.observableArrayList();

    /***********************************
     Variables for Buttons and Field.
     ************************************/



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
    private TableView < Part > partTable;
    @FXML
    private TableColumn < Part, Integer > partIdCol;
    @FXML
    private TableColumn < Part, String > partNameCol;
    @FXML
    private TableColumn < Part, Integer > partInventoryCol;
    @FXML
    private TableColumn < Part, Double > partPriceCol;
    Stage stage = new Stage();

    ArrayList < Part > startingParts = new ArrayList < > ();
    Inventory starter = new Inventory();
    
    /***********************************
    Changing screens and scenes with buttons.
    ************************************/

    


    @FXML
    private void partsAddButtonAction(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("/View_Controller/AddPart.fxml"));
                      
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.showAndWait();
        refreshTable();
    }

    @FXML
    private void partsModifyButtonAction(ActionEvent event) throws IOException {
        
        FXMLLoader loader= new FXMLLoader();      
        loader.setLocation(getClass().getResource("/View_Controller/ModifyPart.fxml"));                      
        loader.load();
        
        ModifyPart mpc = loader.getController();
        
        Parent modifyPartWindow = loader.getRoot();
        
        Part partSel = partTable.getSelectionModel().getSelectedItem();
        
        if (partSel instanceof Inhouse){
        
        int machineId = ((Inhouse) partSel).getMachineID();
        String companyName = null;
        mpc.transferData(companyName, machineId, partSel.getPartID(),  partSel.getName(),  partSel.getPrice(),  partSel.getInStock(),  partSel.getMin(),  partSel.getMax());
        
       
        }
        if (partSel instanceof Outsourced){
        
        int machineId = 0;
        String companyName = ((Outsourced) partSel).getCompanyName();
        mpc.transferData(companyName, machineId, partSel.getPartID(),  partSel.getName(),  partSel.getPrice(),  partSel.getInStock(),  partSel.getMin(),  partSel.getMax());
        
       
        }
        Scene scene = new Scene(modifyPartWindow);        
        stage.setScene(scene);
        stage.showAndWait();
        refreshTable();
        
        
        
    }

    @FXML
    private void productAddButtonAction(ActionEvent event) throws IOException {
        
        Parent root;
        stage = (Stage) productsAddButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/View_Controller/AddProduct.fxml"));
        //Create a new scene with roo and set the stage
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void productModifyButtonAction(ActionEvent event) throws IOException {
       
        Parent root;
        stage = (Stage) productsModifyButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/View_Controller/ModifyProduct.fxml"));
        //Create a new scene with roo and set the stage
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void exitButtonAction(ActionEvent event) throws IOException {
    System.exit(0);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        stage.initModality(Modality.APPLICATION_MODAL);

        /***********************************
        Creating objects from classes to display in table. 
        ************************************/
        
      //  startingParts.addAll(Inventory.getParts());

        /*startingParts.add(starter.lookupPart(0));
        startingParts.add(starter.lookupPart(1));
        startingParts.add(starter.lookupPart(2));
        startingParts.add(starter.lookupPart(3));*/

        //partList = FXCollections.observableArrayList(startingParts);

        partTable.setItems(this.partList);
        partIdCol.setCellValueFactory(new PropertyValueFactory < > ("PartID"));
        partNameCol.setCellValueFactory(new PropertyValueFactory < > ("Name"));
        partInventoryCol.setCellValueFactory(new PropertyValueFactory < > ("InStock"));
        partPriceCol.setCellValueFactory(new PropertyValueFactory < > ("Price"));
        
    }
   
   public void refreshTable(){
   
   partList = FXCollections.observableArrayList(starter.getParts());
   
   partTable.setItems(this.partList);
   
   }
   public void getTableRow(){
   
   partList = FXCollections.observableArrayList(starter.getParts());
   
   partTable.setItems(this.partList);
   
   }
 
}