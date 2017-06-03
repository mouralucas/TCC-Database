/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    public boolean insertAuthors(Authors author) {
        try {
            Connection.getCon().merge(author);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /*-------------------- Retrieve Author Querys -------------------------*/
    public List retrieveAllAuthors(){
        return Connection.getCon().createQuery("SELECT a FROM Authors a "
                + "ORDER BY a.authorName").getResultList();
    }
    
    public List retrieveAuthorByName(String authorName) {
        return Connection.getCon().createQuery("SELECT a FROM Authors a "
                + "WHERE a.authorName LIKE CONCAT('%', :authorName, '%')")
                .setParameter("authorName", authorName)
                .getResultList();
    }
    
    /*---------------------- Remove Author Query --------------------------*/
        public void removeAuthor(Authors author) {
        try {
            Connection.getCon().remove(Connection.getCon().find(Authors.class, author.getAuthor_id()));
        } catch (Exception e) {
            Connection.getCon().getTransaction().rollback();
        }
    }
}
