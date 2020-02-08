/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Employee implements Serializable {
    
    @Id
    private int id;
    private String name;
    private String phone;
    private String emailAddress;

    public Employee() {
    }

    public Employee(String name, String phone, String emailAddress) {
        this.name = name;
        this.phone = phone;
        this.emailAddress = emailAddress;
    }    
    
    @ManyToMany(mappedBy = "employees", cascade = CascadeType.ALL)
    private List<Project> projects;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", phone=" + phone + ", emailAddress=" + emailAddress + ", projects=" + projects + '}';
    }   
        
}
