package newLibrary_v7;

import Conn.Connection;
import entities.Languages;

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
    public static void main(String args[]){
        Connection.setCon();
        InsertLanguages il = new InsertLanguages();
        il.insert();
        

        Languages l2 = Connection.getCon().find(Languages.class, 1);
        if (l2 != null) {
            System.out.println("Name: " + l2.getLanguageName());
        } else {
            System.out.println("Error");
        }
    }
}
