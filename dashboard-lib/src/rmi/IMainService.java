/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import db.Department;
import db.Employee;
import db.Project;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author mihaela.psepolschi
 */
public interface IMainService extends Remote{
    
    public void addEmployee(Employee employee) throws RemoteException;
    public void deleteProject(Project project) throws RemoteException;
    public List<Project> getProjects() throws RemoteException;
    public List<Department> getDepartment(int numberEmployees) throws RemoteException;
    
}
