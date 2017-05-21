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

/**
 *
 * @author AriSurfacePro
 */
public class Rider {
    private int riderId;
    private String emailaddress;
    private String password;
    private String name;
    private int creditCardNumber;
    private int cvc;
    
    
    public boolean LoginRider() throws SQLException{
        assignment.database.Database.openConnection();
        Statement stmt = Database.database.createStatement();
        ResultSet result = stmt.executeQuery("SELECT emailaddress FROM rider");
        String resultEmailAddress = result.getString(emailaddress);
        ResultSet result1 = stmt.executeQuery("SELECT password FROM rider");
        String resultPassword = result.getString(password);
        if(this.emailaddress == resultEmailAddress && this.password == resultPassword){
            return true;
        }
        else{
            return false;
        }
    }
}
