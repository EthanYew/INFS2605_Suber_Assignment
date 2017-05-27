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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ajay Matta
 */
public class StaffCreateNewStaffFinalController implements Initializable {

    @FXML
    public Button backToDashboard;
    @FXML
    public Button addStaffAccount;
    @FXML
    public TextField name;
    @FXML
    public TextField emailAddress;
    @FXML
    public TextField password;
    @FXML
    public TextField contactNumber;

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
}