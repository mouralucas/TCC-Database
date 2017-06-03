package t_remove;

import Conn.Connection;
import DBManager.BooksDBM;
import entities.Books;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
public class TestRemoveBook10 extends AbstractJavaSamplerClient implements Serializable {

    private boolean conn = Connection.setCon();
    OpenTestFiles openTestFiles = new OpenTestFiles();
    private BooksDBM booksDBM = new BooksDBM();
    private final String testSize = "10";
    Books booksAux;
    List<Object> objectReferenceBooks = new ArrayList<>();
    List<Books> books = new ArrayList<>();
    List<Books> booksListAux = new ArrayList<>();
    List<String[]> removeList = new ArrayList<>();
    

    @Override
    public SampleResult runTest(JavaSamplerContext jsc) {

       SampleResult result = new SampleResult();
        removeList = openTestFiles.open("remove\\removeBooks", testSize);
        
        for(String[] remove: removeList){
            String aux = remove[0];
            if(aux != null) {
                objectReferenceBooks.add(booksDBM.retrieveBookByTitle(aux).get(0));
            }
        }
        
        result.sampleStart();
        Iterator itr = objectReferenceBooks.iterator();
        while (itr.hasNext()) {
            Object[] obj = (Object[]) itr.next();
           // int i = Integer.valueOf(String.valueOf(obj[0]));
            books.add((Books)obj[0]);
        }
        
        Connection.getCon().getTransaction().begin();
        for(Books b : books){
            booksDBM.removeBook(b);
        }
        Connection.getCon().getTransaction().commit();
        result.sampleEnd();

        System.out.println("\n\nTempo de execução do teste: " + result.getTime());
        result.setSuccessful(true);
        return result;
    }

    //This method is only for local test, is exactly the same as runTest
    public void testMethod() {
        SampleResult result = new SampleResult();
        removeList = openTestFiles.open("remove\\removeBooks", testSize);
        
        for(String[] remove: removeList){
            String aux = remove[0];
            booksListAux = booksDBM.retrieveBookByTitle(aux);
            if(booksListAux != null) {
                books.add(booksListAux.get(0));
            }
        }
        
        result.sampleStart();
        Connection.getCon().getTransaction().begin();
        Iterator itr = books.iterator();
        while (itr.hasNext()) {
              Books objBook = (Books) itr.next();
              booksDBM.removeBook(objBook);
        }
       
        Connection.getCon().getTransaction().commit();
        result.sampleEnd();

        System.out.println("\n\nTempo de execução do teste: " + result.getTime());
        result.setSuccessful(true);
    }
}
