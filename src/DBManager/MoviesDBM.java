package DBManager;

import Conn.Connection;
import entities.Movies;
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
public class MoviesDBM {

    /*----------------------- Insertion Movie Query -------------------------*/
    public boolean insertMovie(Movies movie, Connection con) {
        try {
            con.getCon().merge(movie);
            return true;
        } catch (Exception e) {
            con.getCon().getTransaction().rollback();
            return false;
        }
    }

    /*-------------------------Retrieve Movie Query -------------------------*/
    public List retrieveAllMovies(Connection con) {
        return con.getCon().createQuery("SELECT m FROM Movies m "
                + "ORDER BY m.movieTitle").getResultList();
    }

//    public List retrieveSomeMovies(Connection con, int qtdMovies, int min, int max){
//        return con.getCon().createQuery("SELECT m FROM Movies m WHERE m.movie_id > :min AND m.movie_id < :max")
//                .setParameter("min", min).setParameter("max", max).getResultList();
//    }
    
    public List retrieveSomeMovies(Connection con, int randonId, int ops) {
        return con.getCon().createQuery("SELECT m FROM Movies m WHERE m.movie_id > :randonId AND m.movie_id < :ops")
                .setParameter("randonId", randonId).setParameter("ops", ops).getResultList();
    }

    public List retrieveMovieByTitle(String movieTitle, Connection con) {
        return con.getCon().createQuery("SELECT m FROM Movies m "
                + "WHERE m.movieTitle LIKE CONCAT('%',:movieTitle,'%')")
                .setParameter("movieTitle", movieTitle).getResultList();
    }

    public List retrieveMovieByMultipleValues(String title, String director, String writer, String actor, String network, String book,
            Connection con) {
        return con.getCon().createQuery("SELECT "
                + "m.movieTitle, m.movieLenght, a.actorName, d.directorName, w.writerName, n.networkName, b.bookTitle "
                + "FROM Movies m "
                + "INNER JOIN m.movieActors a "
                + "INNER JOIN m.movieDirector d "
                + "INNER JOIN m.movieWriters w "
                + "INNER JOIN m.movieNetworks n "
                + "INNER JOIN m.movieBooks b "
                + "WHERE "
                + "m.movieTitle LIKE CONCAT('%',:movieTitle,'%') OR "
                + "a.actorName LIKE CONCAT('%',:actorName,'%') OR "
                + "d.directorName LIKE CONCAT('%',:directorName,'%') OR "
                + "w.writerName LIKE CONCAT('%',:writerName,'%') OR "
                + "n.networkName LIKE CONCAT('%',:networkName,'%') OR "
                + "b.bookTitle LIKE CONCAT('%',:bookTitle,'%')")
                .setParameter("movieTitle", title)
                .setParameter("actorName", actor)
                .setParameter("directorName", director)
                .setParameter("writerName", writer)
                .setParameter("networkName", network)
                .setParameter("bookTitle", book)
                .getResultList();
    }

    /*------------------------- Remove Movie Query --------------------------*/
    public void removeMovie(Movies movie, Connection con) {
        try {
            con.getCon().remove(con.getCon().find(Movies.class, movie.getMovie_id()));
        } catch (Exception e) {
            con.getCon().getTransaction().rollback();
        }
    }
}
