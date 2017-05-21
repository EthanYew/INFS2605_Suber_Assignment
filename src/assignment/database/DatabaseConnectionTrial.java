/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.database;

/**
 *
 * @author Ajay Matta
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class DatabaseConnectionTrial {

    public static void main(String a[]) {
        Connection con = null;
        try {
           //Class.forName("oracle.jdbc.driver.OracleDriver");
            //con = DriverManager.getConnection("jdbc:oracle:thin:sage.business.unsw.edu.au:1521:orcl01", "Y16GROUP120", "infs2605");
            //System.out.println("Connection working");
    Statement stmt = con.createStatement();
           //Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
             //       ResultSet.CONCUR_UPDATABLE);
                    stmt.executeUpdate("insert into driver values (1,timmy, timmy@example.com, tim123, toyota, corolla, 5, 123456, 1005612345)");
            //ResultSet rs = stmt.executeQuery("select * from driver");

            //rs.absolute(1); 

 

//System.out.println(rs.getInt(1)+" "+rs.getString(2));  
  



            /*            ResultSet rs = stmt.executeQuery("select * from driver");
            rs.absolute(1);
            System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));*/
        } catch (Exception e) {
            System.out.println("connection not working");
        }
    }
}
