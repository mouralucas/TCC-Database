package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "actors")
public class Actors implements Serializable {

    @Id
    @GeneratedValue
    private int actor_id;
    private String actorName;
    private String actorAbout;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id")
    private Countries actorCountry;

    @ManyToMany(mappedBy = "movieActors")
    private List<Movies> movies;

    @ManyToMany(mappedBy = "tvSerieActors")
    private List<TVSeries> tvSeries;

    /*--------------------Constructors-------------------*/
    public Actors() {
    }

    public Actors(String actorName, Countries actorCountry, String actorAbout) {
        this.actorName = actorName;
        this.actorAbout = actorAbout;
        this.actorCountry = actorCountry;
    }

    /*--------------------Constructors-------------------*/
    public int getActor_id() {
        return actor_id;
    }

    public void setActor_id(int actor_id) {
        this.actor_id = actor_id;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public String getActorAbout() {
        return actorAbout;
    }

    public void setActorAbout(String actorAbout) {
        this.actorAbout = actorAbout;
    }

    public Countries getActorCountry() {
        return actorCountry;
    }

    public void setActorCountry(Countries actorCountry) {
        this.actorCountry = actorCountry;
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
