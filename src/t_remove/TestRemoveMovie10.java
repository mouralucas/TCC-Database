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

    private boolean conn = Connection.setCon();
    OpenTestFiles openTestFiles = new OpenTestFiles();
    private MoviesDBM moviesDBM = new MoviesDBM();
    private final String testSize = "10";
    
    Movies moviesAux;
    List<Object> objectReferenceMovies = new ArrayList<>();
    List<Movies> movies = new ArrayList<>();
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
        removeList = openTestFiles.open("remove\\removeMovies", testSize);
        
        for(String[] remove: removeList){
            String aux = remove[0];
            moviesListAux = moviesDBM.retrieveMovieByTitle(aux);
            if(moviesListAux != null) {
                movies.add(moviesListAux.get(0));
            }
        }
        
        result.sampleStart();
        
        Connection.getCon().getTransaction().begin();
       
        for(Movies m : movies) {
            moviesDBM.removeBook(m);
        }
        
        Connection.getCon().getTransaction().commit();
        
        result.sampleEnd();

        System.out.println("\n\nTempo de execução do teste: " + result.getTime());
        result.setSuccessful(true);
    }
}
