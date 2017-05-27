/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.view;

import assignment.database.Database;
import java.io.IOException;
import java.net.URL;
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
    @FXML
    private PasswordField pwfPassword;
    @FXML
    private TextField tfEmail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    //jkdhjsdfh
//    bdhfgshd
    static Stage classStage = new Stage();

    public void start(Stage primaryStage) {

        classStage = primaryStage;
    }

    @FXML
    private void goToHomePage(ActionEvent event) {
        try {

            if (getDriver(tfEmail.getText(), pwfPassword.getText())) {
                System.out.println("getDriver passed");
                Stage stage;
                Parent root;

                stage = (Stage) btn_signIn.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("/assignment/GMapsFX/MapSearchAddress.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

                mapRoute ctc = new mapRoute();
//            ctc.start(mapRoute.classStage);
            }

        } catch (IOException ex) {
            Logger.getLogger(Login_ScreenController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Invalid email and/or password");
        }

    }

    @FXML
    private void goToCreateAccount(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) btn_createAccount.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/assignment/view/createAccount.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private boolean getDriver(String email, String password) {

        boolean returnResult = false;

        try {
            Database.openConnection();
            Statement stmt = Database.database.createStatement();

            ResultSet result = stmt.executeQuery("SELECT EMAILADDRESS FROM DRIVER WHERE EXISTS ("
                    + "SELECT EMAILADDRESS FROM DRIVER WHERE EMAILADDRESS='" + email + "');");
            if (result.next()) {
                System.out.println("Result found");
                returnResult = true;
                Database.closeConnection();
                return returnResult;

            } else {
                System.out.println("result not found");
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Look, an Error Dialog");
                alert.setContentText("Ooops, there was an error!");

                alert.showAndWait();
                Database.closeConnection();
                return false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Login_ScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return returnResult;
    }
}
