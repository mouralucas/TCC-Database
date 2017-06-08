//package t_remove;
//
//import Conn.Connection;
//import DBManager.MoviesDBM;
//import entities.Books;
//import entities.Movies;
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
//import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
//import org.apache.jmeter.samplers.SampleResult;
//import t_files.OpenTestFiles;
//
///**
// * @author Jociane Franzoni de Lima
// * @author Lucas Penha de Moura
// *
// * ------------------- Trabalho de Conclusão de Curso ---------------------
// * ---------------------- Engenharia de Computação ------------------------
// * ------------- Universidade Tecnológica Federal do Paraná ---------------
// *
// */
//public class TestRemoveMovie10 extends AbstractJavaSamplerClient implements Serializable {
//
//    private boolean conn = Connection.setCon();
//    OpenTestFiles openTestFiles = new OpenTestFiles();
//    private MoviesDBM moviesDBM = new MoviesDBM();
//    
//    private final int testSize = 100;
//
//    Movies moviesAux;
//    List<Object> objectReferenceMovies = new ArrayList<>();
//    List<Movies> movies = new ArrayList<>();
//    List<Movies> allMovies = new ArrayList<>();
//    List<Movies> moviesListAux = new ArrayList<>();
//    List<String[]> removeList = new ArrayList<>();
//
//    @Override
//    public SampleResult runTest(JavaSamplerContext jsc) {
//
//        SampleResult result = new SampleResult();
//        return result;
//    }
//
//    //This method is only for local test, is exactly the same as runTest
//    public void testMethod() {
//        SampleResult result = new SampleResult();
//        allMovies = moviesDBM.retrieveAllMovies();
//
//        Connection.getCon().getTransaction().begin();
//        result.sampleStart();
//        for(int i = 0; i < testSize; i++){
//            moviesDBM.removeBook(allMovies.get(i));
//        }
//        Connection.getCon().getTransaction().commit();
//        Connection.closeCon();
//        result.sampleEnd();
//
//        System.out.println("\n\nTempo de execução do teste: " + result.getTime());
//        result.setSuccessful(true);
//    }
//}
