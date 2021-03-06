package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author Jociane Franzoni de Lima
 * @author Lucas Penha de Moura
 *
 * ------------------- Trabalho de Conclusão de Curso ---------------------
 * ---------------------- Engenharia de Computação ------------------------
 * ------------- Universidade Tecnológica Federal do Paraná ---------------
 *
 */

@Entity
public class Directors implements Serializable {

    @Id
    private int director_id;
    private String directorName;
    private String directorAbout;

    /*relaciona director com um pais*/
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "country_id")
    private Countries directorCountry;

    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "movieDirector")
    private List<Movies> movies;

    /*--------------------Constructors-------------------*/
    public Directors() {
    }

    public Directors(int director_id, String directorName, Countries directorCountry, String directorAbout) {
        this.director_id = director_id;
        this.directorName = directorName;
        this.directorAbout = directorAbout;
        this.directorCountry = directorCountry;
    }

    /*--------------------Constructors-------------------*/
    public int getDirector_id() {
        return director_id;
    }

    public void setDirector_id(int director_id) {
        this.director_id = director_id;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getDirectorAbout() {
        return directorAbout;
    }

    public void setDirectorAbout(String directorAbout) {
        this.directorAbout = directorAbout;
    }

    public Countries getDirectorCountry() {
        return directorCountry;
    }

    public void setDirectorCountry(Countries directorCountry) {
        this.directorCountry = directorCountry;
    }

    public List<Movies> getMovies() {
        return movies;
    }

    public void setMovies(List<Movies> movies) {
        this.movies = movies;
    }
}
