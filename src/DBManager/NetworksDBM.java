package DBManager;

import Conn.Connection;
import entities.Networks;
import java.util.List;

/**
 * @author Jociane Franzoni de Lima
 * @author Lucas Penha de Moura
 *
 * ------------------- Trabalho de Conclusão de Curso ---------------------
 * ---------------------- Engenharia de Computação ------------------------
 * ------------- Universidade Tecnológica Federal do Paraná ---------------
 *
 */
public class NetworksDBM {

    /*---------------------- Insertion Network Query ------------------------*/
    public boolean insertNetworks(Networks network, Connection con) {
        try {
            con.getCon().merge(network);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /*-------------------- Retrieve Nertwork Querys -------------------------*/
    public List retrieveAllNetwork(Connection con) {
        return con.getCon().createQuery(
                "SELECT nt FROM Networks nt "
                + "ORDER BY nt.networkName").getResultList();
    }

    public List retrieveNetworkByName(String networkName, Connection con) {
        return con.getCon().createQuery(
                "SELECT nt FROM Networks nt "
                + "WHERE nt.networkName LIKE CONCAT('%', :networkName, '%')")
                .setParameter("networkName", networkName).getResultList();
    }

    /*---------------------- Remove Network Query --------------------------*/
    public void removeWriter(Networks network, Connection con) {
        try {
            con.getCon().remove(con.getCon().find(Networks.class, network.getNetwork_id()));
        } catch (Exception e) {
            con.getCon().getTransaction().rollback();
        }
    }
}
