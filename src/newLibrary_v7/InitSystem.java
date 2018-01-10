package newLibrary_v7;

import Conn.Connection;

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

        Connection con = new Connection();
        con.setCon();
        con.closeCon();
////
//        InsertData insertaDta = new InsertData();
//        insertaDta.insertData();
////
//        TestInsertBook insertBook = new TestInsertBook();
//        insertBook.testMethod();
//        TestInsertMovie55000 movie = new TestInsertMovie55000();
//        movie.testMethod();
//        testeRetrieve trm = new testeRetrieve();
//        trm.retrieve();

//       Retrieve r = new Retrieve();
//       r.testMethod();
    }
}
