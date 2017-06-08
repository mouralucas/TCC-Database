///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package t_update;
//
//import Conn.Connection;
//import DBManager.BooksDBM;
//import entities.Books;
//import java.io.Serializable;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
//import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
//import org.apache.jmeter.samplers.SampleResult;
//import t_files.OpenTestFiles;
//
///**
// *
// * @author lucas
// */
//public class TesteUpdateBook10 extends AbstractJavaSamplerClient implements Serializable {
//
//    private boolean conn = Connection.setCon();
//    OpenTestFiles openTestFiles = new OpenTestFiles();
//    BooksDBM booksDBM = new BooksDBM();
//    Random r = new Random();
//
//    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//
//    private final String testSize = "10";
//
//    Books books;
//    List<Books> allBooks;
//    List<Books> booksToBeUpdated = new ArrayList<>();
//
//    List<String[]> updates = new ArrayList<>();
//
//    @Override
//    public SampleResult runTest(JavaSamplerContext jsc) {
//        SampleResult result = new SampleResult();
//
//        Connection.closeCon();
//        return result;
//    }
//
//    public void testMethod() {
//        SampleResult result = new SampleResult();
//        updates = openTestFiles.open("update\\updateBooks", testSize);
//        allBooks = booksDBM.retrieveAllBooks();
//
//        for (int i = 0; i < Integer.parseInt(testSize); i++) {
//            booksToBeUpdated.add(allBooks.get(rand(0, allBooks.size()-1)));
//        }
//        
//        
//
//        result.sampleStart();
//        updates.forEach((iterator) -> {
//            System.out.println("pos iterator: " + iterator.hashCode());
//        });
//        result.sampleEnd();
//
//        System.out.println("\n\nTempo de execução do teste: " + result.getTime());
//        result.setSuccessful(true);
//
//        Connection.closeCon();
//    }
//
//    public int rand(int minimo, int maximo) {
//        return r.nextInt((maximo - minimo) + 1) + minimo;
//    }
//}
