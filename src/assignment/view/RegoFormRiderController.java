/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.view;

import assignment.Assignment;
import assignment.database.Database;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author EthanYew
 */
public class RegoFormRiderController extends Application {

    @FXML
    Button btn_cancel;
    TextField corporateId;
    TextField email;
    TextField name;
    TextField companyName;
    TextField country;
    TextField password;
    TextField city;
    TextField contactNumber;
    Button addBankDetails;
    @FXML
    private Button label;

    /**
     * Initializes the controller class.
     */
    @FXML
    private void handleButtonAction(ActionEvent event) throws SQLException {

        System.out.println(name.getText());
        System.out.println("BEGIN HANDLE BUTTON");
        insertIntoDriver(name.getText(), email.getText());
    }

    @FXML
    private void goToLoginPage(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) btn_cancel.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Login_Screen.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void insertIntoDriver(String name, String email) {
        try {
            //        System.out.println("BEGIN");
//        System.out.println("NAME" + name.getText());
//email.setOnAction(e -> email.setText(email.getText()));
//name.setOnAction(e -> name.setText(name.getText()));
            System.out.println("BEGIN: " + name);
            int i = 1;
//        String driverName = RegoFormRiderController.name.getText();
//        String wam = RegoFormRiderController.email.getText();
            Database.openConnection();
            PreparedStatement stmt = Database.database.prepareStatement("INSERT INTO AJAY VALUES(?, ?)");
//        stmt.setInt(1, 1);

            System.out.println(name + email + "ashdjk");

            stmt.setString(1, name);

            System.out.println(stmt);
            stmt.setDouble(2, Double.parseDouble(email));

//        stmt.setString(4, RegoFormRiderController.password.toString());
//        stmt.setString(5, RegoFormRiderController.companyName.toString());
//        stmt.setString(6, RegoFormRiderController.contactNumber.toString());
            stmt.executeUpdate();
            System.out.println("Record is inserted into ajay table!");

            Database.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(RegoFormRiderController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void editDriver(String oldName, String newName){
        try {
            Database.openConnection();
            PreparedStatement stmt = Database.database.prepareStatement("UPDATE AJAY SET name= ? WHERE name = ?");
            
            stmt.setString(1, newName); //set name
            stmt.setString(2, oldName); //where name = blah
            System.out.println(stmt.executeUpdate()); //returns no. of rows updated
            
            Database.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(RegoFormRiderController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    

    @Override
    public void start(Stage primaryStage) throws Exception {
        name = new TextField();
        email = new TextField();
        primaryStage.setTitle("RegoFormRider"); // Set the stage title
        Pane myPane = (Pane) FXMLLoader.load(getClass().getResource("RegoFormRider.FXML"));
        Scene scene = new Scene(myPane);
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage   
    }

    public static void main(String[] args) {
        launch(args);
    }
}
