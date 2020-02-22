/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.DepartmentDao;
import dao.EmployeeDao;
import dao.ProjectDao;
import db.Department;
import db.Employee;
import db.Project;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import rmi.IMainService;

/**
 *
 * @author mihaela.psepolschi
 */
public class MainService extends UnicastRemoteObject implements IMainService{
    
    EntityManagerFactory entityManagerFactory;
    
    public MainService() throws RemoteException{
        entityManagerFactory = Persistence.createEntityManagerFactory("dashboard-serverPU");
    }

    @Override
    public void addEmployee(Employee employee){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EmployeeDao employeeDao = new EmployeeDao(entityManager);
        try{
            entityManager.getTransaction().begin();
            employeeDao.addEmployee(employee);  
            entityManager.getTransaction().commit();
        }finally{
            entityManager.close();            
        }
    }

    @Override
    public void deleteProject(Project project){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        ProjectDao projectDao = new ProjectDao(entityManager);
        try{
            entityManager.getTransaction().begin();
            projectDao.deleteProject(project);
            entityManager.getTransaction().commit();
        }finally{
            entityManager.close();            
        }
    }

    @Override
    public List<Project> getProjects(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        ProjectDao projectDao = new ProjectDao(entityManager);
        try{
            return projectDao.getProjects();
        }finally{
            entityManager.close();            
        }
    }

    @Override
    public List<Department> getDepartment(int numberEmployees){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        DepartmentDao departmentDao = new DepartmentDao(entityManager);
        try{
            return departmentDao.getDepartment(numberEmployees);
        }finally{
            entityManager.close();            
        }
    }
    
}
