package t_retrieve;

import Conn.Connection;
import DBManager.MoviesDBM;
import entities.Movies;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;
import t_files.OpenTestFiles;

/**
 *
 * @author lucas
 */
public class TestRetrieveMovie10 extends AbstractJavaSamplerClient implements Serializable {

    OpenTestFiles openTestFiles = new OpenTestFiles();
    MoviesDBM moviesDBM = new MoviesDBM();
    //Object m;
    Random r = new Random();

    private List<Movies> m;
    private List<Movies> movies = new ArrayList<>();
    private List<String[]> retrieveInfo = new ArrayList<>();
    private List<String[]> dbData = new ArrayList<>();

    private final int testSize = 10;

    @Override
    public SampleResult runTest(JavaSamplerContext jsc) {
        SampleResult result = new SampleResult();
        return result;
    }

    //title [1]
    //director [6]
    //writer [9]
    //actor [11]
    //network [12]
    //book
    public void testMethod() {
        SampleResult result = new SampleResult();
        dbData = openTestFiles.open("insert\\insertMovies", 55000);
        
        for(int i = 0; i < testSize; i++){
            retrieveInfo.add(dbData.get(rand(0,dbData.size()-1)));
        }

        Connection con = new Connection();
        con.setCon();

        result.sampleStart();
        for(String[] iterator: retrieveInfo) {
            Object mv;
            m = moviesDBM.retrieveMovieByMultipleValues(iterator[1], iterator[6], iterator[9], iterator[11], iterator[12], iterator[13], con);
            movies.add((Movies)m.get(0));
        }
        
//        retrieveInfo.forEach((iterator) ->{
//            m = moviesDBM.retrieveMovieByMultipleValues(iterator[1], iterator[6], iterator[9], iterator[11], iterator[12], iterator[13], con);
//            movies.add((Movies)m);
//        });

        result.sampleEnd();
        con.closeCon();

        System.out.println("\n\nTempo de execução do teste: " + result.getTime());
        result.setSuccessful(true);
    }

    public int rand(int minimo, int maximo) {
        return r.nextInt((maximo - minimo) + 1) + minimo;
    }

}
