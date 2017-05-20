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
public class CorporateMember {
    private int corporateId;
    private String companyName;
    private String companyAddress;
    private long companyPhoneNumber;
    private boolean consultancy;
    
    public CorporateMember(int corporateId, String companyName, String companyAddress, long companyPhoneNumber, boolean consultancy){
        this.corporateId = corporateId;
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.companyPhoneNumber = companyPhoneNumber;
        this.consultancy = consultancy;
    }
    
    //Getter methods
    public int getCorporateId(){
        return this.corporateId;
    }
    
    public String companyName(){
        return this.companyAddress;
    }
    
    public long getCompanyPhoneNumber(){
        return this.companyPhoneNumber;
    }
    
    public boolean consultancy(){
        return this.consultancy;
    }
    
    //Setter Methods
    public void setCorporateId(int corporateId){
        this.corporateId = corporateId;
    }
    
    public void setCompanyName(String companyAddress){
        this.companyName = companyName;
    }
    
    public void setCompanyAddress(String companyAddress){
        this.companyAddress = companyAddress;
    }
    
    public void setCompanyPhoneNumber(int companyPhoneNumber){
        this.companyPhoneNumber = companyPhoneNumber;
    }
    
    public void setConsultancy(boolean consultancy){
        this.consultancy = consultancy;
    }
}
