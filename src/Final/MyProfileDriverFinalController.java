/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Final;

import assignment.database.Database;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class MyProfileDriverFinalController implements Initializable {

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
    @FXML
    public Button update;
    @FXML
    public Button next;
    @FXML
    public TextField name;
    @FXML
    public TextField mobilePhoneNumber;
    @FXML
    public Label emailAddress;
    @FXML
    public TextField licenseNumber;
    @FXML
    public Label password;
    @FXML
    public TextField bsb;
    @FXML
    public TextField accountNumber;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            assignment.database.Database.openConnection();
            Statement stmt = Database.database.createStatement();
            // String userEmail = Final.login_ScreenFinalController.getLoggedInEmail();
            ResultSet result = stmt.executeQuery("SELECT name FROM driver where emailaddress = '"+login_ScreenFinalController.getLoggedInEmail()+"';");
            System.out.println(result.getString(1));
            name1.setText(result.getString(1));
            Database.closeConnection();
        } catch (SQLException e) {
        }
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
    }

    public void inputValue(ActionEvent even) throws SQLException {
        PreparedStatement stmt1 = Database.database.prepareStatement("SELECT name FROM driver where emailaddress = '"+login_ScreenFinalController.getLoggedInEmail()+"';");
        name1 = (Text) stmt1.executeQuery();
    }

    public void goToFavourites(ActionEvent even) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) favourites.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("FavouriteTripsFinal.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void goToTripHistory(ActionEvent even) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) tripHistory.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("TripHistoryFinal.fxml"));
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

    public void goToLoginPage(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) signOut.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("loginScreenFinal.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void goToNextPage(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) next.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource(".fxml"));//WAITING TO RECEIVE MYPROFILE PAGE 2
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
