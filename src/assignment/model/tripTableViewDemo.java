import assignment.database.Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * 
 * @author Narayan
 */

public class tripTableViewDemo extends Application{

    //TABLE VIEW AND DATA
    private ObservableList<ObservableList> data;
    private TableView tableview;

    //MAIN EXECUTOR
    public static void main(String[] args) {
        launch(args);
    }

    //CONNECTION DATABASE
    public void buildData(){
          
          data = FXCollections.observableArrayList();
          try{
            Database.openConnection();
            Statement stmt = Database.database.createStatement();
            //SQL FOR SELECTING ALL OF CUSTOMER
            String SQL = "SELECT TRIPID, STARTINGDESTINATION, ENDINGDESTINATION FROM TRIP;";
            //ResultSet
            ResultSet rs = stmt.executeQuery(SQL);

            /**********************************
             * TABLE COLUMN ADDED DYNAMICALLY *
             **********************************/
            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
                //We are using non property style for making dynamic table
                final int j = i;                
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                
                col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                    public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {                                                                                              
                        return new SimpleStringProperty(param.getValue().get(j).toString());                        
                    }
                    
                });

                tableview.getColumns().addAll(col); 
                System.out.println("Column ["+i+"] ");
            }

            /********************************
             * Data added to ObservableList *
             ********************************/
            while(rs.next()){
                //Iterate Row
//                ObservableList<String> row = FXCollections.observableArrayList();
                ObservableList row = FXCollections.observableArrayList();
                
//                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
//                    //Iterate Column
//                    row.add(rs.getString(i));
//                }
                
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    //Iterate Column
                    String str=null;
                    if (rs.getString(i)==null){
                    str = "";
                    } else{
                    str = rs.getString(i);
                    }
                    row.add(str);
                }
                System.out.println("Row [1] added "+row );
                data.add(row);

            }

            //FINALLY ADDED TO TableView
            tableview.setItems(data);
          }catch(Exception e){
              e.printStackTrace();
              System.out.println("Error on Building Data");             
          }
          
          Database.closeConnection();
      }


      @Override
      public void start(Stage stage) throws Exception {
        //TableView
        tableview = new TableView();
        buildData();

        //Main Scene
        Scene scene = new Scene(tableview);        

        stage.setScene(scene);
        stage.show();
      }
}