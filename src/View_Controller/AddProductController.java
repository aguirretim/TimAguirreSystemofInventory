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
import Model.Product;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Tim
 */
public class AddProductController implements Initializable {

    /**
     * *********************************
     * Variables for Buttons and Field.
 ***********************************
     */
    ObservableList< Part> associatedPartList= FXCollections.observableArrayList();
    
    @FXML
    private Button cancelButton;
    @FXML
    private Button saveButton;
    @FXML
    private Button addButton;
    @FXML
    private Button searchButton;  
    @FXML
    private TextField partsSearchtext;    
    @FXML
    private TextField idText;
    @FXML
    private TextField nameText;
    @FXML
    private TextField inventoryText;
    @FXML
    private TextField priceCostText;
    @FXML
    private TextField maxText;
    @FXML
    private TextField minText;
    @FXML
    private TableView< Part> partTable;
    @FXML
    private TableView < Part > associatedPartTable;
    @FXML
    private TableView< Product> productTable;
    @FXML
    private TableColumn< Part, Integer> partIdCol;
    @FXML
    private TableColumn< Part, String> partNameCol;
    @FXML
    private TableColumn< Part, Integer> partInventoryCol;
    @FXML
    private TableColumn< Part, Double> partPriceCol;
    @FXML
    private TableColumn< Part, Integer> partIdCol2;
    @FXML
    private TableColumn< Part, String> partNameCol2;
    @FXML
    private TableColumn< Part, Integer> partInventoryCol2;
    @FXML
    private TableColumn< Part, Double> partPriceCol2;
    @FXML
    private String productName;
    @FXML
    private double productPrice;
    @FXML
    private int inventoryCount;
    @FXML
    private int minCount;
    @FXML
    private int maxCount;
    @FXML
    private int partCount;
    
    int productID=0;
    
    Inventory initInventory = new Inventory();
     //Inventory initInventory2 = new Inventory();
  //  ArrayList <Part> associatedParts = new ArrayList<>();
    
     
    /************************************ 
     Changing screens and scenes with buttons.
     *************************************/
    public boolean validateProductPriceVsParts(Product newProduct) {
    double totalPartPrice = 0;
    productPrice= Double.parseDouble(priceCostText.getText());
    for (int i = 0; i < associatedPartList.size(); i++){
         totalPartPrice = totalPartPrice + newProduct.getAssociatedParts().get(i).getPrice();
    priceCostText.setText(""+totalPartPrice);
    }
     
     if (productPrice<totalPartPrice) {
   Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Information Dialog");
    alert.setHeaderText("Sorry");
    alert.setContentText("Product Price Must be greater than "+ totalPartPrice +" Associated Parts Total Price.");
    System.out.println("Product Price Must be greater than "+totalPartPrice+ " Associated Parts Total Price.");
    alert.showAndWait();
    return false;
   
     }
   else {
   return true;
  }
    }
     
  
    public boolean validateProductName() {
    productName=nameText.getText();
    if (productName.equals(null)|| productName.isEmpty()) {
   Alert alert = new Alert(Alert.AlertType.INFORMATION);
   alert.setTitle("Information Dialog");
   alert.setHeaderText("Error");
   alert.setContentText("Please enter a product name");
   alert.showAndWait();
   System.out.println("Please enter a product name");
   return false;
  } else {
   return true;
  }
    }
        public boolean validatePrice() {
    productPrice= Double.parseDouble(priceCostText.getText());
    if (productPrice<0) {
   Alert alert = new Alert(Alert.AlertType.INFORMATION);
   alert.setTitle("Information Dialog");
   alert.setHeaderText("Error");
   alert.setContentText("Please enter a product price 0 or greater");
   alert.showAndWait();
   System.out.println("Please enter a product price 0 or greater");
   return false;
  } else {
   return true;
  }
    }
    
