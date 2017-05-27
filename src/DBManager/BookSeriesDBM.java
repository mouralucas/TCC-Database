/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBManager;

import Conn.Connection;
import entities.BookSeries;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Lucas
 */
public class BookSeriesDBM {

    /*---------------------- Insertion BookSerie Query ------------------------*/
    public boolean insertBookSeries(BookSeries bookSeries, EntityManager em) {
        try {
            em.merge(bookSeries);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /*-------------------- Retrieve BookSerie Querys -------------------------*/
    public List retrieveAllBookSeries() {
        return Connection.getCon().createQuery("SELECT bs FROM BookSeries bs "
                + "ORDER BY bs.bookSerieName")
                .getResultList();
    }

    public List retrieveBookSeriesByName(String bookSerieName) {
        return Connection.getCon().createQuery("SELECT bs FROM BookSeries bs "
                + "WHERE bs.bookSerieName LIKE CONCAT('%', :bookSerieName, '%')")
                .setParameter("bookSerieName", bookSerieName)
                .getResultList();
    }

    /*---------------------- Remove BookSerie Query --------------------------*/
    public void removeBookSerie(BookSeries bookSerie) {
        try {
            Connection.getCon().remove(Connection.getCon().find(BookSeries.class, bookSerie.getBookSerie_id()));
        } catch (Exception e) {
            Connection.getCon().getTransaction().rollback();
        }
    }
}
