package t_update;

import Conn.Connection;
import DBManager.MoviesDBM;
import entities.Movies;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
public class TesteUpdateMovie10 extends AbstractJavaSamplerClient implements Serializable {

    OpenTestFiles openTestFiles = new OpenTestFiles();
    MoviesDBM moviesDBM = new MoviesDBM();
    Random r = new Random();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    private final int testSize = 10;

    Movies movies;
    List<Movies> allMovies;
    List<Movies> moviesToBeUpdated = new ArrayList<>();

    List<String[]> updates = new ArrayList<>();

    @Override
    public SampleResult runTest(JavaSamplerContext jsc) {
        SampleResult result = new SampleResult();

        updates = openTestFiles.open("update\\updateMovies", 50000);

        Connection con = new Connection();
        con.setCon();

        //busca a quantidade necessário para o teste a partir de um id aleatório
        int retrieve = rand(0, 54000 - 300);
        allMovies = moviesDBM.retrieveSomeMovies(con, retrieve, retrieve + testSize + 1);

        System.out.println("\n\nTodos os dados buscados, iniciando Teste\n\n");

        //pega a quantidade necessária de movies para o teste
        for (int i = 0; i < testSize; i++) {
            moviesToBeUpdated.add(allMovies.get(i));
        }

        //modifica os valores de alguns campos 
        moviesToBeUpdated.forEach((iterator) -> {
            int pos = rand(0, updates.size() - 1);
            iterator.setMovieTitle(updates.get(pos)[0]);
            iterator.setMovieSubTitle(updates.get(pos)[1]);
            iterator.setMovieSynopsis(updates.get(pos)[2]);
        });

        //grava os novos valores no banco
        result.sampleStart();
        con.getCon().getTransaction().begin();
        moviesToBeUpdated.forEach((iterator) -> {
            moviesDBM.insertMovie(iterator, con);
        });
        con.getCon().getTransaction().commit();
        result.sampleEnd();
        con.closeCon();

        System.out.println("\n\nTempo de execução do teste: " + result.getTime());
        result.setSuccessful(true);

        allMovies.clear();
        moviesToBeUpdated.clear();
        updates.clear();

        return result;
    }

    public void testMethod() {
        SampleResult result = new SampleResult();

        updates = openTestFiles.open("update\\updateMovies", 50000);

        Connection con = new Connection();
        con.setCon();

        int retrieve = rand(0, 54000 - 300);
        int valor = 1;

        result.sampleStart();
        allMovies = moviesDBM.retrieveSomeMovies(con, retrieve, retrieve + testSize + 1);
//        allMovies = moviesDBM.retrieveSomeMovies(con, valor, valor + testSize + 1);
        result.sampleEnd();

        allMovies.forEach((iteratir) -> {
            System.out.println(iteratir.getMovie_id());
        });

        System.out.println("\n\nTodos os dados buscados, iniciando Teste\n\n");

        //pega a quantidade necessária de movies para o teste
        for (int i = 0; i < testSize; i++) {
            moviesToBeUpdated.add(allMovies.get(i));
        }

        //modifica os valores de alguns campos 
        moviesToBeUpdated.forEach((iterator) -> {
            int pos = rand(0, updates.size() - 1);
            iterator.setMovieTitle(updates.get(pos)[0]);
            iterator.setMovieSubTitle(updates.get(pos)[1]);
            iterator.setMovieSynopsis(updates.get(pos)[2]);
        });

        //grava os novos valores no banco
        con.getCon().getTransaction().begin();
        moviesToBeUpdated.forEach((iterator) -> {
            moviesDBM.insertMovie(iterator, con);
        });
        con.getCon().getTransaction().commit();

        con.closeCon();

        System.out.println("\n\nTempo de execução do teste: " + result.getTime());
        result.setSuccessful(true);

        allMovies.clear();
        moviesToBeUpdated.clear();
        updates.clear();
    }

    public int rand(int minimo, int maximo) {
        return r.nextInt((maximo - minimo) + 1) + minimo;
    }
}
