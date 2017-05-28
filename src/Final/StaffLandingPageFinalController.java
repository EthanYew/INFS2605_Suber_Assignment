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
 * @author AriSurfacePro
 */
public class StaffLandingPageFinalController implements Initializable {

    @FXML
    private Button favourites;
    @FXML
    private Button tripHistory;
    @FXML
    private Button myProfile;
    @FXML
    private Button faqs;
    @FXML
    private Button contactUs;
    @FXML
    private Button signOut;
    @FXML
    private Button editCorporateMember;
    @FXML
    private Button addStaffAccount;
    @FXML
    private Button addCorporateMember;
    @FXML
    private Button editStaffAccount;
    @FXML
    private Button editDriver;
    @FXML
    private Button editRider;
    @FXML
    private Button addPotentialCustomers;
    @FXML
    private Button generateMailingList;

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

    @FXML
    private void getCorporateRiderReport(ActionEvent event) throws IOException{
        Stage stage;
        Parent root;

        stage = (Stage) editCorporateMember.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("StaffCorporateRiderReportFinal.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void getStaffReport(ActionEvent event) throws IOException{
        Stage stage;
        Parent root;

        stage = (Stage) editStaffAccount.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("StaffStaffReportFinal.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void getDriverReport(ActionEvent event) throws IOException{
        Stage stage;
        Parent root;

        stage = (Stage) editDriver.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("StaffDriverReportFinal.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void getRiderReport(ActionEvent event) throws IOException{
        Stage stage;
        Parent root;

        stage = (Stage) editRider.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("StaffStaffRiderReportFinal.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
