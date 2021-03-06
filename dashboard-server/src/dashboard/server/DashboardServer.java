/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboard.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.MainService;

/**
 *
 * @author mihaela.psepolschi
 */
public class DashboardServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(4444);
            registry.rebind("server", new MainService());
        } catch (RemoteException ex) {
            Logger.getLogger(DashboardServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
