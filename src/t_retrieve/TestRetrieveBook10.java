///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package t_retrieve;
//
//import Conn.Connection;
//import DBManager.BooksDBM;
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;
//import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
//import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
//import org.apache.jmeter.samplers.SampleResult;
//import t_files.OpenTestFiles;
//
///**
// *
// * @author lucas
// */
//public class TestRetrieveBook10 extends AbstractJavaSamplerClient implements Serializable {
//
//    OpenTestFiles openTestFiles = new OpenTestFiles();
//    BooksDBM booksDBM = new BooksDBM();
//    
//    private List<Object> retrievedBooks = new ArrayList<>();
//    List<String[]> inserts = new ArrayList<>();
//
//    private final String testSize = "10";
//
//    @Override
//    public SampleResult runTest(JavaSamplerContext jsc) {
//        SampleResult result = new SampleResult();
//        return result;
//    }
//
//    //isbn
//    //title
//    //author
//    //serie
//    //publisher
//    public void testMethod() {
//        SampleResult result = new SampleResult();
//        inserts = openTestFiles.open("retrieve\\retrieveBooks", testSize);
//        
//        result.sampleStart();
//        Connection.getCon().getTransaction().begin();
//        inserts.forEach((iterator) -> {
//            Object book;
//            //verificar a ordem salva no vetor com a ordem dos parametros do retrieveBooks
//            book = booksDBM.retrieveBookByMultipleValues(iterator[0], iterator[1], iterator[2], iterator[3], iterator[4]);
//            retrievedBooks.add(book);
//        });
////        Connection.getCon().getTransaction().commit();
//        result.sampleEnd();
//        Connection.closeCon();
//        System.out.println("\n\nTempo de execução do teste: " + result.getTime());
//        result.setSuccessful(true);
//    }
//}
