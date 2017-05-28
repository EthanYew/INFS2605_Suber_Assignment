/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Final;

import assignment.database.Database;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import static javafx.application.Application.launch;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author AriSurfacePro
 */
public class StaffCorporateRiderReportFinalController implements Initializable {

    @FXML
    private TableView corporateRiderReport;
    @FXML
    private Button refresh;
    @FXML
    private Button backToDashboard;
    //TABLE VIEW AND DATA
    private ObservableList<ObservableList> data;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
@FXML
    private void backToDashboard(ActionEvent event) throws IOException{
        Stage stage;
        Parent root;

        stage = (Stage) backToDashboard.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("StaffLandingPageFinal.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    /*@FXML
    private void refresh(ActionEvent event) {          
          data = FXCollections.observableArrayList();
          try{
            Database.openConnection();
            Statement stmt = Database.database.createStatement();
            //SQL FOR SELECTING ALL OF CUSTOMER
            String SQL = "SELECT * FROM corporatemember;";
            //ResultSet
            ResultSet rs = stmt.executeQuery(SQL);

            /**********************************
             * TABLE COLUMN ADDED DYNAMICALLY *
             **********************************/
            /*for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
                //We are using non property style for making dynamic table
                final int j = i;                
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {                                                                                              
                        return new SimpleStringProperty(param.getValue().get(j).toString());                        
                    }
                    
                });

                corporateRiderReport.getColumns().addAll(col); 
                System.out.println("Column ["+i+"] ");
            }

            /********************************
             * Data added to ObservableList *
             ********************************/
            /*while(rs.next()){
                //Iterate Row
//                ObservableList<String> row = FXCollections.observableArrayList();
                ObservableList row = FXCollections.observableArrayList();
                
//                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
//                    //Iterate Column
//                    row.add(rs.getString(i));
//                }
                
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    //Iterate Column
                    String str=null;
                    if (rs.getString(i)==null){
                    str = "";
                    } else{
                    str = rs.getString(i);
                    }
                    row.add(str);
                }
                System.out.println("Row [1] added "+row );
                data.add(row);

            }

            //FINALLY ADDED TO TableView
            corporateRiderReport.setItems(data);
          }catch(Exception e){
              e.printStackTrace();
              System.out.println("Error on Building Data");             
          }
          
          Database.closeConnection();
      }*/
    }
