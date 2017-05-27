/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conn;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Lucas
 */
public class Connection {

    private static EntityManagerFactory factory = null;
    private static EntityManager em = null;

    public static boolean setCon() {
        if (factory == null || em == null) {
            factory = Persistence.createEntityManagerFactory("mongo_PU");
            em = factory.createEntityManager();
            return true;
        }

        return false;
    }

    public static EntityManager getCon() {
        return em;
    }
    
    public static void closeCon(){
        em.close();
        factory.close();
    }
}
