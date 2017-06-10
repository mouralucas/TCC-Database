package t_remove;

import Conn.Connection;
import DBManager.BooksDBM;
import entities.Books;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

/**
 * @author Jociane Franzoni de Lima
 * @author Lucas Penha de Moura
 *
 * ------------------- Trabalho de Conclusão de Curso ---------------------
 * ---------------------- Engenharia de Computação ------------------------
 * ------------- Universidade Tecnológica Federal do Paraná ---------------
 *
 */
public class TestRemoveBook10 extends AbstractJavaSamplerClient implements Serializable {

    private BooksDBM booksDBM = new BooksDBM();
    private final int testSize = 50000;
    Books booksAux;
    List<Object> objectReferenceBooks = new ArrayList<>();
    List<Books> books = new ArrayList<>();
    List<Books> allBooks = new ArrayList<>();
    List<Books> booksListAux = new ArrayList<>();
    List<String[]> removeList = new ArrayList<>();

    @Override
    public SampleResult runTest(JavaSamplerContext jsc) {

        SampleResult result = new SampleResult();
        return result;
    }

    //This method is only for local test, is exactly the same as runTest
    public void testMethod() {
        SampleResult result = new SampleResult();
        Connection con = new Connection();
        con.setCon();

        allBooks = booksDBM.retrieveAllBooks(con);

        con.getCon().getTransaction().begin();
        result.sampleStart();
        for (int i = 0; i < testSize; i++) {
            booksDBM.removeBook(allBooks.get(i), con);
        }
        con.getCon().getTransaction().commit();
        con.closeCon();
        result.sampleEnd();

        System.out.println("\n\nTempo de execução do teste: " + result.getTime());
        result.setSuccessful(true);
    }
}
