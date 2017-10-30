package t_retrieve;

import Conn.Connection;
import DBManager.MoviesDBM;
import entities.Movies;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.apache.jmeter.samplers.SampleResult;
import t_files.OpenTestFiles;

/**
 *
 * @author lucas
 */
public class Retrieve {

    OpenTestFiles openTestFiles = new OpenTestFiles();
    MoviesDBM moviesDBM = new MoviesDBM();
    Random r = new Random();

    private List<Movies> m;
    private List<Object> movies = new ArrayList<>();
    private List<String[]> retrieveInfo = new ArrayList<>();
    private List<String[]> dbData = new ArrayList<>();

    private final int testSize = 100;

    //title [1]
    //director [6]
    //writer [9]
    //actor [11]
    //network [12]
    //book
    public void testMethod() {
        SampleResult resultOneJoin = new SampleResult();
        SampleResult resultTwoJoins = new SampleResult();
        SampleResult resultThreeJoins = new SampleResult();
        dbData = openTestFiles.open("insert\\insertMovies", 55000);

        for (int i = 0; i < testSize; i++) {
            retrieveInfo.add(dbData.get(rand(0, dbData.size() - 1)));
        }

        Connection con = new Connection();
        con.setCon();

        movies.clear();
        resultOneJoin.sampleStart();
        retrieveInfo.forEach((iterator) -> {
            m = moviesDBM.retrieveOneJoin(iterator[1], iterator[6], iterator[9], iterator[11], iterator[12], iterator[13], con);
            movies.add(m);
        });
        resultOneJoin.sampleEnd();

        movies.clear();
        resultTwoJoins.sampleStart();
        retrieveInfo.forEach((iterator) -> {
            m = moviesDBM.retrieveTwoJoins(iterator[1], iterator[6], iterator[9], iterator[11], iterator[12], iterator[13], con);
            movies.add(m);
        });
        resultTwoJoins.sampleEnd();

        movies.clear();
        resultThreeJoins.sampleStart();
        retrieveInfo.forEach((iterator) -> {
            m = moviesDBM.retrieveThreeJoins(iterator[1], iterator[6], iterator[9], iterator[11], iterator[12], iterator[13], con);
            movies.add(m);
        });
        resultThreeJoins.sampleEnd();

        con.closeCon();

        System.out.printf("\n\nTempo de execução one join: %.3f mili-segundos\n", (double) resultOneJoin.getTime());
        System.out.printf("Tempo de execução two joins: %.3f mili-segundos\n", (double) resultTwoJoins.getTime());
        System.out.printf("Tempo de execução three joins: %.3f mili-segundos\n", (double) resultThreeJoins.getTime());
        
        System.out.printf("\n\nTempo de execução one join: %.3f segundos\n", (double) resultOneJoin.getTime() / 1000);
        System.out.printf("Tempo de execução two joins: %.3f segundos\n", (double) resultTwoJoins.getTime() / 1000);
        System.out.printf("Tempo de execução three joins: %.3f segundos\n", (double) resultThreeJoins.getTime() / 1000);
        
        System.out.printf("\n\nTempo de execução one join: %.3f minutos\n", (double) resultOneJoin.getTime() / 60000);
        System.out.printf("Tempo de execução two joins: %.3f minutos\n", (double) resultTwoJoins.getTime() / 60000);
        System.out.printf("Tempo de execução three joins: %.3f minutos\n", (double) resultThreeJoins.getTime() / 60000);
        resultThreeJoins.setSuccessful(true);
    }

    public int rand(int minimo, int maximo) {
        return r.nextInt((maximo - minimo) + 1) + minimo;
    }

}
