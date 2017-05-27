package entities;

import java.io.Serializable;
import java.sql.Blob;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
@Table(name = "directors")
public class Directors implements Serializable {

    @Id
    @GeneratedValue
    private int director_id;
    private String directorName;
    private String directorAbout;

    /*relaciona director com um pais*/
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id")
    private Countries directorCountry;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "movieDirector")
    private List<Movies> movies;

    @ManyToMany(mappedBy = "tvSerieDirectors")
    private List<TVSeries> tvSeries;

    /*--------------------Constructors-------------------*/
    public Directors() {
    }

    public Directors(String directorName, Countries directorCountry, String directorAbout) {
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

    public List<TVSeries> getTvSeries() {
        return tvSeries;
    }

    public void setTvSeries(List<TVSeries> tvSeries) {
        this.tvSeries = tvSeries;
    }

}
