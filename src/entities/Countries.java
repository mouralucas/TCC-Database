package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
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
public class Countries implements Serializable {

    @Id
    private int country_id;
    private String countryName;
    private int priority;
    
    /*--------relações com livros-------------*/
    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "publisherCountry")
    private List<Publishers> publishers;

    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "authorCountry")
    private List<Authors> authors;
    /*----fim relações com livros-------------*/

 /*--------relações com filmes e series-------------*/
    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "directorCountry")
    private List<Directors> directors;

    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "actorCountry")
    private List<Actors> actors;

    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "writerCountry")
    private List<Writers> writers;

    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "networkCountry")
    private List<Networks> networks;

    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "movieCountry")
    private List<Movies> movies;

    /*----fim relações com filmes e series-------------*/
 /*--------------------Constructors-------------------*/
    public Countries() {
    }

    public Countries(int country_id, String countryName, int priority) {
        this.country_id = country_id;
        this.countryName = countryName;
        this.priority = priority;
    }

    /*--------------------Constructors-------------------*/
    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public List<Publishers> getPublishers() {
        return publishers;
    }

    public void setPublishers(List<Publishers> publishers) {
        this.publishers = publishers;
    }

    public List<Authors> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Authors> authors) {
        this.authors = authors;
    }

    public List<Directors> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Directors> directors) {
        this.directors = directors;
    }

    public List<Actors> getActors() {
        return actors;
    }

    public void setActors(List<Actors> actors) {
        this.actors = actors;
    }

    public List<Writers> getWriters() {
        return writers;
    }

    public void setWriters(List<Writers> writers) {
        this.writers = writers;
    }

    public List<Networks> getNetworks() {
        return networks;
    }

    public void setNetworks(List<Networks> networks) {
        this.networks = networks;
    }

    public List<Movies> getMovies() {
        return movies;
    }

    public void setMovies(List<Movies> movies) {
        this.movies = movies;
    }
}
