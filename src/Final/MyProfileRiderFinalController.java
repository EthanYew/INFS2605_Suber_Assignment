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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ajay Matta
 */
public class MyProfileRiderFinalController implements Initializable {

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
    public TextField nameonCard;
    @FXML
    public TextField cardNumber;
    public TextField CVV;
    @FXML
    public DatePicker expiryDate;
    @FXML
    public Label emailAddress;
    @FXML
    public Label password;
    @FXML
    public Button tripHistory;
    @FXML
    public Button favourites;
    public TextField licenseNumber;
    public TextField bsb;
    public TextField accountNumber;
    @FXML
    private TextField nameOnCard;
    @FXML
    private TextField cvv;
    @FXML
    private Label companyName;

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
    //MENU
    @FXML
    public void goToFavourites(ActionEvent even) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) favourites.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("FavouriteTripsFinal.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
      public void goToTripHistory(ActionEvent even) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) tripHistory.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("TripHistoryFinal.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
     public void goToFaqs(ActionEvent even) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) faq.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("FAQDriverFinal.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
      public void goToContactUs(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) contactUs.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("ContactUsFinal.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
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