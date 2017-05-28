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
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ajay Matta
 */
public class CorporateRiderLandingPageFinalController implements Initializable {

    @FXML
    private Text name1;
    @FXML
    private Button favourites;
    @FXML
    private Button tripHistory;
    @FXML
    private Button myProfile;
    @FXML
    private Button faq;
    @FXML
    private Button contactUs;
    @FXML
    private Button signOut;
    @FXML
    private Text userType;

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
        root = FXMLLoader.load(getClass().getResource("MyProfileCorporateRiderFinal.fxml"));
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