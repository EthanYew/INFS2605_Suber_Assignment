/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Ethan
 */
public class Database {

    public static Connection database;
    public static String databaseString = "jdbc:h2:./sampleDB;create=true";

    public static void setDatabase(String database) {
        Database.databaseString = database;

    }

    public static void openConnection() {
        try {
            database = DriverManager.getConnection(databaseString);
            System.out.println("Connected to database" + databaseString);

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        
    }
    }

    public static void closeConnection() {
        try {
            if (database != null) {
                database.close();
            }
            System.out.println("Disconnected from database" + databaseString);

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}