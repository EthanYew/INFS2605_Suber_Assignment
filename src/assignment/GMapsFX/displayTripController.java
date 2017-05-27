package assignment.GMapsFX;

import assignment.database.Database;
import assignment.view.Login_ScreenController;
import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.*;
import com.lynden.gmapsfx.service.directions.*;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class displayTripController implements Initializable, MapComponentInitializedListener, DirectionsServiceCallback {

    protected DirectionsService directionsService;
    protected DirectionsPane directionsPane;

    protected StringProperty from = new SimpleStringProperty();
    protected StringProperty to = new SimpleStringProperty();

    @FXML
    protected GoogleMapView mapView;

//    @FXML
//    protected TextField fromTextField;
//
    @FXML
    protected TextField toTextField;
    
    String originAddress;
    String destinationAddress;
    int tripID = 2;

    @FXML
    private void toTextFieldAction(ActionEvent event) {
        try {
            getTrip(originAddress, destinationAddress);
            DirectionsRequest request = new DirectionsRequest(originAddress, destinationAddress, TravelModes.DRIVING);
            directionsService.getRoute(request, this, new DirectionsRenderer(true, mapView.getMap(), directionsPane));
        } catch (SQLException ex) {
            Logger.getLogger(displayTripController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void directionsReceived(DirectionsResult results, DirectionStatus status) {
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mapView.addMapInializedListener(this);
//        to.bindBidirectional(toTextField.textProperty());
//        from.bindBidirectional(fromTextField.textProperty());
    }

    @Override
    public void mapInitialized() {
        MapOptions options = new MapOptions();

        options.center(new LatLong(47.606189, -122.335842))
                .zoomControl(true)
                .zoom(12)
                .overviewMapControl(false)
                .mapType(MapTypeIdEnum.ROADMAP);
        GoogleMap map = mapView.createMap(options);
        directionsService = new DirectionsService();
        directionsPane = mapView.getDirec();
    }

    private void getTrip(String email, String password) throws SQLException {

        try {
            Database.openConnection();
            Statement stmt = Database.database.createStatement();

            ResultSet result = stmt.executeQuery("SELECT STARTINGDESTINATION, ENDINGDESTINATION FROM TRIP WHERE TRIPID=" + tripID + ";");
            if (result.next()) {
                System.out.println("Result found");
                

                
                    originAddress = result.getString("STARTINGDESTINATION");
                    destinationAddress = result.getString("ENDINGDESTINATION");
                    
                    Database.closeConnection();

                
            } else {
                System.out.println("result not found");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Look, an Error Dialog");
                alert.setContentText("Ooops, there was an error!");

                alert.showAndWait();
                Database.closeConnection();
                
            }

            }catch (SQLException ex) {
            Logger.getLogger(Login_ScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }

        }

    
}
