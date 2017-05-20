package assignment.view;

import assignment.*;
import java.net.URL;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @web http://java-buddy.blogspot.com/
 */
public class mapsRouteController extends Application {

    /**
     * @param args the command line arguments
     */
    @FXML
    private WebView webView;

    @FXML
    private WebEngine engine;
    
    @Override
    public void start(Stage primaryStage) {

//        WebEngine engine = webView.getEngine();
//        String url = Assignment.class.getResource("/assignment/placesAutocompleteDirections.html").toExternalForm();
//        engine.load(url);
//
        //mapsRoute ctc = new webViewDemoController();
//      ctc.start(webViewDemo.classStage);
     
        StackPane sp = new StackPane();
        sp.getChildren().add(webView);
        Scene root = new Scene(sp);

        primaryStage.setScene(root);
        primaryStage.show();
    }

    public void initialize(URL url, ResourceBundle rb) {
        engine = webView.getEngine();
        engine.load(Assignment.class.getResource("/assignment/placesAutocompleteDirections.html").toExternalForm());
    }

}
