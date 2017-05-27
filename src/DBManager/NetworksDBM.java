package DBManager;

import Conn.Connection;
import entities.Networks;
import entities.Writers;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Lucas
 */
public class NetworksDBM {

    /*---------------------- Insertion Network Query ------------------------*/
    public boolean insertNetworks(Networks network, EntityManager em) {
        try {
            em.merge(network);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /*-------------------- Retrieve Nertwork Querys -------------------------*/
    public List retrieveAllNetwork() {
        return Connection.getCon().createQuery("SELECT nt FROM Networks nt "
                + "ORDER BY nt.networkName").getResultList();
    }

    public List retrieveNetworkByName(String networkName) {
        return Connection.getCon().createQuery("SELECT nt FROM Networks nt "
                + "WHERE nt.networkName LIKE CONCAT('%', :networkName, '%')")
                .setParameter("networkName", networkName).getResultList();
    }

    /*---------------------- Remove Network Query --------------------------*/
    public void removeWriter(Networks network) {
        try {
            Connection.getCon().remove(Connection.getCon().find(Networks.class, network.getNetwork_id()));
        } catch (Exception e) {
            Connection.getCon().getTransaction().rollback();
        }
    }
}
