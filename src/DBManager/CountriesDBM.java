package DBManager;

import Conn.Connection;
import entities.Countries;
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

public class CountriesDBM {

    /*----------------------- Insertion Country Query -------------------------*/
    public boolean insertCountries(Countries country) {
        try {
            Connection.getCon().merge(country);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /*-------------------------Retrieve Country Querys ------------------------*/
    public List retrieveAllCountries() {
        return Connection.getCon().createQuery("SELECT c FROM Countries c "
                + "ORDER BY c.countryName").getResultList();
    }

    public List retrieveCountryByName(String countryName) {
        return Connection.getCon().createQuery("SELECT c FROM Countries c "
                + "WHERE c.countryName LIKE CONCAT('%', :countryName, '%')")
                .setParameter("countryName", countryName).getResultList();
    }

    /*------------------------- Remove Country Query --------------------------*/
    public void removeCountry(Countries country) {
        try {
            Connection.getCon()
                    .remove(Connection.getCon()
                            .find(Countries.class, country.getCountry_id()));
        } catch (Exception e) {
            e.printStackTrace();
            Connection.getCon().getTransaction().rollback();
        }
    }
}
