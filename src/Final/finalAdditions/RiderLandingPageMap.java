/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Final.finalAdditions;

import Final.Final;
import Final.login_ScreenFinalController;
import assignment.GMapsFX.*;
import assignment.database.Database;
import assignment.view.RegoFormRiderController;
import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.*;
import com.lynden.gmapsfx.service.directions.DirectionStatus;
import com.lynden.gmapsfx.service.directions.DirectionsRenderer;
import com.lynden.gmapsfx.service.directions.DirectionsRequest;
import com.lynden.gmapsfx.service.directions.DirectionsResult;
import com.lynden.gmapsfx.service.directions.DirectionsRoute;
import com.lynden.gmapsfx.service.directions.DirectionsService;
import com.lynden.gmapsfx.service.directions.DirectionsServiceCallback;
import com.lynden.gmapsfx.service.directions.Distance;
import com.lynden.gmapsfx.service.directions.TravelModes;
import com.lynden.gmapsfx.service.geocoding.GeocoderStatus;
import com.lynden.gmapsfx.service.geocoding.GeocodingResult;
import com.lynden.gmapsfx.service.geocoding.GeocodingService;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RiderLandingPageMap implements Initializable, MapComponentInitializedListener, DirectionsServiceCallback {

    @FXML
    private GoogleMapView mapView;

    @FXML
    private TextField addressTextField;

    @FXML
    private TextField addressTextField2;

    private Button backToLoginBtn;

    private GoogleMap map;

    private GeocodingService geocodingService;

    private StringProperty address = new SimpleStringProperty();

    private StringProperty address2 = new SimpleStringProperty();

    protected DirectionsService directionsService;
    protected DirectionsPane directionsPane;

    protected DirectionsResult directionsResult;

    String destinationLatLng;
    String originLatLng;

    protected DirectionsRenderer directionsDisplay;
    @FXML
    private Button setRoute;
    @FXML
    private Button savePointsBtn;

    //Stuff to save
    String formattedOriginAddress;
    Double latOrigin;
    Double longOrigin;

    String formattedDestinationAddress;
    Double longDestination;
    Double latDestination;
    @FXML
    private Text name1;
    @FXML
    private Button favourites;
    @FXML
    private Button tripHistory;
    @FXML
    private Button myProfile;
    @FXML
    private Button faq;
    @FXML
    private Button contactUs;
    @FXML
    private Button signOut;
    @FXML
    private Text userType;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            System.out.println("sdhfskdj");
            mapView.addMapInializedListener(this);
            address.bind(addressTextField.textProperty());
            address2.bind(addressTextField2.textProperty());
//            name1.textProperty().setValue(Final.login_ScreenFinalController.getLoggedInEmail());
            
            Database.openConnection();
            Statement stmt = Database.database.createStatement();
           // String userEmail = Final.login_ScreenFinalController.getLoggedInEmail();
            ResultSet result = stmt.executeQuery("SELECT name FROM rider where emailaddress = '"+login_ScreenFinalController.getLoggedInEmail()+"';");
            if(result.next()){
            System.out.println(result.getString(1));
            name1.setText(result.getString(1));
            
            }
            Database.closeConnection();
//            Database.openConnection();
//            PreparedStatement stmt1 = Database.database.prepareStatement("SELECT name from driver WHERE EMAILADDRESS = ?");
//            stmt1.setString(1, Final.login_ScreenFinalController.getLoggedInEmail()); 
//            name1.textProperty().setValue(stmt1.executeQuery().toString());
//            Database.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(RiderLandingPageMap.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    

    @Override
    public void mapInitialized() {
        geocodingService = new GeocodingService();
        MapOptions mapOptions = new MapOptions();

        mapOptions.center(new LatLong(47.6097, -122.3331))
                .mapType(MapTypeIdEnum.ROADMAP)
                .overviewMapControl(true)
                .panControl(true)
                .rotateControl(true)
                .scaleControl(true)
                .streetViewControl(false)
                .zoomControl(true)
                .zoom(12);

        map = mapView.createMap(mapOptions);
        directionsService = new DirectionsService();

        directionsPane = mapView.getDirec();
        directionsResult = new DirectionsResult();
    }

    @FXML
    public void addressTextFieldAction(ActionEvent event) {
        geocodingService.geocode(address.get(), (GeocodingResult[] results, GeocoderStatus status) -> {

            LatLong latLong = null;

            if (status == GeocoderStatus.ZERO_RESULTS) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "No matching address found");
                alert.show();
                return;
            } else if (results.length > 1) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Multiple results found, showing the first one.");
                alert.show();
                latLong = new LatLong(results[0].getGeometry().getLocation().getLatitude(), results[0].getGeometry().getLocation().getLongitude());

            } else {
                latLong = new LatLong(results[0].getGeometry().getLocation().getLatitude(), results[0].getGeometry().getLocation().getLongitude());
                System.out.println(results[0].getFormattedAddress());

                latOrigin = latLong.getLatitude();
                longOrigin = latLong.getLongitude();
                formattedOriginAddress = results[0].getFormattedAddress();

                addressTextField.setText(results[0].getFormattedAddress());
            }

            map.setCenter(latLong);

        });
    }

    @FXML
    public void addressTextFieldAction2(ActionEvent event) {
        geocodingService.geocode(address2.get(), (GeocodingResult[] results, GeocoderStatus status) -> {

            LatLong latLong = null;

            if (status == GeocoderStatus.ZERO_RESULTS) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "No matching address found");
                alert.show();
                return;
            } else if (results.length > 1) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Multiple results found, showing the first one.");
                alert.show();
                latLong = new LatLong(results[0].getGeometry().getLocation().getLatitude(), results[0].getGeometry().getLocation().getLongitude());
                System.out.println(latLong.toString());
            } else {
                latLong = new LatLong(results[0].getGeometry().getLocation().getLatitude(), results[0].getGeometry().getLocation().getLongitude());

                longDestination = latLong.getLongitude();
                latDestination = latLong.getLatitude();
                formattedDestinationAddress = results[0].getFormattedAddress();
                addressTextField2.setText(results[0].getFormattedAddress());

                directionsDisplay = new DirectionsRenderer(true, mapView.getMap(), directionsPane);
                DirectionsRequest request = new DirectionsRequest(address.get(), address2.get(), TravelModes.DRIVING);
                directionsService.getRoute(request, this, directionsDisplay);

//                System.out.println(computeTotalDistance(directionsResult)+ " distance yo");
                //computeTotalDistance not working
            }

        });
    }

