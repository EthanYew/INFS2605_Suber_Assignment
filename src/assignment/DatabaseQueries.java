/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author EthanYew
 */
public class DatabaseQueries {
    public static void inserStudent(Student student) throws SQLException{
        Database.openConnection();
        //once u open connection u add create statement
        Statement stmt = Database.database.createStatement();
        stmt.execute("INSERT INTO Students VALUES('" + student.getName() + "', " + student.getWam() + ");");
        Database.closeConnection();
    }
    
    
    //don't throw sqlexception in assdignment - use try catch
    
    
    public static ArrayList<Student> getAllStudents() throws SQLException{
        Database.openConnection();
        //once u open connection u add create statement
        Statement stmt = Database.database.createStatement();
        ResultSet result = stmt.executeQuery("SELECT * FROM students");
                ArrayList<Student> students = new ArrayList<>();
                
                while(result.next()){
                    String name = result.getString("name");
                    Double wam = result.getDouble("wam");
                    Student student = new Student(name, wam);
                    Student.add(student);
                    
                }
                Database.closeConnection();
                return stmt;
    }
}
