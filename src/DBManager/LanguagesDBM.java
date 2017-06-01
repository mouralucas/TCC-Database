/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBManager;

import Conn.Connection;
import entities.Authors;
import entities.Languages;
import java.util.List;
import javax.persistence.EntityManager;

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
    public boolean insertLanguages(Languages languages) {
        try {
            Connection.getCon().persist(languages);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /*-------------------- Retrieve Languages Querys -------------------------*/
    public List retrieveAllLanguages() {
        return Connection.getCon().createQuery("SELECT l FROM Languages l "
                + "ORDER BY l.languageName").getResultList();
    }

    public List retrieveLanguageByName(String languageName) {
        return Connection.getCon().createQuery("SELECT l FROM Languages l "
                + "WHERE l.languageName LIKE CONCAT('%', :languageName, '%')")
                .setParameter("languageName", languageName).getResultList();
    }

    /*---------------------- Remove Languages Query --------------------------*/
    public void removeLanguage(Languages language) {
        try {
            Connection.getCon().remove(Connection.getCon().find(Languages.class, language.getLanguage_id()));
        } catch (Exception e) {
            Connection.getCon().getTransaction().rollback();
        }
    }

}
