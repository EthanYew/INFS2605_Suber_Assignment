/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.classes;

import assignment.database.Database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author EthanYew
 */
public class Trip {

    public Trip() {
    }
    
    public Trip(SimpleIntegerProperty tripID, SimpleStringProperty startingDestination, SimpleStringProperty endingDestination) {
    }
    
    public SimpleIntegerProperty tripID = new SimpleIntegerProperty();
    SimpleIntegerProperty driverID = new SimpleIntegerProperty();
    SimpleIntegerProperty riderID = new SimpleIntegerProperty();
    SimpleStringProperty tripDate = new SimpleStringProperty();
    SimpleDoubleProperty cost = new SimpleDoubleProperty();
    SimpleStringProperty startingDestination = new SimpleStringProperty();
    SimpleStringProperty endingDestination = new SimpleStringProperty();

    SimpleBooleanProperty favouriteTrip = new SimpleBooleanProperty();

    public SimpleIntegerProperty getTripID() {

        try {
            Database.openConnection();
            Statement stmt = Database.database.createStatement();
            
            //DOUBLE CHECK SELECT STATEMENT @$##^$@$#^@%$%@%#^@%#@^%#^%@#@^#%$
            
            ResultSet result = stmt.executeQuery("SELECT TRIPID FROM TRIP;");
            if (result.next()) {
                System.out.println("Result found");
                
                this.tripID = new SimpleIntegerProperty(Integer.parseInt(result.getString("TRIPID")));
                                
                Database.closeConnection();
                
                return tripID;
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Trip.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return this.tripID;
    }

    public void setTripID(SimpleIntegerProperty tripID) {
        this.tripID = tripID;
    }

    public SimpleIntegerProperty getDriverID() {
        return driverID;
    }

    public void setDriverID(SimpleIntegerProperty driverID) {
        this.driverID = driverID;
    }

    public SimpleIntegerProperty getRiderID() {
        return riderID;
    }

    public void setRiderID(SimpleIntegerProperty riderID) {
        this.riderID = riderID;
    }

    public SimpleStringProperty getTripDate() {
        return tripDate;
    }

    public void setTripDate(SimpleStringProperty tripDate) {
        this.tripDate = tripDate;
    }

    public SimpleDoubleProperty getCost() {
        return cost;
    }

    public void setCost(SimpleDoubleProperty cost) {
        this.cost = cost;
    }

    public SimpleStringProperty getStartingDestination() {
        
        
        try {
            Database.openConnection();
            Statement stmt = Database.database.createStatement();
            
            //DOUBLE CHECK SELECT STATEMENT @$##^$@$#^@%$%@%#^@%#@^%#^%@#@^#%$
            
            ResultSet result = stmt.executeQuery("SELECT STARTINGDESTINATION FROM TRIP;");
            if (result.next()) {
                System.out.println("Result found");
                
                this.startingDestination = new SimpleStringProperty(result.getString("STARTINGDESTINATION"));
                                
                Database.closeConnection();
                
                return this.startingDestination;
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Trip.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return this.startingDestination;
    }

    public void setStartingDestination(SimpleStringProperty startingDestination) {
        this.startingDestination = startingDestination;
    }

    public SimpleStringProperty getEndingDestination() {
        
        try {
            Database.openConnection();
            Statement stmt = Database.database.createStatement();
            
            //DOUBLE CHECK SELECT STATEMENT @$##^$@$#^@%$%@%#^@%#@^%#^%@#@^#%$
            
            ResultSet result = stmt.executeQuery("SELECT ENDINGDESTINATION FROM TRIP;");
            if (result.next()) {
                System.out.println("Result found");
                
                this.startingDestination = new SimpleStringProperty(result.getString("ENDINGDESTINATION"));
                                
                Database.closeConnection();
                
                return this.endingDestination;
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Trip.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return this.endingDestination;
    }

    public void setEndingDestination(SimpleStringProperty endingDestination) {
        this.endingDestination = endingDestination;
    }

    public SimpleBooleanProperty getFavouriteTrip() {
        return favouriteTrip;
    }

    public void setFavouriteTrip(SimpleBooleanProperty favouriteTrip) {
        this.favouriteTrip = favouriteTrip;
    }

}
