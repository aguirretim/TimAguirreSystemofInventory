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
import java.util.List;
import java.util.Optional;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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

    /**
     * *********************************
     * Variables for Buttons and Field.
  ***********************************
     */
    //List that holds part objects that are displayed in table
    ObservableList< Part> partList;
    //List that holds part objects that are displayed in table for search
    ObservableList< Part> partList2;

    @FXML
    private Label label;
    @FXML
    private TextField partsSearchtext;
    @FXML
    private Button partsAddButton;
    @FXML
    private Button partsDeleteButton;
    @FXML
    private Button cancelButton;
    @FXML
    private Button partsModifyButton;
    @FXML
    private Button productsAddButton;
    @FXML
    private Button productsModifyButton;
    @FXML
    private Button productsDeleteButton;
    // The table that is used to display data for the (partList that holds part objects that are displayed in table)
    @FXML
    private TableView< Part> partTable;
    @FXML
    private TableColumn< Part, Integer> partIdCol;
    @FXML
    private TableColumn< Part, String> partNameCol;
    @FXML
    private TableColumn< Part, Integer> partInventoryCol;
    @FXML
    private TableColumn< Part, Double> partPriceCol;
    //Stage setting variable for Button actions to select new stages to display
    Stage stage = new Stage();
    //The inventory object that contains all of the parts and product listed inside
    Inventory warehouse = new Inventory();

    /**
     * *********************************
     * Changing screens and scenes with buttons.
 ***********************************
     */
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

        FXMLLoader loader = new FXMLLoader(); //Loads an object hierarchy from an XML document.     
        loader.setLocation(getClass().getResource("/View_Controller/ModifyPart.fxml")); //  reference FXML files like this in my controllers                 
        loader.load();

        ModifyPart mpc = loader.getController(); // loads the reference FXML controller

        Parent modifyPartWindow = loader.getRoot();

        Part partSel = partTable.getSelectionModel().getSelectedItem();

        if (partSel instanceof Inhouse) {

            int machineId = ((Inhouse) partSel).getMachineID();
            String companyName = null;
            mpc.transferData(companyName, machineId, partSel.getPartID(), partSel.getName(), partSel.getPrice(), partSel.getInStock(), partSel.getMin(), partSel.getMax());

        }
        if (partSel instanceof Outsourced) {

            int machineId = 0;
            String companyName = ((Outsourced) partSel).getCompanyName();
            mpc.transferData(companyName, machineId, partSel.getPartID(), partSel.getName(), partSel.getPrice(), partSel.getInStock(), partSel.getMin(), partSel.getMax());

        }
        Scene scene = new Scene(modifyPartWindow);
        stage.setScene(scene);
        stage.showAndWait();
        refreshTable();

    }

    @FXML
    private void productAddButtonAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View_Controller/AddProduct.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.showAndWait();
        refreshTable();

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

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

        alert.setHeaderText("Leave this Application?");
        alert.setContentText("Are you sure you want to leave?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            // ... user chose OK
            System.exit(0);
        }
    }

//    @FXML
//    private void searchButtonAction(ActionEvent event) throws IOException {
//        
////        // create a list of parts containing only the parts we are interested in
////        List<Part> filteredParts = new ArrayList<>();
////      
////        // if the filter string is a number do an id search
////        
////        try {
////            int num = Integer.parseInt(partsSearchtext.getText());
////            // id search
////            //filteredParts.add(...);
////            System.out.println("its a number");
////        } catch (NumberFormatException e) {
////            // not a number so try a name search
////            //filteredParts.add(...);
////            System.out.println("its not a number");
////        }
//        
//        partList = FXCollections.observableArrayList(filteredParts);
//        partTable.setItems(this.partList);
//        partTable.refresh();
//        System.out.println("Refreash table called");
//    }

    @FXML
    private void searchButtonAction(ActionEvent event) throws IOException {
        //System.out.println(partList.size());
        
        // create a list of parts containing only the parts we are interested in
        try {
            int itemnumber = Integer.parseInt(partsSearchtext.getText());
            boolean found = false;
            for (int i = 0; i < partList.size(); i++) {
                //System.out.println(partList.get(i).getName());
                if (partList.get(i).getPartID() == itemnumber) {
                    System.out.println("This is part " + itemnumber);

                    found = true;
                    partList2 = FXCollections.observableArrayList(partList.get(i));
                    partTable.setItems(this.partList2);
                    partIdCol.setCellValueFactory(new PropertyValueFactory<>("PartID"));
                    partNameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
                    partInventoryCol.setCellValueFactory(new PropertyValueFactory<>("InStock"));
                    partPriceCol.setCellValueFactory(new PropertyValueFactory<>("Price"));
                }

            }

            if (found == false) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText("Sorry");
                alert.setContentText("No Results matched your search.");
                alert.showAndWait();
                refreshTable();
            }
        } catch (NumberFormatException e) {
            refreshTable();
        }

    }

    @FXML
    private void partDelButtonAction(ActionEvent event) throws IOException {

        Part partSel = partTable.getSelectionModel().getSelectedItem();
        System.out.print(partSel.getPartID());
        warehouse.deletePart(partSel.getPartID());
        
        System.out.print(partList);
        System.out.print(warehouse);

        refreshTable();

    }

    public void refreshTable() {
        partList = FXCollections.observableArrayList(warehouse.getParts());
        partTable.setItems(this.partList);
        partTable.refresh();
        System.out.println("Refreash table called");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        stage.initModality(Modality.APPLICATION_MODAL);

        /**
         * *********************************
         * Loads the Parts object from the Parts list and displays the fields in
         * columns listed.
  ************************************
         */
        
        warehouse.addPart(new Inhouse(123, 0, "part1", 4.4, 5,1, 10));
        warehouse.addPart(new Inhouse(123, 1, "part2", 4.4, 5,1, 10));
        warehouse.addPart(new Inhouse(123, 2, "part3", 4.4, 5,1, 10));
        warehouse.addPart(new Inhouse(123, 3, "part4", 4.4, 5,1, 10));
        
        partTable.setItems(this.partList);
        partIdCol.setCellValueFactory(new PropertyValueFactory<>("PartID"));
        partNameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
        partInventoryCol.setCellValueFactory(new PropertyValueFactory<>("InStock"));
        partPriceCol.setCellValueFactory(new PropertyValueFactory<>("Price"));

        refreshTable();
        
    }
}
