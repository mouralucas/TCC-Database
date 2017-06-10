package t_Inserts;

import Conn.Connection;
import DBManager.ActorsDBM;
import DBManager.BooksDBM;
import DBManager.CountriesDBM;
import DBManager.DirectorsDBM;
import DBManager.GenresDBM;
import DBManager.LanguagesDBM;
import DBManager.MoviesDBM;
import DBManager.NetworksDBM;
import DBManager.WritersDBM;
import entities.Actors;
import entities.Books;
import entities.Countries;
import entities.Directors;
import entities.Genres;
import entities.Languages;
import entities.Movies;
import entities.Networks;
import entities.Writers;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;
import t_files.OpenTestFiles;

/**
 * @author Jociane Franzoni de Lima
 * @author Lucas Penha de Moura
 *
 * ------------------- Trabalho de Conclusão de Curso ---------------------
 * ---------------------- Engenharia de Computação ------------------------
 * ------------- Universidade Tecnológica Federal do Paraná ---------------
 *
 */
public class TestInsertMovie100 extends AbstractJavaSamplerClient implements Serializable {

    OpenTestFiles openTestFiles = new OpenTestFiles();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    private final int testSize = 100;

    Movies movies;

    MoviesDBM mdbm = new MoviesDBM();
    DirectorsDBM ddbm = new DirectorsDBM();
    CountriesDBM cdbm = new CountriesDBM();
    LanguagesDBM ldbm = new LanguagesDBM();
    WritersDBM wdbm = new WritersDBM();
    GenresDBM gdbm = new GenresDBM();
    ActorsDBM acdbm = new ActorsDBM();
    NetworksDBM ndbm = new NetworksDBM();
    BooksDBM bkdbm = new BooksDBM();

    Random r = new Random();

    Directors director;
    Countries country;
    Languages language;
    List<Writers> writers = new ArrayList<>();
    List<Genres> genres = new ArrayList<>();
    List<Actors> actors = new ArrayList<>();
    List<Networks> networks = new ArrayList<>();
    List<Books> books = new ArrayList<>();

    List<String[]> inserts = new ArrayList<>();

    @Override
    public SampleResult runTest(JavaSamplerContext jsc) {
        SampleResult result = new SampleResult();
        inserts = openTestFiles.open("insert\\insertMovies", testSize);

        Connection con = new Connection();
        con.setCon();

        List<Directors> listDirectors = ddbm.retrieveAllDirectors(con);
        List<Countries> listCountries = cdbm.retrieveAllCountries(con);
        List<Languages> listLanguages = ldbm.retrieveAllLanguages(con);
        List<Writers> listWrites = wdbm.retrieveAllWriters(con);
        List<Genres> listGenrres = gdbm.retrieveAllGenres(con);
        List<Actors> listActors = acdbm.retrieveAllActors(con);
        List<Networks> listNetworks = ndbm.retrieveAllNetwork(con);
//        List<Books> listBooks = bkdbm.retrieveAllBooks(con);

        result.sampleStart();
        con.getCon().getTransaction().begin();
        con.getCon().flush();
        con.getCon().clear();
        inserts.forEach((iteration) -> {

            listDirectors.forEach((i) -> {
                if (iteration[5].equals(i.getDirectorName())) {
                    director = i;
                }
            });

            listCountries.forEach((i) -> {
                if (iteration[6].equals(i.getCountryName())) {
                    country = i;
                }
            });

            listLanguages.forEach((i) -> {
                if (iteration[7].equals(i.getLanguageName())) {
                    language = i;
                }
            });

            listWrites.forEach((i) -> {
                if (iteration[8].equals(i.getWriterName())) {
                    writers.add(i);
                }
            });

            listGenrres.forEach((i) -> {
                if (iteration[9].equals(i.getGenreName())) {
                    genres.add(i);
                }
            });

            listActors.forEach((i) -> {
                if (iteration[10].equals(i.getActorName())) {
                    actors.add(i);
                }
            });

            listNetworks.forEach((i) -> {
                if (iteration[11].equals(i.getNetworkName())) {
                    networks.add(i);
                }
            });

            //books.add(listBooks.get(r.nextInt(listBooks.size())));

            try {
                movies = new Movies(iteration[0], iteration[1], (Date) dateFormat.parse(iteration[2]),
                        Integer.parseInt(iteration[3]), iteration[4], director, country, language, writers,
                        genres, actors, networks, books);
            } catch (ParseException ex) {
                Logger.getLogger(TestInsertMovie100.class.getName()).log(Level.SEVERE, null, ex);
            }

            mdbm.insertMovie(movies, con);

            writers.clear();
            genres.clear();
            actors.clear();
            networks.clear();
            books.clear();

        });
        con.getCon().getTransaction().commit();
        con.closeCon();
        result.sampleEnd();

        System.out.println("\n\nTempo de execução do teste: " + result.getTime());
        result.setSuccessful(true);

        return result;
    }

