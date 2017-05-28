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
public class RegoFormCorporateMemberController implements Initializable {

    @FXML
    private Button returnToLogin;
    @FXML
    private Button addBankingDetails;
    @FXML
    private TextField name;
    @FXML
    private TextField emailAddress;
    @FXML
    private TextField password;
    @FXML
    private TextField contactNumber;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException, SQLException{
        createAccountCorporateMember(name.getText(), emailAddress.getText(), password.getText(), contactNumber.getText());
        Stage stage;
        Parent root;

        stage = (Stage) addBankingDetails.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("BankDetailsFormCorporateFinal.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void createAccountCorporateMember(String name, String emailAddress, String password, String contactNumber) throws SQLException{
        try{
        Database.openConnection();
        PreparedStatement stmt = Database.database.prepareStatement("INSERT INTO corporatemember (name, emailAddress, password, contactNumber) VALUES (?, ?, ?, ?)");
        stmt.setString(1, name);
        stmt.setString(2, emailAddress);
        stmt.setString(3, password);
        stmt.setString(4, contactNumber);
        stmt.executeUpdate();
        Database.closeConnection();
    }
        catch(SQLException ex) {
            Logger.getLogger(RegoFormRiderFinalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
