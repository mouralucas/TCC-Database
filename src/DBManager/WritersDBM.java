package DBManager;

import Conn.Connection;
import entities.Writers;
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

public class WritersDBM {

    /*---------------------- Insertion Writer Query ------------------------*/
    public boolean insertWriters(Writers writers) {
        try {
            Connection.getCon().merge(writers);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /*-------------------- Retrieve Writer Querys -------------------------*/
    public List retrieveAllWriters() {
        return Connection.getCon().createQuery("SELECT w FROM Writers w "
                + "ORDER BY w.writerName").getResultList();
    }

    public List retrieveDirectorByName(String writerName) {
        return Connection.getCon().createQuery("SELECT w FROM Writers w "
                + "WHERE w.writerName LIKE CONCAT('%', :writerName, '%')")
                .setParameter("writerName", writerName).getResultList();
    }

    /*---------------------- Remove Writer Query --------------------------*/
    public void removeWriter(Writers writer) {
        try {
            Connection.getCon().remove(Connection.getCon().find(Writers.class, writer.getWriter_id()));
        } catch (Exception e) {
            Connection.getCon().getTransaction().rollback();
        }
    }
}
