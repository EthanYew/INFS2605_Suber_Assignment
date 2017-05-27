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
public class StaffLandingPageController implements Initializable {

    @FXML
    public Button myProfile;
    @FXML
    public Button faqs;
    @FXML
    public Button contactUs;
    @FXML
    public Button signOut;
    @FXML
    public Button viewCorporateRider;
    @FXML
    public Button addStaffAccount;
    @FXML
    public Button addCorporateRider;
    @FXML
    public Button viewStaff;
    @FXML
    public Button viewDriver;
    @FXML
    public Button viewRider;
    @FXML
    public Button addPotentialCorporation;
    @FXML
    public Button generateMailingList;

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
    //MENU:
    @FXML
    public void goToMyProfile(ActionEvent even) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) myProfile.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("MyProfileStaffFinal.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    public void goToFaqs(ActionEvent even) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) faqs.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("FAQDriverFinal.fxml"));
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
      public void goToContactUs(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) contactUs.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("ContactUsFinal.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
      
      //STAFF DASHBOARD
      public void goToViewCorporateRider (ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) viewCorporateRider.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("StaffCorporateRiderReportFinal.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
      }
      public void goToViewStaff (ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) viewStaff.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("StaffStaffReportFinal.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
      }
      public void goToViewDriver (ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) viewDriver.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("StaffDriverReportFinal.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
      }
      public void goToViewRider (ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) viewRider.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("StaffRiderReportFinal.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
      }
      public void goToGenerateMailingList (ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) generateMailingList.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("StaffGenerateMailingListFinal.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
      }
      //NEED TO CREATE POTENTIAL CORPORATION PAGE
      /*public void goToAddPotentialCorporation (ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) addPotentialCorporation.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource(".fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
      }*/
      public void goToAddStaffAccount (ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) addStaffAccount.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("StaffCreateNewStaffFinal.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
      }
      public void goToAddCorporateRider (ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) addCorporateRider.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("RegoFormCorporateMemberFinal.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
      }
}