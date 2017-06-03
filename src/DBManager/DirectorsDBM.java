/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBManager;

import Conn.Connection;
import entities.Directors;
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

public class DirectorsDBM {

    /*---------------------- Insertion Director Query ------------------------*/
    public boolean insertDirectors(Directors directors) {
        try {
            Connection.getCon().merge(directors);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /*-------------------- Retrieve Director Querys -------------------------*/
    public List retrieveAllDirectors() {
        return Connection.getCon().createQuery("SELECT d FROM Directors d "
                + "ORDER BY d.directorName").getResultList();
    }

    public List retrieveDirectorByName(String directorName) {
        return Connection.getCon().createQuery("SELECT d FROM Directors d "
                + "WHERE d.directorName LIKE CONCAT('%', :directorName, '%')")
                .setParameter("directorName", directorName).getResultList();
    }

    /*---------------------- Remove Director Query --------------------------*/
    public void removeGenre(Directors director) {
        try {
            Connection.getCon().remove(Connection.getCon().find(Directors.class, director.getDirector_id()));
        } catch (Exception e) {
            Connection.getCon().getTransaction().rollback();
        }
    }
}
