package assignment.database;

import assignment.database.Database;
import java.sql.ResultSet;
import java.sql.Statement;

import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author EthanYew
 */
public class DatabaseDemo {

    public static void main(String[] args) throws SQLException {
        Database.openConnection();
        //once u open connection u add create statement
        Statement stmt = Database.database.createStatement();
        
        //create and insert for student table
//        stmt.execute("CREATE TABLE student(name VARCHAR(50), wam DOUBLE);");
        

        
        //gives object that u run queries against, 
        //statement is not actual sql statement but u put sql statement in here and it runs it
        //3 kinds of statements: execute, executeUpdate, executeQuery
        //create - execute
        //update - executeUpdate
        //get something from table - executeQuery
        //SQL grammar speccific to derby or h2
        //some differences between oracle and h2 
        //1. Create table
        //stmt.execute("CREATE TABLE SampleTable(cars VARCHAR(50), profession VARCHAR(50))");
        //once create tbale statement run comment out
        //2. Insert values into table
//        stmt.execute("INSERT INTO SampleTable VALUES('Car', 'Job');");
        //3. Update table
//        int n = stmt.executeUpdate("UPDATE sampleTable SET cars = 'Ferrari' WHERE profession = 'Job'");
//        System.out.println(n);
        //executeUpdate tells  u how many rows have been updated
        //when u query something - u get back a resultset
        ResultSet result = stmt.executeQuery("SELECT * FROM sampleTable");

        System.out.println(result);
        while (result.next()) {
            String car = result.getString("cars");
            String jobs = result.getString("profession");
            System.out.println(car + " | " + jobs);

            //when u do results table query, reading from top left corner - goes left
            //when u return it its like a buffer, how many rows of info, how many columns
            //position tells u at what point in ur file is it reading it, -1 means hasn't started reading it
            //keyword to reading it 
            //get string - gets varchar and put into variable
        }

        Database.closeConnection();

    }
}
