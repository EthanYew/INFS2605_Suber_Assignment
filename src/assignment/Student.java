/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

/**
 *
 * @author EthanYew
 */
public class Student {
    private String name;
            private Double wam;

    public Student(String name, Double wam) {
        this.name = name;
        this.wam = wam;
    }

    public String getName() {
        return name;
    }

    public Double getWam() {
        return wam;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWam(Double wam) {
        this.wam = wam;
    }
            
            
}
