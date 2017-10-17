//package t_retrieve;
//
//import Conn.Connection;
//import DBManager.MoviesDBM;
//import entities.Movies;
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
//public class TestRetrieveMovie10 extends AbstractJavaSamplerClient implements Serializable {
//
//    OpenTestFiles openTestFiles = new OpenTestFiles();
//    MoviesDBM moviesDBM = new MoviesDBM();
//
//    private List<Movies> movies = new ArrayList<>();
//    private List<Object> retrievedMovies = new ArrayList<>();
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
//    //title
//    //director
//    //writer
//    //actor
//    //network
//    //book
//    public void testMethod() {
//        SampleResult result = new SampleResult();
//        inserts = openTestFiles.open("retrieve\\retrieveMovies", testSize);
//        
//                result.sampleStart();
//        Connection.getCon().getTransaction().begin();
//        inserts.forEach((iterator) -> {
//            Object movie;
//            //verificar a ordem salva no vetor com a ordem dos parametros do retrieveMovies
//            movie = moviesDBM.retrieveMovieByMultipleValues(iterator[0], iterator[1], iterator[2], iterator[3], iterator[4], iterator[5]);
//            retrievedMovies.add(movie);
//        });
////        Connection.getCon().getTransaction().commit();
//        result.sampleEnd();
//        Connection.closeCon();
//        System.out.println("\n\nTempo de execução do teste: " + result.getTime());
//        result.setSuccessful(true); 
//    }
//
//}
