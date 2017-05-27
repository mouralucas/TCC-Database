/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBManager;

import Conn.Connection;
import entities.Movies;
import javax.persistence.EntityManager;

/**
 *
 * @author Jo
 */
public class MoviesDBM {

    public boolean insertBook(Movies movie) {
        try {
            Connection.getCon().merge(movie);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
