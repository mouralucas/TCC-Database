package DBManager;

import Conn.Connection;
import entities.Genres;
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
public class GenresDBM {

    /*---------------------- Insertion Genre Query ------------------------*/
    public boolean insertGenres(Genres genre, Connection con) {
        try {
            con.getCon().merge(genre);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /*-------------------- Retrieve Genre Querys -------------------------*/
    public List retrieveAllGenres(Connection con) {
        return con.getCon().createQuery(
                "SELECT g FROM Genres g "
                + "ORDER BY g.genreName").getResultList();
    }

    public List retrieveGenreByName(String genreName, Connection con) {
        return con.getCon().createQuery(
                "SELECT g FROM Genres g "
                + "WHERE g.genreName LIKE CONCAT('%', :genreName, '%')")
                .setParameter("genreName", genreName).getResultList();
    }

    /*---------------------- Remove Genre Query --------------------------*/
    public void removeGenre(Genres genre, Connection con) {
        try {
            con.getCon().remove(con.getCon().find(Genres.class, genre.getGenre_id()));
        } catch (Exception e) {
            con.getCon().getTransaction().rollback();
        }
    }
}
