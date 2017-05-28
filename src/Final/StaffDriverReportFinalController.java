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
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author AriSurfacePro
 */
public class StaffDriverReportFinalController implements Initializable {

    @FXML
    private TableView<?> driverReport;
    @FXML
    private Button refresh;
    @FXML
    private Button backToDashboard;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void refresh(ActionEvent event) {
    }
    
    @FXML
    private void backToDashboard(ActionEvent event) throws IOException{
        Stage stage;
        Parent root;

        stage = (Stage) backToDashboard.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("StaffLandingPageFinal.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
