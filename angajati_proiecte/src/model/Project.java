/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
        @NamedQuery(name = "Project.deleteProject", 
                    query = "DELETE FROM Project p WHERE p.id = :id"),
        @NamedQuery(name = "Project.showProjects", 
                    query = "SELECT p.name FROM Project p LEFT JOIN Employee e WHERE e.name = :name")
})
public class Project implements Serializable {
    
    @Id
    private int id;
    private String name;
    private Date start_date;
    
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false)
    private List<Employee> employees;
        

    public Project() {
    }

    public Project(String name, Date start_date) {
        this.name = name;
        this.start_date = start_date;
    }
    
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

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Project{" + "id=" + id + ", name=" + name + ", start_date=" + start_date + ", employees=" + employees + '}';
    }    

}
