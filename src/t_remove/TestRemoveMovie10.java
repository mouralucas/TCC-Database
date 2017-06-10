package t_remove;

import Conn.Connection;
import DBManager.MoviesDBM;
import entities.Books;
import entities.Movies;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
public class TestRemoveMovie10 extends AbstractJavaSamplerClient implements Serializable {

    OpenTestFiles openTestFiles = new OpenTestFiles();
    private MoviesDBM moviesDBM = new MoviesDBM();
    
    private final int testSize = 10;

    Movies moviesAux;
    List<Object> objectReferenceMovies = new ArrayList<>();
    List<Movies> movies = new ArrayList<>();
    List<Movies> allMovies = new ArrayList<>();
    List<Movies> moviesListAux = new ArrayList<>();
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
        
        
        allMovies = moviesDBM.retrieveAllMovies(con);

        con.getCon().getTransaction().begin();
        result.sampleStart();
        for(int i = 0; i < testSize; i++){
            moviesDBM.removeMovie(allMovies.get(i), con);
        }
        con.getCon().getTransaction().commit();
        con.closeCon();
        result.sampleEnd();

        System.out.println("\n\nTempo de execução do teste: " + result.getTime());
        result.setSuccessful(true);
    }
}
