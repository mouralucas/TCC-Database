package newLibrary_v7;

import Conn.Connection;
import t_remove.TestRemoveMovie10;

/**
 * @author Jociane Franzoni de Lima
 * @author Lucas Penha de Moura
 *
 * ------------------- Trabalho de Conclusão de Curso ---------------------
 * ---------------------- Engenharia de Computação ------------------------
 * ------------- Universidade Tecnológica Federal do Paraná ---------------
 *
 */
public class InitSystem {

    public static void main(String args[]) {
        Connection.setCon();

//        InsertData insertDta = new InsertData();
//        insertDta.insertData();

//            TestRemoveBook10 book10 = new TestRemoveBook10();
//            book10.testMethod();
            
//            TestInsertMovie10 movie10 = new TestInsertMovie10();
//            movie10.testMethod();
            
            TestRemoveMovie10 movie10 = new TestRemoveMovie10();
            movie10.testMethod();
          
//          TestInsertBook10 book10 = new TestInsertBook10();
//          book10.testMethod();

//        TestInsertBook10 book10 = new TestInsertBook10();
//        book10.testMethod();
//        TesteUpdateBook10 testUpdateBook = new TesteUpdateBook10();
//        testUpdateBook.testMethod();
//        TestRemoveMovie10 rmMovie = new TestRemoveMovie10();
//        rmMovie.testMethod();
       
    }
}
