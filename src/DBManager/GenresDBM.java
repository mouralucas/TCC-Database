package DBManager;

import Conn.Connection;
import entities.Genres;
import entities.Languages;
import java.util.List;
import javax.persistence.EntityManager;

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
    public boolean insertGenres(Genres genre) {
        try {
            Connection.getCon().merge(genre);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /*-------------------- Retrieve Genre Querys -------------------------*/
    public List retrieveAllGenres() {
        return Connection.getCon().createQuery("SELECT g FROM Genres g "
                + "ORDER BY g.genreName").getResultList();
    }

    public List retrieveGenreByName(String genreName) {
        return Connection.getCon().createQuery("SELECT g FROM Genres g "
                + "WHERE g.genreName LIKE CONCAT('%', :genreName, '%')")
                .setParameter("genreName", genreName).getResultList();
    }

    /*---------------------- Remove Genre Query --------------------------*/
    public void removeGenre(Genres genre) {
        try {
            Connection.getCon().remove(Connection.getCon().find(Genres.class, genre.getGenre_id()));
        } catch (Exception e) {
            Connection.getCon().getTransaction().rollback();
        }
    }
}
