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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ajay Matta
 */
public class SuberAccountTypeFinalController implements Initializable {

    @FXML
    public Button backToLogin;
    @FXML
    public Button rider;
    @FXML
    public Button corporateRider;
    @FXML
    public Button driver;

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

    public void goToCreateCorporateRider() throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) corporateRider.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("RegoFormCorporateMemberFinal.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    
    public void goToCreateDriver() throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) driver.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("RegoFormDriverFinal.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    public void goToCreateRider(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) rider.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("RegoFormRiderFinal.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void goToLogin(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) backToLogin.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("loginScreenFinal.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
