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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ajay Matta
 */
public class MyProfileStaffFinalController implements Initializable {

    @FXML
    public Text name1;
    @FXML
    public Button myProfile;
    @FXML
    public Button faq;
    @FXML
    public Button contactUs;
    @FXML
    public Button signOut;
    @FXML
    public Text userType;
    @FXML
    public Button update;
    @FXML
    public TextField name;
    @FXML
    public TextField mobilePhoneNumber;
    @FXML
    public Label emailAddress;
    @FXML
    public Label password;
    @FXML
    public Button backToDashboard;

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
    public void goBackToLandingPage (ActionEvent event) throws IOException {
    Stage stage;
        Parent root;

        stage = (Stage) backToDashboard.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("StaffLandingPageFinal.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
}
    public void goToFaqs(ActionEvent even) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) faq.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("FAQDriverFinal.fxml"));
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
       public void goToLoginPage(ActionEvent even) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) signOut.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("loginScreenFinal.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
}
}
