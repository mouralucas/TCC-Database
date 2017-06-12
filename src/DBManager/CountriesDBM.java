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
    public boolean insertCountries(Countries country, Connection con) {
        try {
            con.getCon().merge(country);
            return true;
        } catch (Exception e) {
            con.getCon().getTransaction().rollback();
            return false;
        }
    }

    /*-------------------------Retrieve Country Querys ------------------------*/
    public List retrieveAllCountries(Connection con) {
        return con.getCon().createQuery("SELECT c FROM Countries c "
                + "ORDER BY c.countryName").getResultList();
    }

    public List retrieveCountryByName(String countryName, Connection con) {
        return con.getCon().createQuery("SELECT c FROM Countries c "
                + "WHERE c.countryName LIKE CONCAT('%', :countryName, '%')")
                .setParameter("countryName", countryName).getResultList();
    }

    /*------------------------- Remove Country Query --------------------------*/
    public void removeCountry(Countries country, Connection con) {
        try {
            con.getCon().remove(con.getCon()
                    .find(Countries.class, country.getCountry_id()));
        } catch (Exception e) {
            con.getCon().getTransaction().rollback();
        }
    }
}
