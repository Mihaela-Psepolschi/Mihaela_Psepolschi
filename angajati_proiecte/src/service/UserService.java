/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.UserDao;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.User;


public class UserService {
       
    private EntityManagerFactory entityManagerFactory;
    private UserService() {
            this.entityManagerFactory = Persistence.createEntityManagerFactory("angajat_proiectePU");
    }
    
    public static UserService getInstance() {
        return UserServiceHolder.INSTANCE;
    }
    
    private static class UserServiceHolder {
        private static final UserService INSTANCE = new UserService();
    }
    

    public boolean register(User user){
        boolean result = false;
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        UserDao userDao = new UserDao(entityManager);
        try{
            Optional<User> optionalUser = userDao.findUser(user.getId());
            if(! optionalUser.isPresent()){
                entityManager.getTransaction().begin();
                userDao.addUser(user);
                entityManager.getTransaction().commit();
                result = true;
            }
        }finally{
            entityManager.close();
        }
        return result;
    }
    
      public Optional<User> login(int id, String username, String password){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        UserDao userDao = new UserDao(entityManager);
        try {
            Optional<User> optionalUser = userDao.findUser(id);
            if(optionalUser.isPresent()){
                if(optionalUser.get().getPassword().equals(password) & 
                        optionalUser.get().getUsername().equals(username)){
                    return optionalUser;
                }
            }                
        } finally{
            entityManager.close();
        }
        return Optional.empty();
    }
}
