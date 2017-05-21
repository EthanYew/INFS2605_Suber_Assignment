/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;
//hnfdjksflnsdjkfnjsklnflksnjknjknjknkjkkvfdmkldm
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * test test
 * @author EthanYew
 */
public class Assignment extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/assignment/view/Login_Screen.fxml"));

        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        
        scene.getStylesheets().add(Assignment.class.getResource("/assignment/view/theme.css").toExternalForm());
        
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
