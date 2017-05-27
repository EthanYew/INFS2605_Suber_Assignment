/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.view;

import assignment.database.Database;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author EthanYew
 */
public class RegoFormDriverController implements Initializable {

    private TextField tfFirstName;
    @FXML
    private TextField email;
    @FXML
    private Button btnAddBankDetails;
    private TextField tfLastName;
    @FXML
    private TextField tfMobileNo;
    @FXML
    private TextField tfCountry;
    @FXML
    private TextField tfDOB;
    @FXML
    private TextField tfCity;
    @FXML
    private TextField tfDriverLicence;
    @FXML
    private Button btnCancel;
    @FXML
    private TextField name;
    @FXML
    private TextField password;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleButtonAction(ActionEvent event) {
        insertIntoDriver(name.getText(), password.getText(), email.getText());
    }

    @FXML
    private void goToLoginPage(ActionEvent event) {
        try {
            Stage stage;
            Parent root;
            
            stage=(Stage) btnCancel.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Login_Screen.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(RegoFormDriverController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    private void insertIntoDriver(String name, String email, String password){
        try {
            System.out.println("BEGIN INSERTINTODRIVER");
            Database.openConnection();
            PreparedStatement stmt = Database.database.prepareStatement("INSERT INTO DRIVER (NAME, EMAILADDRESS, PASSWORD) VALUES(?, ?, ?)");
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, password);

//        stmt.setString(4, RegoFormRiderController.password.toString());
//        stmt.setString(5, RegoFormRiderController.companyName.toString());
//        stmt.setString(6, RegoFormRiderController.contactNumber.toString());
            stmt.executeUpdate();
            System.out.println("Record is inserted into DRIVER table!");

            Database.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(RegoFormRiderController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
