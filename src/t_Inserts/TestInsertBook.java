package t_Inserts;

import Conn.Connection;
import DBManager.AuthorsDBM;
import DBManager.BooksDBM;
import DBManager.BookSeriesDBM;
import DBManager.CountriesDBM;
import DBManager.GenresDBM;
import DBManager.LanguagesDBM;
import DBManager.PublishersDBM;
import entities.Authors;
import entities.BookSeries;
import entities.Books;
import entities.Countries;
import entities.Genres;
import entities.Languages;
import entities.Publishers;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
public class TestInsertBook extends AbstractJavaSamplerClient implements Serializable {

    OpenTestFiles openTestFiles = new OpenTestFiles();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    private final int testSize = 500;

    Books books;

    BooksDBM bkdbm = new BooksDBM();
    CountriesDBM cdbm = new CountriesDBM();
    LanguagesDBM ldbm = new LanguagesDBM();
    GenresDBM gdbm = new GenresDBM();
    PublishersDBM pdbm = new PublishersDBM();
    AuthorsDBM adbm = new AuthorsDBM();
    BookSeriesDBM bsdbm = new BookSeriesDBM();

    //the actual object that goes into the Book table
    List<Countries> countries = new ArrayList<>();
    List<Languages> languages = new ArrayList<>();
    List<Genres> genres = new ArrayList<>();
    Publishers publisher;
    List<Authors> authors = new ArrayList<>();
    List<BookSeries> bookSeries = new ArrayList<>();

    List<String[]> inserts = new ArrayList<>();

    @Override
    public SampleResult runTest(JavaSamplerContext jsc) {
        SampleResult result = new SampleResult();

        return result;
    }

    //This method is only for local test, is exactly the same as runTest
    public void testMethod() {
        SampleResult result = new SampleResult();
        inserts = openTestFiles.open("insert\\insertBooks", testSize);

        Connection con = new Connection();
        con.setCon();

        //This information is used to insert a new Book to the database
        List<Languages> listLanguages = ldbm.retrieveAllLanguages(con);
        List<Genres> listGenrres = gdbm.retrieveAllGenres(con);
        List<Publishers> listPublisers = pdbm.retrieveAllPublishers(con);
        List<Authors> listAuthors = adbm.retrieveAllAuthors(con);
        List<BookSeries> listBookSeries = bsdbm.retrieveAllBookSeries(con);

        result.sampleStart();
        con.getCon().getTransaction().begin();
        inserts.forEach((iterator) -> {
            //find auhtor
            listAuthors.forEach((i) -> {
                if (iterator[9].equals(i.getAuthorName())) {
                    authors.add(i);
                }
            });

            //find book serie
            listBookSeries.forEach((i) -> {
                if (iterator[10].equals(i.getSerieName())) {
                    bookSeries.add(i);
                }
            });

            //find language
            listLanguages.forEach((i) -> {
                if (iterator[11].equals(i.getLanguage_id())) {
                    languages.add(i);
                }
            });

            //find publisher
            listPublisers.forEach((i) -> {
                if (iterator[12].equals(i.getPublisherName())) {
                    publisher = i;
                }
            });

            //find genres
            listGenrres.forEach((i) -> {
                if (iterator[13].equals(i.getGenreName())) {
                    genres.add(i);
                }
            });

            try {
                books = new Books(iterator[0], iterator[1], iterator[2], Integer.parseInt(iterator[3]),
                        (Date) dateFormat.parse(iterator[4]), Double.parseDouble(iterator[5].replace(",", ".")),
                        Integer.parseInt(iterator[6]), iterator[7], iterator[8], authors,
                        bookSeries, languages, publisher, genres);
            } catch (ParseException ex) {
                Logger.getLogger(TestInsertBook.class.getName()).log(Level.SEVERE, null, ex);
            }

            //abrir transaction
            bkdbm.insertBook(books, con);
            
            authors.clear();
            bookSeries.clear();
            languages.clear();
            genres.clear();
            
            
        });
        con.getCon().getTransaction().commit();
        result.sampleEnd();
        con.closeCon();

        double min = ((result.getTime() / 1000) / 60);

        System.out.println("\n\nTempo de execução do teste (seg): " + result.getTime());
        System.out.println("Tempo de execução do teste (min):" + min);
        result.setSuccessful(true);
    }

}
