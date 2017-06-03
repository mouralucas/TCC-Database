package Conn;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Jociane Franzoni de Lima
 * @author Lucas Penha de Moura
 *
 * ------------------- Trabalho de Conclusão de Curso ---------------------
 * ---------------------- Engenharia de Computação ------------------------
 * ------------- Universidade Tecnológica Federal do Paraná ---------------
 *
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
