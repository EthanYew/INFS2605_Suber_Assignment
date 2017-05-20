/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.view;

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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author EthanYew
 */
public class createAccountController implements Initializable {

    @FXML
    private Button btn_rider;
    @FXML
    private Button btn_corporateRider;
    @FXML
    private Button btn_driver;
    @FXML
    private Button btn_backToLogin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
    }

    @FXML
    private void goToCreateDriverAccount(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) btn_driver.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("RegoFormDriver.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void goToCreateRiderAccount(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) btn_rider.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("RegoFormRider.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void goToCreateCorporateRider(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) btn_corporateRider.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("RegoFormCorporateRider.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void goToLoginPage(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) btn_backToLogin.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Login_Screen.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
