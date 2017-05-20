/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.view;

import assignment.Assignment;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 *
 * @author EthanYew
 */
public class mapRoute extends Application {

    @FXML
    private WebView webView;

    @FXML
    private WebEngine engine;

    static Stage classStage = new Stage();

    @Override
    public void start(Stage primaryStage) throws Exception {
        classStage = primaryStage;

        //nice gui
        WebView webView = new WebView();
        WebEngine engine = webView.getEngine();
        String url = Assignment.class.getResource("/assignment/placesAutocompleteDirections.html").toExternalForm();
        engine.load(url);

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
