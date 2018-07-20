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

    /**
     * *********************************
     * Variables for Buttons and Field.
 ***********************************
     */
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

    private Inventory initInventory = new Inventory();

    private int partId;
    
    /**
     * *********************************
     * Changing screens and scenes with buttons.
 ***********************************
     */
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
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

        alert.setHeaderText("Cancel modifying this Part?");
        alert.setContentText("Are you sure you want to cancel?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            // ... user chose OK
            cancelButton.getScene().getWindow().hide();
        }
    }

    @FXML
    private void saveButtonAction(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(); //Loads an object hierarchy from an XML document.     
        loader.setLocation(getClass().getResource("/View_Controller/Main.fxml")); //  reference  fxml files like this in my controllers:                 
        loader.load();

        Main mainController = loader.getController();

        //Part partSel = partTable.getSelectionModel().getSelectedItem();
        Parent mainWindow = loader.getRoot();

        if (inHouseButton.isSelected()) {
            initInventory.updatePart(
                    new Inhouse(
                            Integer.parseInt(machineidText.getText()),
                            Integer.parseInt(idText.getText()),
                            nameText.getText(),
                            Double.parseDouble(pricecostText.getText()),
                            Integer.parseInt(invText.getText()),
                            Integer.parseInt(minText.getText()),
                            Integer.parseInt(maxText.getText())
                    )
            );
        } else if (outsourcedRadioButton.isSelected()) {
            initInventory.updatePart(new Outsourced(
                    machineidText.getText(),
                    Integer.parseInt(idText.getText()),
                    nameText.getText(),
                    Double.parseDouble(pricecostText.getText()),
                    Integer.parseInt(invText.getText()),
                    Integer.parseInt(minText.getText()),
                    Integer.parseInt(maxText.getText())));
        } else {
            System.out.println("Something weird happaned with creating a part");

        }
            
        saveButton.getScene().getWindow().hide();

    }

    public void transferData(
            String companyName,
            int MachineID, int partID,
            String name, double price, int inStock,
            int min, int max) {
        
        idText.setText(String.valueOf(partID));
        idText.setEditable(false);
        nameText.setText(name);
        invText.setText(String.valueOf(inStock));
        pricecostText.setText(String.valueOf(price));
        maxText.setText(String.valueOf(max));
        minText.setText(String.valueOf(min));

        if (companyName == null) {
            inHouseButton.setSelected(true);
            machineidText.setText(String.valueOf(MachineID));
        } else {
            outsourcedRadioButton.setSelected(true);
            machineidText.setText(companyName);
            machCompLbl.setText("Company Name");
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
