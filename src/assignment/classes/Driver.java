/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.classes;

/**
 *
 * @author AriSurfacePro
 */
public class Driver {
    private String emailaddress;
    private String password;
    private String name;
    private String carMake;
    private String carModel;
    
    //Constructor for "Driver"
    public Driver(String emailaddress, String password, String carMake, String carModel){
        this.emailaddress = emailaddress;
        this.password = password;
        this.carMake = carMake;
        this.carModel = carModel;
    }
    
    //Getter methods to display these values
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
    
    //Setter methods for these attributes
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
    
    //Other methods for the Driver class
    public void editMemberProfile(){
        
    }
    
    public void editCarOffer(){
        
    }
    
    public void removeCarOffer(){
        
    }
    
    
}
