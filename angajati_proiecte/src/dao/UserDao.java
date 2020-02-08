/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.User;


public class UserDao {
    
    private final EntityManager entityManager;

    public UserDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    public void addUser(User user){
        entityManager.persist(user);       
    }
    
      public Optional<User> findUser(int userId) {        
        return Optional.of(entityManager.find(User.class, userId));
    }
      
    public void deleteUser(int userId){
        User userToBeRemoved = entityManager.find(User.class, userId);
        if(userToBeRemoved != null){
            entityManager.remove(userId);
        }
    }
    
    public void updateUserPassword(int userId, String password){
        String sql = "UPDATE User u SET u.password = :password WHERE u.id = :id";
        Query query = entityManager.createQuery(sql, User.class);
        query.setParameter("password", password);
        query.setParameter("id", userId);
        query.executeUpdate();
    }
    
}
