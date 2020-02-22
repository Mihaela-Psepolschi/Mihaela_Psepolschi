/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.Department;
import db.Employee;
import db.Project;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import rmi.IMainService;

/**
 *
 * @author mihaela.psepolschi
 */
public class ClientController {
    
    private IMainService iMainService;
    
    private ClientController() {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost",4444);
            iMainService = (IMainService) registry.lookup("server");
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public static ClientController getInstance() {
        return ClientControllerHolder.INSTANCE;
    }
    
    private static class ClientControllerHolder {
        private static final ClientController INSTANCE = new ClientController();
    }
    
    public void addEmployee(Employee employee) throws RemoteException{
        iMainService.addEmployee(employee); 
    }
    
    public void deleteProject(Project project) throws RemoteException{
        iMainService.deleteProject(project);
    }
    
    public List<Project> getProjects() throws RemoteException{
        return iMainService.getProjects();
    }
    
    public List<Department> getDepartments(int numberEmployees) throws RemoteException{
        return iMainService.getDepartment(numberEmployees);
    }
}
