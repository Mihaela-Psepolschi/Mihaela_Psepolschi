/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controller.ClientController;
import db.Project;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author mihaela.psepolschi
 */
public class ProjectFrame extends javax.swing.JFrame {
    
    private DefaultListModel<Project> model;

    public ProjectFrame() {
        initComponents();
        
        model = new DefaultListModel<>();
        jList1.setModel(model);
        
        jList1.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent event){
                if(event.getClickCount() == 2){
                    try {
                        Project project = jList1.getSelectedValue();
                        ClientController.getInstance().deleteProject(project);
                        JOptionPane.showMessageDialog(null, "An employee was deleted.");
                        showProjects();
                    } catch (RemoteException ex) {
                        JOptionPane.showMessageDialog(null, "We have a problem with server connection.");
                    }
                }
            }
        });
        
        showProjects();
        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private void showProjects(){
        try {
            List<Project> projects = ClientController.getInstance().getProjects();
            model.clear();
            projects.forEach(model::addElement);
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(null, "We have a problem with server connection.");
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<db.Project> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
