/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBManager;
/**
 *
 * @author Lucas e Jociane
 */


import Conn.Connection;
import entities.Users;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

public class UserDBM {

//    private EntityManagerFactory factory = Persistence
//            .createEntityManagerFactory("NewLibraryWeb_PU");
//    private EntityManager em = factory.createEntityManager();
    
//    boolean con = Connection.setCon();
    EntityManager em = Connection.getCon(); 
    

    public Users getUser(String userName, String password) {
        
        
        try {
            Users usuario = (Users) em
                    .createQuery(
                            "SELECT u from Users u where u.nomeUsuario = :name and u.senha = :senha")
                    .setParameter("name", userName)
                    .setParameter("senha", password).getSingleResult();

            return usuario;
        } catch (NoResultException e) {
            return null;
        }
    }

    public boolean insertUser(Users user) {
        try {
            em.persist(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean removeUser(Users user) {
        try {
            em.remove(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
