package DBManager;

import Conn.Connection;
import entities.BookSeries;
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

public class BookSeriesDBM {

    /*---------------------- Insertion BookSerie Query ------------------------*/
    public boolean insertBookSeries(BookSeries bookSeries, Connection con) {
        try {
            con.getCon().merge(bookSeries);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /*-------------------- Retrieve BookSerie Querys -------------------------*/
    public List retrieveAllBookSeries(Connection con) {
        return con.getCon().createQuery("SELECT bs FROM BookSeries bs "
                + "ORDER BY bs.bookSerieName")
                .getResultList();
    }

    public List retrieveBookSeriesByName(String bookSerieName, Connection con) {
        return con.getCon().createQuery("SELECT bs FROM BookSeries bs "
                + "WHERE bs.bookSerieName LIKE CONCAT('%', :bookSerieName, '%')")
                .setParameter("bookSerieName", bookSerieName)
                .getResultList();
    }

    /*---------------------- Remove BookSerie Query --------------------------*/
    public void removeBookSerie(BookSeries bookSerie, Connection con) {
        try {
            con.getCon().remove(con.getCon().find(BookSeries.class, bookSerie.getBookSerie_id()));
        } catch (Exception e) {
            con.getCon().getTransaction().rollback();
        }
    }
}