     public boolean validateMinMax() {
  minCount = Integer.parseInt(minText.getText());
  maxCount = Integer.parseInt(maxText.getText());
  
         
         
  if (minCount > maxCount ||minCount+maxCount==0 ) {
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
     inventoryCount = Integer.parseInt(inventoryText.getText());
     
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
    private void searchButtonAction(ActionEvent event) throws IOException {
        try {
        int partId=Integer.parseInt(partsSearchtext.getText());
            Part partfound = initInventory.lookupPart(partId);
                partTable.requestFocus();
                partTable.getSelectionModel().select(partfound);

                    System.out.println(partfound);
                if (partfound == null){               
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText("Sorry");
                alert.setContentText("No Results matched your search.");
                alert.showAndWait();
                                    
                } 
                
                }
                catch (NumberFormatException e) {
            String name=partsSearchtext.getText();     
              Part partfound = initInventory.lookupPartName(name);
                partTable.requestFocus();
                partTable.getSelectionModel().select(partfound);
                System.out.println(partfound);
                
                if (partfound == null){               
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText("Sorry");
                alert.setContentText("No Results matched your search.");
                alert.showAndWait();
                                  
                } 
                
                }               
    } 
    
    
    @FXML
    private void cancelButtonAction(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

        alert.setHeaderText("Cancel creating this Product?");
        alert.setContentText("Are you sure you want to cancel?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            // ... user chose OK
            cancelButton.getScene().getWindow().hide();
        }
    }

    @FXML
    private void saveButtonAction(ActionEvent event) throws IOException {
    productPrice= Double.parseDouble(priceCostText.getText());
        
    
    Product newProduct = new Product( 
     productID,
     nameText.getText(),
     Double.parseDouble(priceCostText.getText()),
     Integer.parseInt(inventoryText.getText()),
     Integer.parseInt(minText.getText()),
     Integer.parseInt(maxText.getText()));
    
    
        
    
     newProduct.addAssociatedPart(associatedPartList); 
     
     
     if(newProduct.getAssociatedParts().size()==0){
     Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText("Sorry");
                alert.setContentText("Please select a part to associate with product in table.");
                alert.showAndWait();
     }else if (validateMinMax() && validateInventory() && validateProductName() && validatePrice()&& validateProductPriceVsParts(newProduct)) {
         
     initInventory.addProduct(newProduct);
    
    
    saveButton.getScene().getWindow().hide();}
     System.out.println(newProduct.getAssociatedParts());
   } 
    
         
    @FXML
    private void addButtonAction(ActionEvent event) throws IOException {
        
        Part partSel=partTable.getSelectionModel().getSelectedItem();
        
        
        if(partSel==null){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText("Sorry");
                alert.setContentText("Please select a part to associate with product in table.");
                alert.showAndWait();
        }
        else{
        associatedPartList.add(partSel);    
   double totalPartPrice = 0;
     associatedPartTable.setItems(associatedPartList);
         for (int i = 0; i < associatedPartList.size(); i++){
         totalPartPrice = totalPartPrice+ partSel.getPrice();
    priceCostText.setText(""+totalPartPrice);
    }
        }
   } 
    @FXML
    private void deleteButtonAction(ActionEvent event) throws IOException {
        
        Part partSel=partTable.getSelectionModel().getSelectedItem();
        
        
        if(partSel==null){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText("Sorry");
                alert.setContentText("Please select a part to remove from the product in table.");
                alert.showAndWait();
        }
        else{
        associatedPartList.remove(partSel);    
   
     associatedPartTable.setItems(associatedPartList);
     
        }
   }    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {    

        
         for(int i=0;i< initInventory.getProducts().size();i++){
     if(initInventory.getProducts().get(i).getProductID()> productID)
     
     productID=initInventory.getProducts().get(i).getProductID();
     }
      productID+=1;
    
        partTable.setItems(initInventory.getParts());
        partIdCol.setCellValueFactory(new PropertyValueFactory<>("PartID"));
        partNameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
        partInventoryCol.setCellValueFactory(new PropertyValueFactory<>("InStock"));
        partPriceCol.setCellValueFactory(new PropertyValueFactory<>("Price"));
        
        
        partIdCol2.setCellValueFactory(new PropertyValueFactory<>("PartID"));
        partNameCol2.setCellValueFactory(new PropertyValueFactory<>("Name"));
        partInventoryCol2.setCellValueFactory(new PropertyValueFactory<>("InStock"));
        partPriceCol2.setCellValueFactory(new PropertyValueFactory<>("Price"));
    
        
        priceCostText.setText("0");
        inventoryText.setText("0");
        minText.setText("0");
        maxText.setText("1");
    
    
    }

}
