/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.view;

import assignment.Assignment;
import assignment.classes.Driver;
import java.net.URL;
import java.util.ResourceBundle;
import static javafx.application.Application.launch;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author EthanYew
 */
public class Home_PageController implements Initializable {

    /**
     * @param args the command line arguments
     */
    private WebView webView;
    @FXML
    private TableColumn<?, ?> nameCol;
    @FXML
    private TableColumn<?, ?> emailCol;
    @FXML
    private TableView<Driver> driverTbl;

    // Set up the invoice table
//    nameCol.setCellValueFactory (
//            
//
//    new PropertyValueFactory<Driver,String>("name")
//);
//    itemNameCol.setCellValueFactory (
//            
//
//    new PropertyValueFactory<InvoiceEntry,String>("itemName")
//);
    
    private void initialize() {
        WebEngine engine = webView.getEngine();
        engine.load("/assignment/placesAutocompleteDirections.html");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