    //This method is only for local test, is exactly the same as runTest
    public void testMethod() {
        SampleResult result = new SampleResult();
        inserts = openTestFiles.open("insert\\insertMovies", testSize);

        Connection con = new Connection();
        con.setCon();

        List<Directors> listDirectors = ddbm.retrieveAllDirectors(con);
        List<Countries> listCountries = cdbm.retrieveAllCountries(con);
        List<Languages> listLanguages = ldbm.retrieveAllLanguages(con);
        List<Writers> listWrites = wdbm.retrieveAllWriters(con);
        List<Genres> listGenrres = gdbm.retrieveAllGenres(con);
        List<Actors> listActors = acdbm.retrieveAllActors(con);
        List<Networks> listNetworks = ndbm.retrieveAllNetwork(con);
        List<Books> listBooks = bkdbm.retrieveAllBooks(con);

        result.sampleStart();
        con.getCon().getTransaction().begin();
        con.getCon().flush();
        con.getCon().clear();
        inserts.forEach((iteration) -> {

            listDirectors.forEach((i) -> {
                if (iteration[5].equals(i.getDirectorName())) {
                    director = i;
                }
            });

            listCountries.forEach((i) -> {
                if (iteration[6].equals(i.getCountryName())) {
                    country = i;
                }
            });

            listLanguages.forEach((i) -> {
                if (iteration[7].equals(i.getLanguageName())) {
                    language = i;
                }
            });

            listWrites.forEach((i) -> {
                if (iteration[8].equals(i.getWriterName())) {
                    writers.add(i);
                }
            });

            listGenrres.forEach((i) -> {
                if (iteration[9].equals(i.getGenreName())) {
                    genres.add(i);
                }
            });

            listActors.forEach((i) -> {
                if (iteration[10].equals(i.getActorName())) {
                    actors.add(i);
                }
            });

            listNetworks.forEach((i) -> {
                if (iteration[11].equals(i.getNetworkName())) {
                    networks.add(i);
                }
            });

            books.add(listBooks.get(r.nextInt(listBooks.size())));

            try {
                movies = new Movies(iteration[0], iteration[1], (Date) dateFormat.parse(iteration[2]),
                        Integer.parseInt(iteration[3]), iteration[4], director, country, language, writers,
                        genres, actors, networks, books);
            } catch (ParseException ex) {
                Logger.getLogger(TestInsertMovie100.class.getName()).log(Level.SEVERE, null, ex);
            }

            mdbm.insertMovie(movies, con);

            writers.clear();
            genres.clear();
            actors.clear();
            networks.clear();
            books.clear();

        });
        con.getCon().getTransaction().commit();
        con.closeCon();
        result.sampleEnd();

        System.out.println("\n\nTempo de execução do teste: " + result.getTime());
        result.setSuccessful(true);
    }
}
