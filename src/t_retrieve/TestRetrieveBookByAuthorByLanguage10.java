/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t_retrieve;

import Conn.Connection;
import DBManager.BooksDBM;
import entities.Books;
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
public class TestRetrieveBookByAuthorByLanguage10 extends AbstractJavaSamplerClient implements Serializable {

    OpenTestFiles openTestFilesBook = new OpenTestFiles();
    OpenTestFiles openTestFilesLanguage = new OpenTestFiles();
    BooksDBM booksDBM = new BooksDBM();
    Random r = new Random();
    
    private List<Object> retrievedBooks = new ArrayList<>();
    List<String[]> inserts = new ArrayList<>();
    List<String[]> listLanguages = new ArrayList<>();

    private final String testSize = "10";

    @Override
    public SampleResult runTest(JavaSamplerContext jsc) {
        SampleResult result = new SampleResult();
        return result;
    }

    //isbn
    //title
    //author
    //serie
    //publisher
    public void testMethod() {
        SampleResult result = new SampleResult();
        inserts = openTestFilesBook.open("retrieve\\retrieveBooks", testSize);
        listLanguages = openTestFilesLanguage.open("listLanguage\\listLanguage", "");
        
        result.sampleStart();
        inserts.forEach((iterator) -> {
            Object book;
            book = booksDBM.retrieveBookByAuthorByLanguage(listLanguages.get(rand(0, listLanguages.size()-1))[0]);
            retrievedBooks.add(book);
        });
        
        result.sampleEnd();
        System.out.println("\n\nTempo de execução do teste: " + result.getTime());
        result.setSuccessful(true);
    }
    
    public int rand(int minimo, int maximo) {
        return r.nextInt((maximo - minimo) + 1) + minimo;
    }
}
