/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBManager;

import Conn.Connection;
import entities.Directors;
import entities.Writers;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Lucas
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
