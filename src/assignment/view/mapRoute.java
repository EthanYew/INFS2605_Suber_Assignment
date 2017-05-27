/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.view;

import assignment.Assignment;
import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.InfoWindow;
import com.lynden.gmapsfx.javascript.object.InfoWindowOptions;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.LatLongBounds;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.MapTypeIdEnum;
import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;
import com.lynden.gmapsfx.service.geocoding.GeocoderStatus;
import com.lynden.gmapsfx.service.geocoding.GeocodingResult;
import com.lynden.gmapsfx.service.geocoding.GeocodingService;
import com.lynden.gmapsfx.service.geocoding.GeocodingServiceCallback;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
public class mapRoute extends Application implements MapComponentInitializedListener {

    GoogleMapView mapView;
    GoogleMap map;
    TextField inputOrigin;
    Button originButton;
    String originAddress;

    @Override
    public void start(Stage primaryStage) throws Exception {
        mapView = new GoogleMapView();
        mapView.addMapInializedListener(this);

        inputOrigin = new TextField();
        originButton = new Button();
        mapView.getChildren().addAll(inputOrigin, originButton);

        Scene scene = new Scene(mapView);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    @Override
    public void mapInitialized() {

        LatLong joeSmithLocation = new LatLong(47.6197, -122.3231);
        LatLong joshAndersonLocation = new LatLong(47.6297, -122.3431);
        LatLong bobUnderwoodLocation = new LatLong(47.6397, -122.3031);
        LatLong tomChoiceLocation = new LatLong(47.6497, -122.3325);
        LatLong fredWilkieLocation = new LatLong(47.6597, -122.3357);

        TextField inputOrigin = new TextField();
        String originAddress = inputOrigin.getText();

        Button originButton = new Button();
        originButton.setOnAction(new searchHandler());

        mapView.getChildren().addAll(inputOrigin, originButton);

        //Set the initial properties of the map.
        MapOptions mapOptions = new MapOptions();

        mapOptions.center(new LatLong(47.6097, -122.3331))
                .mapType(MapTypeIdEnum.ROADMAP)
                .overviewMapControl(true)
                .panControl(true)
                .rotateControl(true)
                .scaleControl(true)
                .streetViewControl(true)
                .zoomControl(true)
                .zoom(12);

        map = mapView.createMap(mapOptions);

        //Add markers to the map
        MarkerOptions markerOptions1 = new MarkerOptions();
        markerOptions1.position(joeSmithLocation);

        MarkerOptions markerOptions2 = new MarkerOptions();
        markerOptions2.position(joshAndersonLocation);

        MarkerOptions markerOptions3 = new MarkerOptions();
        markerOptions3.position(bobUnderwoodLocation);

        MarkerOptions markerOptions4 = new MarkerOptions();
        markerOptions4.position(tomChoiceLocation);

        MarkerOptions markerOptions5 = new MarkerOptions();
        markerOptions5.position(fredWilkieLocation);

        Marker joeSmithMarker = new Marker(markerOptions1);
        Marker joshAndersonMarker = new Marker(markerOptions2);
        Marker bobUnderwoodMarker = new Marker(markerOptions3);
        Marker tomChoiceMarker = new Marker(markerOptions4);
        Marker fredWilkieMarker = new Marker(markerOptions5);

        map.addMarker(joeSmithMarker);
        map.addMarker(joshAndersonMarker);
        map.addMarker(bobUnderwoodMarker);
        map.addMarker(tomChoiceMarker);
        map.addMarker(fredWilkieMarker);

        InfoWindowOptions infoWindowOptions = new InfoWindowOptions();
        infoWindowOptions.content("<h2>Fred Wilkie</h2>"
                + "Current Location: Safeway<br>"
                + "ETA: 45 minutes");

        InfoWindow fredWilkeInfoWindow = new InfoWindow(infoWindowOptions);
        fredWilkeInfoWindow.open(map, fredWilkieMarker);

    }

    class searchHandler implements EventHandler<ActionEvent> {

        @Override // Override the handle method
        public void handle(ActionEvent e) {
            findAddress(originAddress);
        }
    }

    public void findAddress(String address) {
        GeocodingService gs = new GeocodingService();
        gs.geocode(address, new GeocodingServiceCallback() {
            @Override
            public void geocodedResultsReceived(GeocodingResult[] grs, GeocoderStatus gs) {
                if (GeocoderStatus.OK.equals(gs)) {
                    if (grs.length > 0) {
                        GeocodingResult g = grs[0];
//                        LatLongBounds llb = g.getGeometry().getBounds();
//                        if (llb != null) {
//                            System.out.println("Map Bounds For Location: " + llb);
//                            map.fitBounds(llb);
//                        }

                        LatLong ctr = g.getGeometry().getLocation();
                        if (ctr != null) {
                            map.setCenter(ctr);
                        }
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
