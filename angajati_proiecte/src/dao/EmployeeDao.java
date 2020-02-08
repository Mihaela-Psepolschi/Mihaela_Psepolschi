/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.Employee;

/**
 *
 * @author Alex
 */
public class EmployeeDao {
    
    EntityManager entityManager;

    public EmployeeDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    public void addEmployee(Employee employee){
        entityManager.persist(this);
    }
    
    public long getNumberOfEmployees(String name){
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        final Root<Employee> employee = criteriaQuery.from(Employee.class);
        criteriaQuery.select(criteriaBuilder.count(employee));
        criteriaQuery.where(criteriaBuilder.equal(employee.get("name"), name));
        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }
    
    public void deleteEmployee(int employeeId){
        String sql = "DELETE FROM Employee e WHERE e.id = :id";
        Query query = entityManager.createQuery(sql);
        query.setParameter("id", employeeId);
        query.executeUpdate();
    }
    
}
