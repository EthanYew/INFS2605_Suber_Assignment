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
public class CarDetailsFormDriverFinalController implements Initializable {

    @FXML
    public Button returnToLogin;
    @FXML
    public TextField carMake;
    @FXML
    public TextField carYear;
    @FXML
    public TextField carModel;
    @FXML
    public TextField licenseNumber;
    @FXML
    public Button confirm;
    @FXML
    public TextField carRegistrationNumber;
    @FXML
    public TextField numberOfSeats;
    @FXML
    public TextField carInsurancePolicyNumber;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    public void handleButtonAction(ActionEvent event) throws IOException, SQLException{
        createAccountDriverCar(carYear.getText(), carMake.getText(), carModel.getText(), numberOfSeats.getText(), carRegistrationNumber.getText(), licenseNumber.getText(), carInsurancePolicyNumber.getText());
        Stage stage;
        Parent root;

        stage = (Stage) returnToLogin.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("loginScreenFinal.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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
    //Driver Landing page doesnt currently exist
    /*public void confirm() throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) confirm.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("driverLandingPageFinal.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }*/
    
    public void createAccountDriverCar(String carYear, String carMake, String carModel, String numberOfSeats, String carRegistrationNumber, String licenseNumber, String carInsurancePolicyNumber) throws SQLException{
        try{
        Database.openConnection();
        PreparedStatement stmt = Database.database.prepareStatement("UPDATE DRIVER "
                + "SET carModelYear = ?, carMake = ?, carModel = ?, noofseats = ?, carRegistrationNumber = ?, licenseNumber = ?, "
                + "carInsurancePolicyNumber = ? WHERE emailaddress = ?");
        stmt.setString(1, carYear);
        stmt.setString(2, carMake);
        stmt.setString(3, carModel);
        stmt.setString(4, numberOfSeats);
        stmt.setString(5, carRegistrationNumber);
        stmt.setString(6, licenseNumber);
        stmt.setString(7, carInsurancePolicyNumber);
        stmt.setString(8, RegoFormDriverFinalController.getUserIdentifier());
        stmt.executeUpdate();
        Database.closeConnection();
    }
        catch(SQLException ex) {
            Logger.getLogger(RegoFormRiderFinalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
