/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author Lucas
 */
@Entity
public class Actors implements Serializable {

    @Id
    private int actor_id;
    private String actorName;
    private String actorAbout;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "country_id")
    private Countries actorCountry;

    @ManyToMany(mappedBy = "movieActors")
    private List<Movies> movies;

    @ManyToMany(mappedBy = "tvSerieActors")
    private List<TVSeries> tvSeries;

    /*--------------------Constructors-------------------*/
    public Actors() {
    }

    public Actors(int actor_id, String actorName, Countries actorCountry, String actorAbout) {
        this.actor_id = actor_id;
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