//    class searchHandler implements EventHandler<ActionEvent> {
//
//        @Override // Override the handle method
//        public void handle(ActionEvent e) {
//            calculateRoute(e);
//        }
//    }
    public double computeTotalDistance(DirectionsResult results) {
        double total = 0;
        DirectionsRoute myroute = results.getRoutes().get(0);
        for (int i = 0; i < myroute.getLegs().size(); i++) {
            total += myroute.getLegs().get(i).getDistance().getValue();
        }
        total = total / 1000;
        return total;
    }

    @FXML
    public void calculateRoute(ActionEvent event) {

        DirectionsRequest request = new DirectionsRequest(address.get(), address2.get(), TravelModes.DRIVING);
        directionsService.getRoute(request, this, new DirectionsRenderer(true, mapView.getMap(), directionsPane));
//        directionsService.processResponse(request, this);
        addressTextFieldAction(event);
        addressTextFieldAction2(event);
    }

    @Override
    public void directionsReceived(DirectionsResult results, DirectionStatus status) {

    }

    @FXML
    private void savePoints(ActionEvent event) {
        try {
            DirectionsRequest request = new DirectionsRequest(address.get(), address2.get(), TravelModes.DRIVING);
            directionsService.getRoute(request, this, new DirectionsRenderer(true, mapView.getMap(), directionsPane));
//        directionsService.processResponse(request, this);
            addressTextFieldAction(event);
            addressTextFieldAction2(event);
            System.out.println("BEGIN SAVEPOINTS");
            Database.openConnection();
            PreparedStatement stmt = Database.database.prepareStatement("INSERT INTO TRIP (STARTINGDESTINATION, ENDINGDESTINATION) VALUES(?, ?)");
            stmt.setString(1, formattedOriginAddress);
            stmt.setString(2, formattedDestinationAddress);
//            stmt.setDouble(2, Double.parseDouble(email));

//        stmt.setString(4, RegoFormRiderController.password.toString());
//        stmt.setString(5, RegoFormRiderController.companyName.toString());
//        stmt.setString(6, RegoFormRiderController.contactNumber.toString());
            stmt.executeUpdate();
            System.out.println("Record is inserted into TRIP table!");

            Database.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(RegoFormRiderController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
    //MENU
    @FXML
    public void goToFavourites(ActionEvent even) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) favourites.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("FavouriteTripsFinal.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
      public void goToTripHistory(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) tripHistory.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("TripHistoryFinal.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
      
    @FXML
    public void goToMyProfile(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) myProfile.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("MyProfileRiderFinal.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
     public void goToFaqs(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) faq.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("FAQDriverFinal.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
      public void goToContactUs(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) contactUs.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("ContactUsFinal.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
       public void goToLoginPage(ActionEvent even) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) signOut.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/Final/loginScreenFinal.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
}

}
