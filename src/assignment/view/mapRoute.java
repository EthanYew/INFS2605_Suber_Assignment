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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 *
 * @author EthanYew
 */
public class mapRoute extends Application {
    
    private String originPlaceId;
    private String destinationPlaceId;

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
        
        //engine.setCreatePopupHandler(null);
        engine.load(url);
        
        Button btn_saveOriginPlaceId = new Button();
        btn_saveOriginPlaceId.setText("Save Origin PlaceId");
        btn_saveOriginPlaceId.setOnAction(new EventHandler<ActionEvent>() {        
            @Override
            public void handle(ActionEvent event) {

               //Pass this to javascript
//               engine.executeScript("myName("+"'"+ name +"'"+ ")");

               //get return value from javascript
               originPlaceId = (String)engine.executeScript("returnOriginPlaceId()");
               System.out.println(originPlaceId);

               
            }
            });
        
        Button btn_saveDestinationPlaceId = new Button();
        btn_saveDestinationPlaceId.setText("Save Destination PlaceId");
        btn_saveDestinationPlaceId.setOnAction(new EventHandler<ActionEvent>() {        
            @Override
            public void handle(ActionEvent event) {

               //Pass this to javascript
//               engine.executeScript("myName("+"'"+ name +"'"+ ")");

               //get return value from javascript
               destinationPlaceId = (String)engine.executeScript("returnDestinationPlaceId()");
               System.out.println(destinationPlaceId);

               
            }
            });
        
        BorderPane bp = new BorderPane();
        bp.setCenter(webView);
        Scene root = new Scene(bp);
        
        FlowPane fp = new FlowPane();
        fp.getChildren().addAll(btn_saveOriginPlaceId, btn_saveDestinationPlaceId);
        
        bp.setBottom(fp);
        
        primaryStage.setScene(root);
        primaryStage.show();

    }

    public void initialize(URL url, ResourceBundle rb) {
        engine = webView.getEngine();
        //engine.setCreatePopupHandler(null);
        engine.load(Assignment.class.getResource("/assignment/placesAutocompleteDirections.html").toExternalForm());
    }

}
