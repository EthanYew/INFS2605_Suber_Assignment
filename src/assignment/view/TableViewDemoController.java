/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.view;

import assignment.classes.Trip;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author EthanYew
 */
public class TableViewDemoController extends Application implements Initializable {
    
    public static void main(String[] args) {
        launch(args);
    }

    @FXML
    private TableView<Trip> tripTbl = new TableView<Trip>();
    
    private ObservableList<Trip> data =
        FXCollections.observableArrayList(
//                new Trip(Trip.getTripID(), Trip.getStartingDestination(), Trip.getEndingDestination())
//            new TableViewSample.Person("Jacob", "Smith", "jacob.smith@example.com"),
//            new TableViewSample.Person("Isabella", "Johnson", "isabella.johnson@example.com"),
//            new TableViewSample.Person("Ethan", "Williams", "ethan.williams@example.com"),
//            new TableViewSample.Person("Emma", "Jones", "emma.jones@example.com"),
//            new TableViewSample.Person("Michael", "Brown", "michael.brown@example.com")
        );
    
    @FXML
    private TableColumn<?, ?> tripIDCol;
    @FXML
    private TableColumn<?, ?> startLocCol;
    @FXML
    private TableColumn<?, ?> endDestCol;
    
    
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Trip Table View Demo");
//        stage.setWidth(450);
//        stage.setHeight(500);

        final Label label = new Label("Available Trips");
        label.setFont(new Font("Arial", 20));
        
        tripTbl.setEditable(true);
        
        TableColumn tripIDCol = new TableColumn("TripID");
        tripIDCol.setCellValueFactory(
                new PropertyValueFactory<Trip, Integer>("tripID"));
        
        TableColumn startLocCol = new TableColumn("Starting Location");
        startLocCol.setCellValueFactory(
                new PropertyValueFactory<Trip, String>("startingDestination"));
        
        TableColumn endDestCol = new TableColumn("Ending Destination");
        endDestCol.setCellValueFactory(
                new PropertyValueFactory<Trip, String>("endingDestination"));
        
        tripTbl.setItems(data);
        tripTbl.getColumns().addAll(tripIDCol, startLocCol, endDestCol);
        
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, tripTbl);
 
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
 
        stage.setScene(scene);
        stage.show();
        
    }
    
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    
}
