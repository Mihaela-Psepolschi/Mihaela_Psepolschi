/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.Department;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author mihaela.psepolschi
 */
public class DepartmentDao {
    
    EntityManager entityManager;
    
    public DepartmentDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    
    public List<Department> getDepartment(int numberEmployees){
        String sql = "SELECT d FROM Department d WHERE d.numberEmployees > :number";
        TypedQuery<Department> query = entityManager.createQuery(sql, Department.class);
        query.setParameter("number", numberEmployees);
        return query.getResultList();
    }
    
}
