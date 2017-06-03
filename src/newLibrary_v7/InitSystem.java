package newLibrary_v7;

import Conn.Connection;
import t_remove.TestRemoveBook10;

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
        
//      InsertData insertDta = new InsertData();
//      insertDta.insertData();
        TestRemoveBook10 book10 = new TestRemoveBook10();
        book10.testMethod();
        
//        TestInsertBook10 book10 = new TestInsertBook10();
//        book10.testMethod();


        

        
        System.out.println("Connection Done");
        Connection.closeCon();
    }
}
