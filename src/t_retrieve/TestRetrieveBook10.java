/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t_retrieve;

import Conn.Connection;
import DBManager.BooksDBM;
import java.util.ArrayList;
import java.util.List;
import org.apache.jmeter.samplers.SampleResult;
import t_files.OpenTestFiles;

/**
 *
 * @author lucas
 */
public class TestRetrieveBook10 {

    OpenTestFiles openTestFiles = new OpenTestFiles();
    BooksDBM booksDBM = new BooksDBM();

    private List<Object> retrievedBooks = new ArrayList<>();
    List<String[]> inserts = new ArrayList<>();

    private final int testSize = 10;

    //isbn
    //title
    //author
    //serie
    //publisher
    public void testMethod() {
        SampleResult result = new SampleResult();
        inserts = openTestFiles.open("retrieve\\retrieveBooks", testSize);

        Connection con = new Connection();
        con.setCon();

        result.sampleStart();
        inserts.forEach((iterator) -> {
            Object book;
            //verificar a ordem salva no vetor com a ordem dos parametros do retrieveBooks
            book = booksDBM.retrieveBookByMultipleValues(iterator[0], iterator[1], iterator[2], iterator[3], iterator[4], con);
            retrievedBooks.add(book);
        });
//        Connection.getCon().getTransaction().commit();
        result.sampleEnd();
        con.closeCon();
        System.out.println("\n\nTempo de execução do teste: " + result.getTime());
        result.setSuccessful(true);
    }
}
