/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Final;

import assignment.database.Database;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Ajay Matta
 */
public class DriverLandingPageFinalController implements Initializable {

    @FXML
    public Text name1;
    @FXML
    public Button favourites;
    @FXML
    public Button tripHistory;
    @FXML
    public Button myProfile;
    @FXML
    public Button faq;
    @FXML
    public Button contactUs;
    @FXML
    public Button signOut;
    @FXML
    public Text userType;
    @FXML
    public TableView tableview;

    ObservableList<ObservableList> data;
    
    String column;
//    String newValue;
    String id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableview.setEditable(true);

        try {
            //initialize data in tableview
            buildData();

            //set text name1 to display name of user for given loggedInEmail
            Database.openConnection();
            Statement stmt = Database.database.createStatement();
            // String userEmail = Final.login_ScreenFinalController.getLoggedInEmail();
            ResultSet result = stmt.executeQuery("SELECT DRIVERID FROM driver where password = 'victorzhang';");
            if (result.next()) {
                System.out.println(result.getString(1));
                name1.setText(result.getString(1));
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DriverLandingPageFinalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //MENU
    @FXML
    public void goToFavourites(ActionEvent even) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) favourites.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("FavouriteTripsFinal.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void goToTripHistory(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) tripHistory.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("TripHistoryFinal.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void goToMyProfile(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) myProfile.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("MyProfileDriverFinal.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void goToFaqs(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) faq.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("FAQDriverFinal.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void goToContactUs(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) contactUs.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("ContactUsFinal.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void goToLoginPage(ActionEvent even) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) signOut.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("loginScreenFinal.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public class SubRecord {

        private SimpleStringProperty fieldSubRecordName;
        private SimpleIntegerProperty fieldSubRecordValue;

        SubRecord(String sn, int sv) {
            this.fieldSubRecordName = new SimpleStringProperty(sn);
            this.fieldSubRecordValue = new SimpleIntegerProperty(sv);
        }

        public String getFieldSubRecordName() {
            return fieldSubRecordName.get();
        }

        public int getFieldSubRecordValue() {
            return fieldSubRecordValue.get();
        }

    }

    //Define the button cell
    private class ButtonCell extends TableCell<ObservableList, Boolean> {

        final Button cellButton = new Button("Action");

        ButtonCell() {

            cellButton.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent t) {
                    int selectdIndex = getTableRow().getIndex();

                    //Create a new table show details of the selected item
                    ObservableList selectedRecord = (ObservableList) tableview.getItems().get(selectdIndex);

                    selectedRecord.set(1, name1.getText());
                    System.out.println(selectedRecord.get(4));

                    //update value in db
                    
                    id = String.valueOf(selectdIndex);
                    updateData(column, name1.getText(), id);
//                    ObservableList<SubRecord> subDataList =
//                            FXCollections.observableArrayList(
//                                    
//                                new SubRecord("ID", selectedRecord.getId()),
//                                new SubRecord("Monday", selectedRecord.getValue_0()),
//                                new SubRecord("Tuesday", selectedRecord.getValue_1()),
//                                new SubRecord("Wednesday", selectedRecord.getValue_2()),
//                                new SubRecord("Thursday", selectedRecord.getValue_3()),
//                                new SubRecord("Friday", selectedRecord.getValue_4()));
//                     
//                    TableColumn columnfield = new TableColumn("Field");
//                    columnfield.setCellValueFactory(
//                            new PropertyValueFactory<Record,String>("fieldSubRecordName"));
//                     
//                    TableColumn columnValue = new TableColumn("Value");
//                    columnValue.setCellValueFactory(
//                            new PropertyValueFactory<SubRecord,Integer>("fieldSubRecordValue"));
//      
//                    TableView<SubRecord> subTableView = new TableView<>();
//                    subTableView.setItems(subDataList);
//                    subTableView.getColumns().addAll(columnfield, columnValue);
//         
//                    Stage myDialog = new Stage();
//                    myDialog.initModality(Modality.WINDOW_MODAL);
//                     
//                    Scene myDialogScene = new Scene(VBoxBuilder.create()
//                            .children(subTableView)
//                            .alignment(Pos.CENTER)
//                            .padding(new Insets(10))
//                            .build());
//                     
//                    myDialog.setScene(myDialogScene);
//                    myDialog.show();
                }
            });
        }

        //Display button if the row is not empty
        @Override
        protected void updateItem(Boolean t, boolean empty) {
            super.updateItem(t, empty);
            if (!empty) {
                setGraphic(cellButton);
            }
        }
    }
    
    //update data in database on buttoncell click
    public void updateData(String column, String newValue, String id) {
        System.out.println("reached updateData");
        System.out.println("column = " + column);
        System.out.println("newValue = " + newValue);
        System.out.println("id = " + id);
    // btw it is way better to keep the connection open while the app is running,
    // and just close it when the app shuts down....

    // the following "try with resources" at least makes sure things are closed:

    try (
        
        PreparedStatement stmt = Database.database.prepareStatement("UPDATE TRIP SET "+column+" = ? WHERE TRIPID = ? ");
    ) {

        stmt.setString(1, newValue);
        stmt.setString(2, id);
        stmt.executeUpdate();
        System.out.println("executed update");
    }   catch (SQLException ex) {
            Logger.getLogger(DriverLandingPageFinalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        // if anything goes wrong, you will need the stack trace:
        }

    //CONNECTION DATABASE
    public void buildData() {

        data = FXCollections.observableArrayList();
        try {
            Database.openConnection();
            Statement stmt = Database.database.createStatement();
            //SQL FOR SELECTING ALL OF CUSTOMER
            String SQL = "SELECT * FROM TRIP;";
            //ResultSet
            ResultSet rs = stmt.executeQuery(SQL);

            /**
             * ********************************
             * TABLE COLUMN ADDED DYNAMICALLY * ********************************
             */
            for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                //We are using non property style for making dynamic table
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
                col.setEditable(true);
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                    @Override
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }

                });

                if (j == 1) {
                    
                    EventHandler<TableColumn.CellEditEvent<ObservableList, String>> event;
                    event = new EventHandler<TableColumn.CellEditEvent<ObservableList, String>>() {
                        @Override
                        public void handle(TableColumn.CellEditEvent<ObservableList, String> event) {
                            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        }
                    };
//                    col.setOnEditCommit(event = new EventHandler<TableColumn.CellEditEvent<ObservableList, String>>() {
//                        @Override
//                        public void handle(TableColumn.CellEditEvent<ObservableList, String> event) {
//                            updateData(rs.getMetaData().getColumnName(j + 1), event.getNewValue(), event.getRowValue().);
//                        }
//                    });
                    
                    column = rs.getMetaData().getColumnName(j + 1);
//                    newValue = event.getNewValue();
                    
                    
                };

                tableview.getColumns().addAll(col);
                System.out.println("Column [" + i + "] ");
            }

            //Insert Button
            TableColumn col_action = new TableColumn<>("Action");
            col_action.setSortable(false);

            col_action.setCellValueFactory(
                    new Callback<TableColumn.CellDataFeatures<ObservableList, Boolean>, ObservableValue<Boolean>>() {

                @Override
                public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<ObservableList, Boolean> p) {
                    return new SimpleBooleanProperty(p.getValue() != null);
                }
            });

            col_action.setCellFactory(
                    new Callback<TableColumn<ObservableList, Boolean>, TableCell<ObservableList, Boolean>>() {

                @Override
                public TableCell<ObservableList, Boolean> call(TableColumn<ObservableList, Boolean> p) {
                    return new ButtonCell();
                }

            });
            tableview.getColumns().add(col_action);

            /**
             * ******************************
             * Data added to ObservableList * ******************************
             */
            while (rs.next()) {
                //Iterate Row
//                ObservableList<String> row = FXCollections.observableArrayList();
                ObservableList row = FXCollections.observableArrayList();

//                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
//                    //Iterate Column
//                    row.add(rs.getString(i));
//                }
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    //Iterate Column
                    String str = null;
                    if (rs.getString(i) == null) {
                        str = "";
                    } else {
                        str = rs.getString(i);
                    }
                    row.add(str);
                }
                System.out.println("Row [1] added " + row);
                data.add(row);

            }

            //FINALLY ADDED TO TableView
            tableview.setItems(data);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error on Building Data");
        }

        Database.closeConnection();
    }

}
