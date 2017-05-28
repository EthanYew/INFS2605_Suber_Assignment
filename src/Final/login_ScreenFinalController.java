/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Final;

import assignment.database.Database;
import static assignment.database.Database.database;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ajay Matta
 */
public class login_ScreenFinalController implements Initializable {

    @FXML
    public ImageView background;
    @FXML
    public PasswordField password;
    @FXML
    public TextField emailAddress;
    @FXML
    public Label forgottenPassword;
    @FXML
    public Button contactUs;
    @FXML
    public Button privacyPolicy;
    @FXML
    public Button faqs;
    @FXML
    public Button signIn;
    @FXML
    public Button createAccount;
    @FXML
    public Label dontHaveAccount;
    @FXML
    public ImageView logo;
    @FXML
    boolean returnResult = false;

    public static String loggedInEmail;

    public static String getLoggedInEmail() {
        return loggedInEmail;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        password.clear();
        emailAddress.clear();

    }

    @FXML
    public void goToHomePage(ActionEvent event) {
    }

    @FXML
    public void goToSignUpDriver(ActionEvent event) {
    }

    @FXML
    public void goToSignUpRider(ActionEvent event) {
    }

    @FXML
    public void goToCreateAccount(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) createAccount.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("SuberAccountTypeFinal.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void goToFaqs(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) faqs.getScene().getWindow();
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

//    @FXML
//    public void afterSignIn(ActionEvent event) throws IOException {
//        try {
//            Stage stage;
//            Parent root;
//           // if (clickLogin()) {
//                stage = (Stage) signIn.getScene().getWindow();
//                //Have to link sign In page to the rider/worker landing page
//                root = FXMLLoader.load(getClass().getResource("/Final/finalAdditions/RiderLandingPageMap.fxml"));
//                Scene scene = new Scene(root);
//                stage.setScene(scene);
//                stage.show();
//            }
//        catch (IOException e) {
//        }
//    }
    @FXML
    private void afterSignIn(ActionEvent event) throws IOException {

        returnResult = false;

        
        
         if (getRider(emailAddress.getText(), password.getText())) {
            System.out.println(emailAddress.getText() + "getRider passed" + password.getText());
            Stage stage;
            Parent root;

            System.out.println(emailAddress.getText());
            System.out.println(password.getText());
            password.clear();
            emailAddress.clear();

            stage = (Stage) signIn.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/Final/finalAdditions/RiderLandingPageMap.fxml"));

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
                
            else if (getDriver(emailAddress.getText(), password.getText())) {
            System.out.println(emailAddress.getText() + "getDriver passed" + password.getText());
            Stage stage;
            Parent root;

            System.out.println(emailAddress.getText());
            System.out.println(password.getText());
            password.clear();
            emailAddress.clear();

            stage = (Stage) signIn.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/Final/DriverLandingPageFinal.fxml"));

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
        
        else if (getCorporateMember(emailAddress.getText(), password.getText())) {

            

            System.out.println(emailAddress.getText() + "getCorporateMember passed" + password.getText());
            Stage stage;
            Parent root;

            System.out.println(emailAddress.getText());
            System.out.println(password.getText());
            password.clear();
            emailAddress.clear();

            stage = (Stage) signIn.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/Final/finalAdditions/RiderLandingPageMap.fxml"));

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
        
        else {
            System.out.println("User not found");
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Login Error");
            alert.setHeaderText("User not found");
            alert.setContentText("Invalid email address and/or password");

            alert.showAndWait();
            returnResult = false;
            Database.closeConnection();

        }

    }

    private boolean getDriver(String email, String password) {

//        returnResult = false;
        System.out.println(returnResult);

        try {
            Database.openConnection();
            Statement stmt = Database.database.createStatement();

            ResultSet resultDriver = stmt.executeQuery("SELECT EMAILADDRESS FROM DRIVER WHERE EXISTS ("
                    + "SELECT EMAILADDRESS FROM DRIVER WHERE PASSWORD = '" + password + "' AND EMAILADDRESS='" + email + "'  );");

            if (resultDriver.next()) {
                System.out.println("Driver found");
//                returnResult = true;
                loggedInEmail = email;
                Database.closeConnection();
                return true;

            }

        } catch (SQLException ex) {
            Logger.getLogger(login_ScreenFinalController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public boolean getRider(String emailAddress, String password) {

        try {
            Database.openConnection();
            Statement stmt = Database.database.createStatement();

            ResultSet resultRider = stmt.executeQuery("SELECT EMAILADDRESS FROM RIDER WHERE EXISTS ("
                    + "SELECT EMAILADDRESS FROM RIDER WHERE PASSWORD = '" + password + "' AND EMAILADDRESS='" + emailAddress + "'  );");

            if (resultRider.next()) {
                System.out.println("Rider found");
//                returnResult = true;
                Database.closeConnection();
                loggedInEmail = emailAddress;
                return true;

            }
        } catch (SQLException ex) {
            Logger.getLogger(login_ScreenFinalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean getCorporateMember(String emailAddress, String password) {

        try {
            Database.openConnection();
            Statement stmt = Database.database.createStatement();

            ResultSet resultCorporateMember = stmt.executeQuery("SELECT EMAILADDRESS FROM CORPORATEMEMBER WHERE EXISTS ("
                    + "SELECT EMAILADDRESS FROM CORPORATEMEMBER WHERE PASSWORD = '" + password + "' AND EMAILADDRESS='" + emailAddress + "'  );");

            if (resultCorporateMember.next()) {
                System.out.println("Corporate Member found");
//                returnResult = true;
                Database.closeConnection();
                loggedInEmail = emailAddress;
                return true;

            }
        } catch (SQLException ex) {
            Logger.getLogger(login_ScreenFinalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    
}
