/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 *
 * @author EthanYew
 */
public class Main extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        FlowPane pane = new FlowPane();
        
        //TableView - easy way to display data 
        
        TableView<Student> tableView = new TableView();
        //tables generally ugly
        
        tableView.getColumns().clear();
        //get data
        ArrayList<Student> students = DatabaseQueries.getAllStudents();
        //can't put arraylist into table straight
        //observable arraylist - when u change data - auto changes into table for u
        //convert to observable list - like arraylist but can observe it, e.g. add listeners for change
        ObservableList<Student> data = FXCollections.observableArrayList(students);
        
        tableView.setItems(data);
        //make new column for filtering info - will appear on table as "Name"
        TableColumn<Student, String> nameColumn = new TableColumn("Name");
        
        //Cell vlaue factory -for ecah cell in that column - it knows exactly what to do
        
        //on each row what do i need to do for each cell in my columns - i.e. get name of student
        //arraylist of student data - set cell data to something - make new SimpleStringProperty 
        
        nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        
        TableColumn<Student, Double> wamColumn = new TableColumn("WAM");
        
        //when using tables don't use primitive type - i.e. double -> Double
        
        wamColumn.setCellValueFactory(cellData -> new SimpleStringProperty( String.valueOf(cellData.getValue().getWam()) );
        
        MISSING GET COLUMN STATEMENTS HERE
        
        tableView.getColumns()
        
        pane.getChildren().add(tableView);
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        
    }
}
