package assignment;

import java.net.URL;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
*
* @web http://java-buddy.blogspot.com/
*/
public class webViewDemo extends Application {

/**
 * @param args the command line arguments
 */
public static void main(String[] args) {
    launch(args);
}

@Override
public void start(Stage primaryStage) {
    primaryStage.setTitle("java-buddy.blogspot.com");

    WebView browser = new WebView();
    WebEngine engine = browser.getEngine();
    String url = Assignment.class.getResource("/assignment/placesAutocompleteDirections.html").toExternalForm();
    engine.load(url);
        
    StackPane sp = new StackPane();
    sp.getChildren().add(browser);
    Scene root = new Scene(sp);

    primaryStage.setScene(root);
    primaryStage.show();
}


}