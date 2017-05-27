/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Final;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
    public Button confirm; //NEED TO CREATE DRIVER LANDING PAGE SO I CAN LINK
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
    public void handleButtonAction(ActionEvent event) {
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
}
