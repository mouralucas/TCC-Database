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
@Table(name = "movies")
public class Movies implements Serializable {

    @Id
    @GeneratedValue
    private int movie_id;
    private String movieTitle;
    private String movieSubTitle;
    private Date movieReleaseDate;
    private int movieLenght;
    private String movieSynopsis;

    /*One to Many*/
	/*Relaciona Movie com Directors*/
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "director_id")
    private Directors movieDirector;

    /*Relaciona movie com country*/
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id")
    private Countries movieCountry;

    /*Relaciona movie com languages*/
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "language_id")
    private Languages movieLanguage;

    /*Many to Many*/
	/*Relacioba movie com writer*/
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Movie_Writer",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "writer_id"))
    private List<Writers> movieWriters;

    /*Relaciona Movie com Genres*/
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Movie_Genre",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genres> movieGenres;

    /*Relaciona Movie com Actors*/
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Movie_Actor",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id"))
    private List<Actors> movieActors;

    /*Relaciona Movie com Network*/
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Movie_Network",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "network_id"))
    private List<Networks> movieNetworks;

    /*Relaciona Movie com Book*/
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Movie_Book",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Books> movieBooks;

    /*--------------------Constructors-------------------*/
    public Movies() {
    }

    public Movies(String movieTitle, String movieSubTitle, Date movieReleaseDate, int movieLenght,
            String movieSynopsis, Directors movieDirector, Countries movieCountry, Languages movieLanguage,
            List<Writers> movieWriters, List<Genres> movieGenres, List<Actors> movieActors, List<Networks> movieNetworks,
            List<Books> movieBooks) {

        this.movieTitle = movieTitle;
        this.movieSubTitle = movieSubTitle;
        this.movieReleaseDate = movieReleaseDate;
        this.movieLenght = movieLenght;
        this.movieSynopsis = movieSynopsis;
        this.movieDirector = movieDirector;         //-> precisa de vetor
        this.movieCountry = movieCountry;           //-> precisa de vetor
        this.movieLanguage = movieLanguage;         //-> precisa de vetor
        this.movieWriters = movieWriters;           //-> precisa de vetor
        this.movieGenres = movieGenres;             //-> precisa de vetor
        this.movieActors = movieActors;             //-> precisa de vetor
        this.movieNetworks = movieNetworks;         //-> precisa de vetor
        this.movieBooks = movieBooks;               //-> precisa de vetor
    }

    /*--------------------Constructors-------------------*/

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieSubTitle() {
        return movieSubTitle;
    }

    public void setMovieSubTitle(String movieSubTitle) {
        this.movieSubTitle = movieSubTitle;
    }

    public Date getMovieReleaseDate() {
        return movieReleaseDate;
    }

    public void setMovieReleaseDate(Date movieReleaseDate) {
        this.movieReleaseDate = movieReleaseDate;
    }

    public int getMovieLenght() {
        return movieLenght;
    }

    public void setMovieLenght(int movieLenght) {
        this.movieLenght = movieLenght;
    }

    public String getMovieSynopsis() {
        return movieSynopsis;
    }

    public void setMovieSynopsis(String movieSynopsis) {
        this.movieSynopsis = movieSynopsis;
    }

    public Directors getMovieDirector() {
        return movieDirector;
    }

    public void setMovieDirector(Directors movieDirector) {
        this.movieDirector = movieDirector;
    }

    public Countries getMovieCountry() {
        return movieCountry;
    }

    public void setMovieCountry(Countries movieCountry) {
        this.movieCountry = movieCountry;
    }

    public Languages getMovieLanguage() {
        return movieLanguage;
    }

    public void setMovieLanguage(Languages movieLanguage) {
        this.movieLanguage = movieLanguage;
    }

    public List<Writers> getMovieWriters() {
        return movieWriters;
    }

    public void setMovieWriters(List<Writers> movieWriters) {
        this.movieWriters = movieWriters;
    }

    public List<Genres> getMovieGenres() {
        return movieGenres;
    }

    public void setMovieGenres(List<Genres> movieGenres) {
        this.movieGenres = movieGenres;
    }

    public List<Actors> getMovieActors() {
        return movieActors;
    }

    public void setMovieActors(List<Actors> movieActors) {
        this.movieActors = movieActors;
    }

    public List<Networks> getMovieNetworks() {
        return movieNetworks;
    }

    public void setMovieNetworks(List<Networks> movieNetworks) {
        this.movieNetworks = movieNetworks;
    }

    public List<Books> getMovieBooks() {
        return movieBooks;
    }

    public void setMovieBooks(List<Books> movieBooks) {
        this.movieBooks = movieBooks;
    }
 

}
