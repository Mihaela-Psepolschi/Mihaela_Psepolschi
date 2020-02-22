/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.Project;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author mihaela.psepolschi
 */
public class ProjectDao {
    
    EntityManager entityManager;
    
    public ProjectDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    
    public void deleteProject(Project project){
        project = entityManager.merge(project);
        entityManager.remove(project);
    }
    
    public List<Project> getProjects(){
        String sql = "SELECT p FROM Project p";
        TypedQuery<Project> query = entityManager.createQuery(sql, Project.class);
        return query.getResultList();
    }
    
}
