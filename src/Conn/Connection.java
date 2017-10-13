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

    private  EntityManagerFactory factory = null;
    private  EntityManager em = null;

    public boolean setCon() {
        Persistence p = new Persistence();
        if (factory == null || em == null) {
            factory = p.createEntityManagerFactory("mysql_PU");
            em = factory.createEntityManager();
            return true;
        }

        return false;
    }

    public EntityManager getCon() {
        return em;
    }
    
    public void closeCon(){
        em.close();
        factory.close();
        System.out.println("Connection Done");
    }
}
