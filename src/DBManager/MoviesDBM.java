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

    public List retrieveOneJoin(String movieTitle, String director,
            String writer, String actor, String network, String book, Connection con) {

        return con.getCon().createQuery(
                "SELECT m.movieTitle, "
                + "d.directorName "
                + "FROM Movies m "
                + "LEFT JOIN m.movieDirector d "
                + "WHERE m.movieTitle LIKE CONCAT('%',:movieTitle,'%') AND "
                + "d.directorName LIKE CONCAT('%',:director,'%') ")
                .setParameter("movieTitle", movieTitle)
                .setParameter("director", director)
                .getResultList();
    }

    public List retrieveTwoJoins(String movieTitle, String director,
            String writer, String actor, String network, String book, Connection con) {

        return con.getCon().createQuery(
                "SELECT m.movieTitle, "
                + "d.directorName, "
                + "w.writerName "
                + "FROM Movies m "
                + "LEFT JOIN m.movieDirector d "
                + "LEFT JOIN m.movieWriters w "
                + "WHERE m.movieTitle LIKE CONCAT('%',:movieTitle,'%') OR "
                + "d.directorName LIKE CONCAT('%',:director,'%') OR "
                + "w.writerName LIKE CONCAT('%',:writer,'%') ")
                .setParameter("movieTitle", movieTitle)
                .setParameter("director", director)
                .setParameter("writer", writer)
                .getResultList();
    }

    public List retrieveThreeJoins(String movieTitle, String director,
            String writer, String actor, String network, String book, Connection con) {

        return con.getCon().createQuery(
                "SELECT m.movieTitle, "
                + "d.directorName, "
                + "w.writerName, "
                + "a.actorName "
                + "FROM Movies m "
                + "LEFT JOIN m.movieDirector d "
                + "LEFT JOIN m.movieWriters w "
                + "LEFT JOIN m.movieActors a "
                + "WHERE m.movieTitle LIKE CONCAT('%',:movieTitle,'%') OR "
                + "d.directorName LIKE CONCAT('%',:director,'%') OR "
                + "w.writerName LIKE CONCAT('%',:writer,'%') OR "
                + "a.actorName LIKE CONCAT('%',:actor,'%')")
                .setParameter("movieTitle", movieTitle)
                .setParameter("director", director)
                .setParameter("writer", writer)
                .setParameter("actor", actor)
                .getResultList();
    }

    public List retrieveFourJoins(String movieTitle, String director,
            String writer, String actor, String network, String book, Connection con) {

        return con.getCon().createQuery(
                "SELECT m.movieTitle, "
                + "d.directorName, "
                + "w.writerName, "
                + "a.actorName, "
                + "n.networkName "
                + "FROM Movies m "
                + "LEFT JOIN m.movieDirector d "
                + "LEFT JOIN m.movieWriters w "
                + "LEFT JOIN m.movieActors a "
                + "LEFT JOIN m.movieNetworks n "
                + "WHERE m.movieTitle LIKE CONCAT('%',:movieTitle,'%') OR "
                + "d.directorName LIKE CONCAT('%',:director,'%') OR "
                + "w.writerName LIKE CONCAT('%',:writer,'%') OR "
                + "a.actorName LIKE CONCAT('%',:actor,'%') OR "
                + "n.networkName LIKE CONCAT('%',:network,'%')")
                .setParameter("movieTitle", movieTitle)
                .setParameter("director", director)
                .setParameter("writer", writer)
                .setParameter("actor", actor)
                .setParameter("network", network)
                .getResultList();
    }

    public List retrieveFiveJoins(String movieTitle, String director,
            String writer, String actor, String network, String book, Connection con) {

        return con.getCon().createQuery(
                "SELECT m.movieTitle, "
                + "d.directorName, "
                + "w.writerName, "
                + "a.actorName, "
                + "n.networkName, "
                + "b.bookTitle "
                + "FROM Movies m "
                + "LEFT JOIN m.movieDirector d "
                + "LEFT JOIN m.movieWriters w "
                + "LEFT JOIN m.movieActors a "
                + "LEFT JOIN m.movieNetworks n "
                + "LEFT JOIN m.movieBooks b "
                + "WHERE m.movieTitle LIKE CONCAT('%',:movieTitle,'%') OR "
                + "d.directorName LIKE CONCAT('%',:director,'%') OR "
                + "w.writerName LIKE CONCAT('%',:writer,'%') OR "
                + "a.actorName LIKE CONCAT('%',:actor,'%') OR "
                + "n.networkName LIKE CONCAT('%',:network,'%') OR "
                + "b.bookTitle LIKE CONCAT('%',:book,'%')")
                .setParameter("movieTitle", movieTitle)
                .setParameter("director", director)
                .setParameter("writer", writer)
                .setParameter("actor", actor)
                .setParameter("network", network)
                .setParameter("book", book)
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
