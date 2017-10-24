/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t_retrieve;

import Conn.Connection;
import DBManager.MoviesDBM;
import java.util.List;

/**
 *
 * @author lucas
 */
public class Retrieve {

    public void retrieve() {
        Connection con = new Connection();
        MoviesDBM mdbm = new MoviesDBM();
        con.setCon();
        
        List<Object> retorno;
        
        retorno = mdbm.retrieveTeste("inceptos suspendisse","piroca","anal","","","", con);

        con.closeCon();
        
        System.out.println("Tamanho da piroca: " + retorno.size());
        System.out.println("");
    }
}
