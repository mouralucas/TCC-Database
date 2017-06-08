package newLibrary_v7;

import t_Inserts.TestInsertMovie10;

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

//        InsertData insertaDta = new InsertData();
//        insertaDta.insertData();
//            TestRemoveBook10 book10 = new TestRemoveBook10();
//            book10.testMethod();
//        TestInsertMovie10 movie10 = new TestInsertMovie10();
//        movie10.testMethod();

    for(int i = 0; i < 2; i++){
        TestInsertMovie10 movie10 = new TestInsertMovie10();
        movie10.testMethod();
    }
//        TestRemoveMovie10 rmMovie = new TestRemoveMovie10();
//        rmMovie.testMethod();
//        Connection.closeCon();
    }
}
