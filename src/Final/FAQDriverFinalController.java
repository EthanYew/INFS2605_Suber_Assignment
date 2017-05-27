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
public class FAQDriverFinalController implements Initializable {

    @FXML
    public Button faqs;
    @FXML
    public Button contactUs;
    @FXML
    public Button signIn;
    @FXML
    public Button createAccount;
    @FXML
    public Button privacyPolicy;

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
    public void goToCreateAccount(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) createAccount.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("SuberAccountTypeFinal.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
     public void goToContactUs(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) contactUs.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("ContactUsFinal.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
     public void goToSignIn(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) signIn.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("loginScreenFinal.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
}
    
    
}
