/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.Employee;
import javax.persistence.EntityManager;

/**
 *
 * @author mihaela.psepolschi
 */
public class EmployeeDao {
    EntityManager entityManager;
    
    public EmployeeDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    
    public void addEmployee(Employee employee){
        entityManager.persist(employee);
    }
}
