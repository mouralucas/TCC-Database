package DBManager;

import Conn.Connection;
import entities.Actors;
import java.util.List;

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
    public boolean insertActors(Actors actor, Connection con) {
        try {
            con.getCon().merge(actor);
            return true;
        } catch (Exception e) {
            con.getCon().getTransaction().rollback();
            return false;
        }
    }

    /*-------------------- Retrieve Actros Querys -------------------------*/
    public List retrieveAllActors(Connection con) {
        return con.getCon().createQuery(
                "SELECT ac FROM Actors ac "
                + "ORDER BY ac.actorName").getResultList();
    }

    public List retrieveDirectorByName(String actorName, Connection con) {
        return con.getCon().createQuery(
                "SELECT ac FROM Actors ac "
                + "WHERE ac.actorName LIKE CONCAT('%', :actorName, '%')")
                .setParameter("writerName", actorName).getResultList();
    }

    /*---------------------- Remove Writer Query --------------------------*/
    public void removeWriter(Actors actor, Connection con) {
        try {
            con.getCon().remove(con.getCon().find(Actors.class, actor.getActor_id()));
        } catch (Exception e) {
            con.getCon().getTransaction().rollback();
        }
    }

}
