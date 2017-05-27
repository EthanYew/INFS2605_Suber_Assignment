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
    
    public void goToCarDetails() throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) addCarDetails.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("CarDetailsFormDriverFinal.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    
}
//ADD BANKING DETAILS BUTTON ON CORPORATE RIDER REGO PAGE NOT WORKING
//FAQ ON LOGIN PAGE DOESNT WORK - DONE
// CONTACT US ON LOGIN PAGE DOESNT WORK - DONE