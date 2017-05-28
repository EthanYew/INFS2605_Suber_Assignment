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
 * @author Ajay Matta
 */
public class RegoFormDriverFinalController implements Initializable {

    @FXML
    public Button returnToLogin;
    @FXML
    public Button addCarDetails;
    @FXML
    public TextField name;
    @FXML
    public TextField emailAddress;
    @FXML
    public TextField bsb;
    @FXML
    public TextField password;
    @FXML
    public TextField mobilePhoneNumber;
    @FXML
    public TextField accountNumber;
    @FXML
    public static String userIdentifier;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    public void handleButtonAction(ActionEvent event) {
    }
    
    public static String getUserIdentifier(){
        return userIdentifier;
    }
    
    public void goToLogin() throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) returnToLogin.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("loginScreenFinal.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
}
    
    public void addCarDetails() throws IOException, SQLException{
        createAccountDriver(name.getText(), emailAddress.getText(), password.getText(), mobilePhoneNumber.getText(), bsb.getText(), accountNumber.getText());
        Stage stage;
        Parent root;
        stage = (Stage) addCarDetails.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("CarDetailsFormDriverFinal.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public void createAccountDriver(String name, String emailAddress, String password, String mobilePhoneNumber, String bsb, String accountNumber) throws SQLException{
        try{
        Database.openConnection();
        PreparedStatement stmt = Database.database.prepareStatement("INSERT INTO driver (name, emailAddress, password, mobilePhoneNumber, bsb, accountNo) VALUES (?, ?, ?, ?, ?, ?)");
        stmt.setString(1, name);
        stmt.setString(2, emailAddress);
        stmt.setString(3, password);
        stmt.setString(4, mobilePhoneNumber);
        stmt.setString(5, bsb);
        stmt.setString(6, accountNumber);
        stmt.executeUpdate();
        Database.closeConnection();
        userIdentifier = emailAddress;
    }
        catch(SQLException ex) {
            Logger.getLogger(RegoFormRiderFinalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
