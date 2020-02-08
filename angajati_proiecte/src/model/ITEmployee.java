/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Entity;


@Entity
public class ITEmployee extends Employee implements Serializable{
    
    String mainTechnology;

    public String getMainTechnology() {
        return mainTechnology;
    }

    public void setMainTechnology(String mainTechnology) {
        this.mainTechnology = mainTechnology;
    }
    
    
}
