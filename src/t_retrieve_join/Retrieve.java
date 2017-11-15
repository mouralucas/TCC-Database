package t_retrieve_join;

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

    private final int testSize = 10;

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
        SampleResult resultFourJoins = new SampleResult();
        SampleResult resultFiveJoins = new SampleResult();

        dbData = openTestFiles.open("insert\\insertMovies", 55000);

        for (int i = 0; i < testSize; i++) {
            retrieveInfo.add(dbData.get(rand(0, dbData.size() - 1)));
        }

        Connection con = new Connection();
        con.setCon();

        movies.clear();
        System.out.println("1 Join...");
        resultOneJoin.sampleStart();
        retrieveInfo.forEach((iterator) -> {
            m = moviesDBM.retrieveOneJoin(iterator[1], iterator[6], iterator[9], iterator[11], iterator[12], iterator[13], con);
            movies.add(m);
        });
        resultOneJoin.sampleEnd();

        movies.clear();
        System.out.println("2 Joins...");
        resultTwoJoins.sampleStart();
        retrieveInfo.forEach((iterator) -> {
            m = moviesDBM.retrieveTwoJoins(iterator[1], iterator[6], iterator[9], iterator[11], iterator[12], iterator[13], con);
            movies.add(m);
        });
        resultTwoJoins.sampleEnd();

//        movies.clear();
//        System.out.println("3 Joins...");
//        resultThreeJoins.sampleStart();
//        retrieveInfo.forEach((iterator) -> {
//            m = moviesDBM.retrieveThreeJoins(iterator[1], iterator[6], iterator[9], iterator[11], iterator[12], iterator[13], con);
//            movies.add(m);
//        });
//        resultThreeJoins.sampleEnd();

//        movies.clear();
//        System.out.println("4 Joins...");
//        resultFourJoins.sampleStart();
//        retrieveInfo.forEach((iterator) -> {
//            m = moviesDBM.retrieveFourJoins(iterator[1], iterator[6], iterator[9], iterator[11], iterator[12], iterator[13], con);
//            movies.add(m);
//        });
//        resultFourJoins.sampleEnd();

//        movies.clear();
//        System.out.println("5 Joins...");
//        resultFiveJoins.sampleStart();
//        retrieveInfo.forEach((iterator) -> {
//            m = moviesDBM.retrieveFiveJoins(iterator[1], iterator[6], iterator[9], iterator[11], iterator[12], iterator[13], con);
//            movies.add(m);
//        });
//        resultFiveJoins.sampleEnd();

        System.out.println("Tamanho de movies: " + movies.size());
        
        con.closeCon();

        //System.out.println("Tamanho list: " + movies.size());
        System.out.printf("\n\nTempo de execução um join: %.3f mili-segundos\n", (double) resultOneJoin.getTime());
        System.out.printf("Tempo de execução dois joins: %.3f mili-segundos\n", (double) resultTwoJoins.getTime());
        System.out.printf("Tempo de execução tres joins: %.3f mili-segundos\n", (double) resultThreeJoins.getTime());
        System.out.printf("Tempo de execução quatro joins: %.3f mili-segundos\n", (double) resultFourJoins.getTime());
        System.out.printf("Tempo de execução cinco joins: %.3f mili-segundos\n", (double) resultFiveJoins.getTime());

        System.out.printf("\n\nTempo de execução para %d operações com um join: %.3f segundos\n", testSize, (double) resultOneJoin.getTime() / 1000);
        System.out.printf("Tempo de execução para %d operações com dois joins: %.3f segundos\n", testSize, (double) resultTwoJoins.getTime() / 1000);
        System.out.printf("Tempo de execução para %d operações com tres joins: %.3f segundos\n", testSize, (double) resultThreeJoins.getTime() / 1000);
        System.out.printf("Tempo de execução para %d operações com quatro joins: %.3f segundos\n", testSize, (double) resultFourJoins.getTime() / 1000);
        System.out.printf("Tempo de execução para %d operações com cinco joins: %.3f segundos\n", testSize, (double) resultFiveJoins.getTime() / 1000);

        System.out.printf("\n\nTempo de execução para %d operações com um join: %.3f minutos\n", testSize, (double) resultOneJoin.getTime() / 60000);
        System.out.printf("Tempo de execução para %d operações com dois joins: %.3f minutos\n", testSize, (double) resultTwoJoins.getTime() / 60000);
        System.out.printf("Tempo de execução para %d operações com tres joins: %.3f minutos\n", testSize, (double) resultThreeJoins.getTime() / 60000);
        System.out.printf("Tempo de execução para %d operações com quatro joins: %.3f minutos\n", testSize, (double) resultFourJoins.getTime() / 60000);
        System.out.printf("Tempo de execução para %d operações com cinco joins: %.3f minutos\n", testSize, (double) resultFiveJoins.getTime() / 60000);

    }

    public int rand(int minimo, int maximo) {
        return r.nextInt((maximo - minimo) + 1) + minimo;
    }

}
