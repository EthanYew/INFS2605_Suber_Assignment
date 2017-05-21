/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.database;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
/**
 *
 * @author AriSurfacePro
 */

//PLEASE LEAVE COMMENTS BEHIND STATING WHETHER YOU HAVE CREATED THIS PART
public class DatabaseCreation{
    public static void main(String[] args)  throws SQLException{
        Database.openConnection();
        Statement stmt = Database.database.createStatement();
        stmt.execute("CREATE TABLE Driver(driverId INT, emailaddress VARCHAR(100), password VARCHAR(25), "
                + "name VARCHAR(50), carMake VARCHAR(25), carModel VARCHAR(50), bsb INT, accountNumber INT)");
           
        Database.closeConnection();
    }
}
