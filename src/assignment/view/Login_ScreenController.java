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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author EthanYew
 */
public class Login_ScreenController implements Initializable {

    @FXML
    private PasswordField pwf_Password;
    @FXML
    private TextField tf_Username;
    @FXML
    private Label lbl_Forgotten_Password;
    @FXML
    private ImageView img_logo;
    private Button SignUp;
    @FXML
    private Label label_contactUs;
    @FXML
    private Label lbl_privacyPolicy;
    @FXML
    private Label lbl_FAQS;
    @FXML
    private Button btn_signIn;
    private Button btn_signUpDriver;
    @FXML
    private Label lbl_dontHaveAccount;
    private Button btn_rideWithSuber;
    @FXML
    private Button btn_createAccount;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    //jkdhjsdfh
//    bdhfgshd
    
    @FXML
    private void goToHomePage(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
       
        stage=(Stage) btn_signIn.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Home_Page.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void goToCreateAccount(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
       
        stage=(Stage) btn_createAccount.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("createAccount.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
