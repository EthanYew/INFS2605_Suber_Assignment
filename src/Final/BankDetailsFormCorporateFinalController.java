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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ajay Matta
 */
//Need to create a radio group so we can only select one out of the two radio buttons
public class BankDetailsFormCorporateFinalController implements Initializable {

    @FXML
    public Button returnToLogin;
    @FXML
    public TextField expiryDate;
    @FXML
    public TextField cardNumber;
    @FXML
    public TextField cvv;
    @FXML
    public TextField nameOnCard;
    @FXML
    public Button confirm; //NEED TO CREATE CORPORATE RIDER LANDING PAGE SO I CAN LINK
    @FXML
    public TextField companyName;
    @FXML
    public ChoiceBox<?> consultant;
    @FXML
    public RadioButton yesRadioButton;
    @FXML
    public RadioButton noRadioButton;

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
    public void goToLoginPage() throws IOException {
     Stage stage;
        Parent root;

        stage = (Stage) returnToLogin.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("loginScreenFinal.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
