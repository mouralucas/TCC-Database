package DBManager;

import Conn.Connection;
import entities.Authors;
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

public class AuthorsDBM {

    /*---------------------- Insertion Author Query ------------------------*/
    public boolean insertAuthors(Authors author, Connection con) {
        try {
            con.getCon().merge(author);
            return true;
        } catch (Exception e) {
            con.getCon().getTransaction().rollback();
            return false;
        }
    }

    /*-------------------- Retrieve Author Querys -------------------------*/
    public List retrieveAllAuthors(Connection con){
        return con.getCon().createQuery("SELECT a FROM Authors a "
                + "ORDER BY a.authorName").getResultList();
    }
    
    public List retrieveAuthorByName(String authorName, Connection con) {
        return con.getCon().createQuery("SELECT a FROM Authors a "
                + "WHERE a.authorName LIKE CONCAT('%', :authorName, '%')")
                .setParameter("authorName", authorName)
                .getResultList();
    }
    
    /*---------------------- Remove Author Query --------------------------*/
        public void removeAuthor(Authors author, Connection con) {
        try {
            con.getCon().remove(con.getCon().find(Authors.class, author.getAuthor_id()));
        } catch (Exception e) {
            con.getCon().getTransaction().rollback();
        }
    }
}
