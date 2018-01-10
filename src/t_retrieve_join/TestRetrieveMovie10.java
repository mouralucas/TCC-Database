package t_retrieve_join;

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
    Random r = new Random();

    private List<Movies> m;
    private List<Object> movies = new ArrayList<>();
    private List<String[]> retrieveInfo = new ArrayList<>();
    private List<String[]> dbData = new ArrayList<>();

    private final int testSize = 10;

    @Override
    public SampleResult runTest(JavaSamplerContext jsc) {
        SampleResult result = new SampleResult();
        dbData = openTestFiles.open("insert\\insertMovies", 55000);

        retrieveInfo.clear();
        for (int i = 0; i < testSize; i++) {
            retrieveInfo.add(dbData.get(rand(0, dbData.size() - 1)));
        }

        Connection con = new Connection();
        con.setCon();

        result.sampleStart();

        retrieveInfo.forEach((iterator) -> {
            m = moviesDBM.retrieveOneJoin(iterator[1], 
                    iterator[6], iterator[9], iterator[11], 
                    iterator[12], iterator[13], con);
            movies.add(m);
        });

        result.sampleEnd();
        con.closeCon();

        System.out.printf("Tempo de execução do teste: %.3f minutos\n", (double)result.getTime() / 60000);
        result.setSuccessful(true);
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

        for (int i = 0; i < testSize; i++) {
            retrieveInfo.add(dbData.get(rand(0, dbData.size() - 1)));
        }

        Connection con = new Connection();
        con.setCon();

        result.sampleStart();

        retrieveInfo.forEach((iterator) -> {
            m = moviesDBM.retrieveThreeJoins(iterator[1], iterator[6], iterator[9], iterator[11], iterator[12], iterator[13], con);
//            m = moviesDBM.retrieveOneJoin(iterator[1], iterator[6], iterator[9], iterator[11], iterator[12], iterator[13], con);
            movies.add(m);
        });

        result.sampleEnd();
        con.closeCon();

        System.out.println("Registros buscados: " + movies.size());

        System.out.printf("\n\nTempo de execução do teste: %.3f mili-segundos\n", (double)result.getTime());
        System.out.printf("Tempo de execução do teste: %.3f segundos\n", (double)result.getTime() / 1000);
        System.out.printf("Tempo de execução do teste: %.3f minutos\n", (double)result.getTime() / 60000);
        result.setSuccessful(true);
    }

    public int rand(int minimo, int maximo) {
        return r.nextInt((maximo - minimo) + 1) + minimo;
    }

}
