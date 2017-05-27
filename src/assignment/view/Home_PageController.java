/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.view;

import assignment.Assignment;
import assignment.classes.Driver;
import assignment.database.Database;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author EthanYew
 */
public class Home_PageController implements Initializable {

    /**
     * @param args the command line arguments
     */
    
    @FXML
    private TableView driverTbl;

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
    
    public void processTable(){
        try {
            Database.openConnection();
            Statement stmt = Database.database.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM DRIVER");
            
            for(int i=0 ; i<result.getMetaData().getColumnCount(); i++){
                //We are using non property style for making dynamic table
                final int j = i;
                TableColumn col = new TableColumn(result.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){
                    @Override
                    public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });
                
                driverTbl.getColumns().addAll(col);
                System.out.println("Column ["+i+"] ");
                Database.closeConnection();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Home_PageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
