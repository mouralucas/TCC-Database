package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
@Table(name = "tvseries")
public class TVSeries implements Serializable {

    @Id
    @GeneratedValue
    private int tvSerie_id;
    private String serieName;
    @Temporal(TemporalType.DATE)
    private Date tvSerieReleaseDate;
    private int tvSerieLenght;
    private String tvSerieSynopsis;

    /*Relaciona TVSerie com Genres*/
    @ManyToMany(cascade = {CascadeType.REFRESH})
    @JoinTable(name = "TVSerie_Genre",
            joinColumns = @JoinColumn(name = "tvSerie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genres> tvSerieGenres;

    /*Relaciona TVSerie com Actors*/
    @ManyToMany(cascade = {CascadeType.REFRESH})
    @JoinTable(name = "TVSerie_Actor",
            joinColumns = @JoinColumn(name = "tvSerie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id"))
    private List<Actors> tvSerieActors;

    /*Relaciona TVSerie com Directors*/
    @ManyToMany(cascade = {CascadeType.REFRESH})
    @JoinTable(name = "TVSerie_Director",
            joinColumns = @JoinColumn(name = "tvSerie_id"),
            inverseJoinColumns = @JoinColumn(name = "director_id"))
    private List<Directors> tvSerieDirectors;

    /*Relacioba TVSerie com writer*/
    @ManyToMany(cascade = {CascadeType.REFRESH})
    @JoinTable(name = "TVSerie_Writer",
            joinColumns = @JoinColumn(name = "tvSeries_id"),
            inverseJoinColumns = @JoinColumn(name = "writer_id"))
    private List<Writers> tvSerieWriters;

    /*Relaciona TVSerie com country*/
    @ManyToOne(cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "country_id")
    private Countries tvSerieCountry;

    /*Relaciona TVSerie com languages*/
    @ManyToOne(cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "language_id")
    private Languages tvSerieLanguage;

    /*Relaciona TVSerie com Network*/
    @ManyToMany(cascade = {CascadeType.REFRESH})
    @JoinTable(name = "TVSerie_Network",
            joinColumns = @JoinColumn(name = "tvSerie_id"),
            inverseJoinColumns = @JoinColumn(name = "network_id"))
    private List<Networks> tvSerieNetworks;

    /*Relaciona Movie com Book*/
    @ManyToMany(cascade = {CascadeType.REFRESH})
    @JoinTable(name = "TVSerie_Book",
            joinColumns = @JoinColumn(name = "tvSerie_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Networks> tvSerieBooks;

    /*--------------------Constructors-------------------*/
    public TVSeries() {
    }

    public TVSeries(String serieName, Date tvSerieReleaseDate, int tvSerieLenght, String tvSerieSynopsis,
            List<Genres> tvSerieGenres, List<Actors> tvSerieActors, List<Directors> tvSerieDirectors,
            List<Writers> tvSerieWriters, Countries tvSerieCountry, Languages tvSerieLanguage,
            List<Networks> tvSerieNetworks, List<Networks> tvSerieBooks) {

        this.serieName = serieName;
        this.tvSerieReleaseDate = tvSerieReleaseDate;
        this.tvSerieLenght = tvSerieLenght;
        this.tvSerieSynopsis = tvSerieSynopsis;
        this.tvSerieGenres = tvSerieGenres; // -> precisa de vetor
        this.tvSerieActors = tvSerieActors; // -> precisa de vetor
        this.tvSerieDirectors = tvSerieDirectors; // -> precisa de vetor
        this.tvSerieWriters = tvSerieWriters; // -> precisa de vetor
        this.tvSerieCountry = tvSerieCountry; // -> precisa de vetor
        this.tvSerieLanguage = tvSerieLanguage; // -> precisa de vetor
        this.tvSerieNetworks = tvSerieNetworks; // -> precisa de vetor
        this.tvSerieBooks = tvSerieBooks; // -> precisa de vetor
    }

    /*--------------------Constructors-------------------*/
    public int getTvSerie_id() {
        return tvSerie_id;
    }

    public void setTvSerie_id(int tvSerie_id) {
        this.tvSerie_id = tvSerie_id;
    }

    public String getSerieName() {
        return serieName;
    }

    public void setSerieName(String serieName) {
        this.serieName = serieName;
    }

    public Date getTvSerieReleaseDate() {
        return tvSerieReleaseDate;
    }

    public void setTvSerieReleaseDate(Date tvSerieReleaseDate) {
        this.tvSerieReleaseDate = tvSerieReleaseDate;
    }

    public int getTvSerieLenght() {
        return tvSerieLenght;
    }

    public void setTvSerieLenght(int tvSerieLenght) {
        this.tvSerieLenght = tvSerieLenght;
    }

    public String getTvSerieSynopsis() {
        return tvSerieSynopsis;
    }

    public void setTvSerieSynopsis(String tvSerieSynopsis) {
        this.tvSerieSynopsis = tvSerieSynopsis;
    }

    public List<Genres> getTvSerieGenres() {
        return tvSerieGenres;
    }

    public void setTvSerieGenres(List<Genres> tvSerieGenres) {
        this.tvSerieGenres = tvSerieGenres;
    }

    public List<Actors> getTvSerieActors() {
        return tvSerieActors;
    }

    public void setTvSerieActors(List<Actors> tvSerieActors) {
        this.tvSerieActors = tvSerieActors;
    }

    public List<Directors> getTvSerieDirectors() {
        return tvSerieDirectors;
    }

    public void setTvSerieDirectors(List<Directors> tvSerieDirectors) {
        this.tvSerieDirectors = tvSerieDirectors;
    }

    public List<Writers> getTvSerieWriters() {
        return tvSerieWriters;
    }

    public void setTvSerieWriters(List<Writers> tvSerieWriters) {
        this.tvSerieWriters = tvSerieWriters;
    }

    public Countries getTvSerieCountry() {
        return tvSerieCountry;
    }

    public void setTvSerieCountry(Countries tvSerieCountry) {
        this.tvSerieCountry = tvSerieCountry;
    }

    public Languages getTvSerieLanguage() {
        return tvSerieLanguage;
    }

    public void setTvSerieLanguage(Languages tvSerieLanguage) {
        this.tvSerieLanguage = tvSerieLanguage;
    }

    public List<Networks> getTvSerieNetworks() {
        return tvSerieNetworks;
    }

    public void setTvSerieNetworks(List<Networks> tvSerieNetworks) {
        this.tvSerieNetworks = tvSerieNetworks;
    }

    public List<Networks> getTvSerieBooks() {
        return tvSerieBooks;
    }

    public void setTvSerieBooks(List<Networks> tvSerieBooks) {
        this.tvSerieBooks = tvSerieBooks;
    }

}
