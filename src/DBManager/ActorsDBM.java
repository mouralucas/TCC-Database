package DBManager;

import Conn.Connection;
import entities.Actors;
import entities.Writers;
import java.util.List;
import javax.persistence.EntityManager;

/**
 * @author Jociane Franzoni de Lima
 * @author Lucas Penha de Moura
 *
 * ------------------- Trabalho de Conclusão de Curso ---------------------
 * ---------------------- Engenharia de Computação ------------------------
 * ------------- Universidade Tecnológica Federal do Paraná ---------------
 *
 */

public class ActorsDBM {

    /*---------------------- Insertion Actros Query ------------------------*/
    public boolean insertActors(Actors actor) {
        try {
            Connection.getCon().merge(actor);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /*-------------------- Retrieve Actros Querys -------------------------*/
    public List retrieveAllActors() {
        return Connection.getCon().createQuery("SELECT ac FROM Actors ac "
                + "ORDER BY ac.actorName").getResultList();
    }

    public List retrieveDirectorByName(String actorName) {
        return Connection.getCon().createQuery("SELECT ac FROM Actors ac "
                + "WHERE ac.actorName LIKE CONCAT('%', :actorName, '%')")
                .setParameter("writerName", actorName).getResultList();
    }

    /*---------------------- Remove Writer Query --------------------------*/
    public void removeWriter(Actors actor) {
        try {
            Connection.getCon().remove(Connection.getCon().find(Actors.class, actor.getActor_id()));
        } catch (Exception e) {
            Connection.getCon().getTransaction().rollback();
        }
    }

}
