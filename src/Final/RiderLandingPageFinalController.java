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
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ajay Matta
 */
public class RiderLandingPageFinalController implements Initializable {

    @FXML
    public Text name1;
    @FXML
    public Button favourites;
    @FXML
    public Button tripHistory;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
      public void goToTripHistory(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) tripHistory.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("TripHistoryFinal.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
      
    @FXML
    public void goToMyProfile(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) myProfile.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("MyProfileRiderFinal.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
     public void goToFaqs(ActionEvent event) throws IOException {
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