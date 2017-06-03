package DBManager;

import Conn.Connection;
import entities.Publishers;
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

public class PublishersDBM {

    /*---------------------- Insertion Publisher Query ------------------------*/
    public boolean insertPublishers(Publishers publisher) {
        try {
            Connection.getCon().merge(publisher);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /*-------------------- Retrieve Publisher Querys -------------------------*/
    public List retrieveAllPublishers() {
        return Connection.getCon().createQuery("SELECT p FROM Publishers p "
                + "ORDER BY p.publisherName")
                .getResultList();
    }

    public List retrievePublisherByName(String publisherName) {
        return Connection.getCon().createQuery("SELECT p FROM Publishers p "
                + "WHERE p.publisherName LIKE CONCAT('%', :publisherName, '%')")
                .setParameter("publisherName", publisherName).getResultList();
    }

    /*---------------------- Remove Publisher Query --------------------------*/
    public void removePublisher(Publishers publisher) {
        try {
            Connection.getCon().remove(Connection.getCon().find(Publishers.class, publisher.getPublisher_id()));
        } catch (Exception e) {
            Connection.getCon().getTransaction().rollback();
        }
    }
}
