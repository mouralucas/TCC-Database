/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author lucas
 */
public class TesteUpdateMovie extends AbstractJavaSamplerClient implements Serializable {

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

    
        return result;
    }

    public void testMethod() {
        SampleResult result = new SampleResult();
        updates = openTestFiles.open("update\\updateMovies", 1000);
        
        Connection con = new Connection();
        con.setCon();
        
        allMovies = moviesDBM.retrieveAllMovies(con);

        //pega a quantidade necessária de movies para o teste
        for (int i = 0; i < testSize; i++) {
            moviesToBeUpdated.add(allMovies.get(rand(0, allMovies.size()-1)));
        }

        //modifica os valores de alguns campos 
        moviesToBeUpdated.forEach((iterator) -> {
            int pos = rand(0, updates.size()-1);
            iterator.setMovieTitle(updates.get(pos)[0]);
            iterator.setMovieSubTitle(updates.get(pos)[1]);
            iterator.setMovieSynopsis(updates.get(pos)[2]);
        });
        
        //grava os novos valores no banco
        result.sampleStart();
        moviesToBeUpdated.forEach((iterator) -> {
            moviesDBM.insertMovie(iterator, con);
        });
        System.out.println("\n\nTempo de execução do teste: " + result.getTime());
        result.setSuccessful(true);

    }

    public int rand(int minimo, int maximo) {
        return r.nextInt((maximo - minimo) + 1) + minimo;
    }
}
