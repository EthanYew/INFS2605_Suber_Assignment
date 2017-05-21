/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.classes;

/**
 *
 * @author victor
 */
public class Staff {    
    String name;
    String emailAddress;
    String password;
    int staffId;
    
    public Staff(int staffId, String name, String emailaddress, String password){
        this.staffId = staffId;
        this.name = name;
        this.emailAddress = emailaddress;
        this.password = password;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmailAddress() {
        return this.emailAddress;
        
    }
    
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
            
    public int getStaffId() {
        return this.staffId;
    }
    
    public void setID(int id) {
        this.staffId = id;
    }
    
    
    
    public void editMemberProfile() {
        
    }
    
    // Edit corporate member with consultancy
    
    public void editCorporateMemberWithConsultancy() {
        
    }
            
    public void addPotentialCustomer() {
        
    }
    
    public void downgradeConsultancy() {
        
    }
    
    public void editCorporateMemberWithoutConsultancy() {
        
    }
    
    public void createPotentialCorporateCustomer() {
        
    }
    
    public void createCorporateMember() {
        
    }
    
    public void editPotentialCorporateCustomer() {
        
    }
    
    public void createConsultancy() {
        
    }
    
    public void generateMailingList() {
        
    }
    
    public void viewAllOffers() {   //Might have to retrieve table, might have return data type
        
    }
    
    public void viewAllSeek() {  //Same as above
        
    }
    
    public void viewAllAgreement() {
        
    }
    
    public void removeAgreement() {
        
    }
    
    public void addMemberAccount() {
        
    }
    
    public void login() {
        
    }
    
    public void addStaffAccount() {
        
    }
    
    public void editStaffAccount() {
        
    } 
}
