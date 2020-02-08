/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import model.Project;

public class ProjectDao {
    
    private final EntityManager entityManager;

    public ProjectDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    public void addProject(Project project){
        entityManager.persist(project);       
    }
    
    public void deleteProject(int projectId){
        Query query = entityManager.createNamedQuery("Project.deleteProject", Project.class);
        query.setParameter("id", projectId).executeUpdate();
    }
    
    public List<Project> getProjects(String name){
        TypedQuery<Project> query = entityManager.createNamedQuery("Project.showProjects", Project.class);
        query.setParameter("name", name);
        List<Project> projects = query.getResultList();
        return projects;
    }
    
}
