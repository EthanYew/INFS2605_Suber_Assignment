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
public class BankDetailFormRiderFinalController implements Initializable {

    @FXML
    private Button returnToLogin;
    @FXML
    private TextField expiryDate;
    @FXML
    private TextField cardNumber;
    @FXML
    private TextField cvv;
    @FXML
    private TextField nameOnCard;
    @FXML
    private Button confirm; //CONFIRM BUTTON HAS NOT BEEN LINKED YET

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException, SQLException {
        createAccountRiderBank(nameOnCard.getText(), cardNumber.getText(), cvv.getText(), expiryDate.getText());
        Stage stage;
        Parent root;

        stage = (Stage) returnToLogin.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("loginScreenFinal.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show(); 
    }
    
    public void goToLoginPage() throws IOException {
     Stage stage;
        Parent root;

        stage = (Stage) returnToLogin.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("loginScreenFinal.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public void createAccountRiderBank(String nameOnCard, String cardNumber, String CVV, String expiryDate) throws SQLException{
        try{
        Database.openConnection();
        PreparedStatement stmt = Database.database.prepareStatement("UPDATE RIDER "
                + "SET nameOnCard = ?, cardNumber = ?, CVV = ?, expiryDate = ? WHERE emailaddress = ?");
        stmt.setString(1, nameOnCard);
        stmt.setString(2, cardNumber);
        stmt.setString(3, CVV);
        stmt.setString(4, expiryDate);
        stmt.setString(5, RegoFormRiderFinalController.getUserIdentifier());
        stmt.executeUpdate();
        Database.closeConnection();
    }
        catch(SQLException ex) {
            Logger.getLogger(RegoFormRiderFinalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
