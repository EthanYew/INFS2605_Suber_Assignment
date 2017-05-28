/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Final;

import static Final.RegoFormRiderFinalController.userIdentifier;
import assignment.database.Database;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    @FXML
    public TextField nameonCard;
    @FXML
    public TextField cardNumber;
    @FXML
    public TextField CVV;
    @FXML
    public TextField expiryDate;
    @FXML
    public Label emailAddress;
    @FXML
    public Label password;
    @FXML
    public Button tripHistory;
    @FXML
    public Button favourites;
    @FXML
    public TextField licenseNumber;
    @FXML
    public TextField bsb;
    @FXML
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
    public void handleButtonAction(ActionEvent event){
        
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

    public void updateMyProfileRider(String name, String mobilePhoneNumber, String nameOnCard, String cardNumber, String cvv, String expiryDate) throws SQLException {
        try {
            Database.openConnection();
            PreparedStatement stmt = Database.database.prepareStatement("UPDATE RIDER SET name = ?, mobilePhoneNumber = ?, nameOnCard = ?, cardNumber = ?, cvv = ?, expiryDate = ? WHERE emailaddress = ?");
            stmt.setString(1, name);
            stmt.setString(2, mobilePhoneNumber);
            stmt.setString(3, nameOnCard);
            stmt.setString(4, cardNumber);
            stmt.setString(5, cvv);
            stmt.setString(6, expiryDate);
            stmt.setString(7, login_ScreenFinalController.getLoggedInEmail());
            stmt.executeUpdate();
            Database.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(RegoFormRiderFinalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void update(ActionEvent event) throws IOException, SQLException {
        //Runs the update method for the My Profile Page (Rider Module)
        updateMyProfileRider(name.getText(), mobilePhoneNumber.getText(), nameOnCard.getText(), cardNumber.getText(), cvv.getText(), expiryDate.getText());
        //Sets the Scene to the new page
        Stage stage;
        Parent root;

        stage = (Stage) update.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("MyProfileRiderFinal.fxml")); //Reloads the same page with the newly updated data
        Scene scene = new Scene(root);
        stage.setScene(scene);

        stage.show();
    }
}
