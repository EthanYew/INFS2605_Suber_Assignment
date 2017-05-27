/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Final;

import assignment.database.Database;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class RegoFormRiderFinalController implements Initializable {

    @FXML
    public Button returnToLogin;
    @FXML
    public Button addBankingDetails;
    @FXML
    public static TextField name;
    @FXML
    public static TextField emailAddress;
    @FXML
    public TextField password;
    @FXML
    public TextField mobilePhoneNumber;

    /**
     * Initializes the controller class.
     * @throws java.io.IOException
     */
    public void goToLoginPage() throws IOException {
     Stage stage;
        Parent root;

        stage = (Stage) returnToLogin.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("loginScreenFinal.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void goToBankDetails() throws IOException {
     Stage stage;
        Parent root;

        stage = (Stage) addBankingDetails.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("BankDetailsFormRiderFinal.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    /* public void Select() throws SQLException {
        Connection con = null;
        //Problem in connection
        Database.openConnection();
        //once u open connection u add create statement
        Statement stmt = Database.database.createStatement();
        //String sql = "INSERT INTO DRIVER " +
        // "VALUES ('102', 'Mahnaz', 'Fatma@example.com', 'mahnaz25', 'toyota', 'corolla', '5', '123465', '1005612345');";
        //stmt.execute(sql);

//            stmt.executeUpdate("INSERT INTO DRIVER VALUES (1, timmy, timmy@example.com, tim123, toyota, corolla, 5, 123456, 1005612345);");
        ResultSet rs = stmt.executeQuery("select * from driver");
        Database.closeConnection();
        rs.absolute(1);
        System.out.println(rs.getInt(1) + " " + rs.getString(2));
        /*         ResultSet rs = stmt.executeQuery("select * from driver");
            rs.absolute(1);
            System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));*/


 /* @FXML
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
}*/
    public void insertIntoDriver() {
        try {
            //        System.out.println("BEGIN");
//        System.out.println("NAME" + name.getText());
//email.setOnAction(e -> email.setText(email.getText()));
//name.setOnAction(e -> name.setText(name.getText()));
//        String driverName = RegoFormRiderController.name.getText();
//        String wam = RegoFormRiderController.email.getText(); 
                          
            Database.openConnection();
            String insertSQL = "INSERT INTO RIDER (RIDERID, NAME, EMAILADDRESS, PASSWORD, MOBILEPHONENUMBER) VALUES(?, ?, ?, ?,?)";
            PreparedStatement stmt = Database.database.prepareStatement(insertSQL);
            stmt.setInt(1, 3);
            stmt.setString(2, name.toString());
            stmt.setString(3, emailAddress.toString());
            stmt.setString(4, password.toString());
            stmt.setString(5, mobilePhoneNumber.toString());
            stmt.executeUpdate();
//        stmt.setString(4, RegoFormRiderController.password.toString());
//        stmt.setString(5, RegoFormRiderController.companyName.toString());
//        stmt.setString(6, RegoFormRiderController.contactNumber.toString());

          //assignment.database.Database.database.setAutoCommit(true);

        } catch (SQLException ex) {
            Logger.getLogger(RegoFormRiderFinalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            Database.closeConnection();
        }
    }

    @FXML
    public void handleButtonAction(ActionEvent event) throws SQLException {
        insertIntoDriver();
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
    }*/
