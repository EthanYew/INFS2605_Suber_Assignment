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
public class Driver{
    private int driverid;
    private String emailaddress;
    private String password;
    private String name;
    private String carMake;
    private String carModel;
    private String bsb;
    private String accountNumber;
    
    //Constructor for "Driver"
    public Driver(String emailaddress, String password, String carMake, String carModel) throws SQLException{
        this.emailaddress = emailaddress;
        this.password = password;
        this.carMake = carMake;
        this.carModel = carModel;
    }
    
    //Login 
    public boolean LoginDriver() throws SQLException{
        assignment.database.Database.openConnection();
        Statement stmt = Database.database.createStatement();
        ResultSet result = stmt.executeQuery("SELECT emailaddress FROM driver");
        String resultEmailAddress = result.getString(emailaddress);
        ResultSet result1 = stmt.executeQuery("SELECT password FROM driver");
        String resultPassword = result.getString(password);
        if(this.emailaddress == resultEmailAddress && this.password == resultPassword){
            return true;
        }
        else{
            return false;
        }
    }
    //Getter methods to display these values
    public int getDriverId(){
        return this.driverid;
    }
    public String getEmailAddress(){
        return this.emailaddress;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public String getCarMake(){
        return this.carMake;
    }
    
    public String getCarModel(){
        return this.carModel;
    }
    
    public String getBsb(){
        return this.bsb;
    }
    
    public String getAccountNumber(){
        return this.accountNumber;
    }
    
    //Setter methods for these attributes
    public void setDriverId(int driverId){
        this.driverid = driverId;
    }
    public void setEmailAddress(String emailaddress){
        this.emailaddress = emailaddress;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public void setCarMake(String carMake){
        this.carMake = carMake;
    }
    
    public void setCarModel(String carModel){
        this.carModel = carModel;
    }
    
    public void setBsb(String bsb){
        this.bsb = bsb;
    }
    
    public void setAccountNumber(String accountNumber){
        this.accountNumber = accountNumber;
    }
    
    //Other methods for the Driver class
    public void editMemberProfile(){
        
    }
    
    public void editCarOffer(){
        
    }
    
    public void removeCarOffer(){
        
    }
    
    
}
