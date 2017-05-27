package assignment.view;

import assignment.classes.Trip;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author ericjbruno
 */
public class SampleController implements Initializable {

    @FXML
    private Button button;
    @FXML
    private Label label;
    
    
//    public class Item {
//        public SimpleLongProperty id = new SimpleLongProperty();
//        public SimpleStringProperty name = new SimpleStringProperty();
//        public SimpleIntegerProperty qty = new SimpleIntegerProperty();
//        public SimpleStringProperty price = new SimpleStringProperty();
//        
//        public Long getId() {
//            return id.get();
//        }
//
//        public String getName() {
//            return name.get();
//        }
//
//        public String getPrice() {
//            return price.get();
//        }
//
//        public Integer getQty() {
//            return qty.get();
//        }
//    }

    // The table and columns
    @FXML
    TableView<Trip> tripTbl;
    TableColumn tripID;
    TableColumn startLocationCol;
    TableColumn destinationCol;
    TableColumn favouriteCol;

    // The table's data
    ObservableList<Trip> data;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Set up the table data
        tripID.setCellValueFactory(
            new PropertyValueFactory<Trip,Long>("tripID")
        );
        startLocationCol.setCellValueFactory(
            new PropertyValueFactory<Trip,String>("startingDestination")
        );
        destinationCol.setCellValueFactory(
            new PropertyValueFactory<Trip,Integer>("endingDestination")
        );
        favouriteCol.setCellValueFactory(
            new PropertyValueFactory<Trip,String>("favouriteTrip")
        );

        data = FXCollections.observableArrayList();
        tripTbl.setItems(data);
    }    

    static long nextId = 1;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
//        Trip trip = new Trip();
//        trip.tripID.setValue(nextId++);
//        trip.startingDestination.setValue("Starting Destination " + trip.startingDestination.getValue());
//        trip.qty.setValue(10);
//        Float price = new Float(5.00 + (float)item.id.getValue());
//        trip.price.setValue( price.toString() );
//        data.add(trip);
//        
//        Item item = new Item();
//        item.id.setValue(nextId++);
//        item.name.setValue("Item Number " + item.id.getValue());
//        item.qty.setValue(10);
//        Float price = new Float(5.00 + (float)item.id.getValue());
//        item.price.setValue( price.toString() );
//        data.add(item);
    }
}
