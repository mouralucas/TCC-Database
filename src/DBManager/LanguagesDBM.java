package DBManager;

import Conn.Connection;
import entities.Languages;
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

public class LanguagesDBM {

    /*---------------------- Insertion Language Query ------------------------*/
    public boolean insertLanguages(Languages languages, Connection con) {
        try {
            con.getCon().persist(languages);
            return true;
        } catch (Exception e) {
            con.getCon().getTransaction().rollback();
            return false;
        }
    }

    /*-------------------- Retrieve Languages Querys -------------------------*/
    public List retrieveAllLanguages(Connection con) {
        return con.getCon().createQuery("SELECT l FROM Languages l "
                + "ORDER BY l.languageName").getResultList();
    }

    public List retrieveLanguageByName(String languageName, Connection con) {
        return con.getCon().createQuery("SELECT l FROM Languages l "
                + "WHERE l.languageName LIKE CONCAT('%', :languageName, '%')")
                .setParameter("languageName", languageName).getResultList();
    }

    /*---------------------- Remove Languages Query --------------------------*/
    public void removeLanguage(Languages language, Connection con) {
        try {
            con.getCon().remove(con.getCon().find(Languages.class, language.getLanguage_id()));
        } catch (Exception e) {
            con.getCon().getTransaction().rollback();
        }
    }

}
