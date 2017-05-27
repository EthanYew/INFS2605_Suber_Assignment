/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.view;

import assignment.database.Database;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Ajay Matta
 */
public class RegoFormRiderFinalController implements Initializable {

    @FXML
    public Button returnToLogin;
    @FXML
    public Button addBankingDetails;
    @FXML
    public TextField name;
    @FXML
    public TextField emailAddress;
    @FXML
    public TextField password;
    @FXML
    public TextField mobilePhoneNumber;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void handleButtonAction(ActionEvent event) {
    createRiderAccount();
    }
    @FXML
    public void createRiderAccount() {
        try {
            //        System.out.println("BEGIN");
//        System.out.println("NAME" + name.getText());
//email.setOnAction(e -> email.setText(email.getText()));
//name.setOnAction(e -> name.setText(name.getText()));
//        String driverName = RegoFormRiderController.name.getText();
//        String wam = RegoFormRiderController.email.getText();
            Database.openConnection();
            PreparedStatement stmt = Database.database.prepareStatement("INSERT INTO sampleTable VALUES(?, ?)");
            stmt.setString(1, "Toyota");
            stmt.setString(2, "Camry");
            //stmt.setString(3, "tim@gmail.com");
            //stmt.setString(4, "test");
            //stmt.setString(5, "0470533103");
            stmt.executeUpdate();
            Database.closeConnection();
//        stmt.setString(4, RegoFormRiderController.password.toString());
//        stmt.setString(5, RegoFormRiderController.companyName.toString());
//        stmt.setString(6, RegoFormRiderController.contactNumber.toString());
        } catch (SQLException ex) {
            Logger.getLogger(RegoFormRiderFinalController.class.getName()).log(Level.SEVERE, null, ex);
    }
}
}



/*public void editDriver(String oldName, String newName){
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
    }*/