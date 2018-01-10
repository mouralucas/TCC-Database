package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
public class Languages implements Serializable {

    @Id
    private int language_id;
    private String languageName;
    private int priority;

    /*relaciona movie com language*/
    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "movieLanguage")
    private List<Movies> movies;

    /*relaciona autor com lingua de escrita*/
    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "authorLanguage")
    private List<Authors> authors;

    /*relaciona livro com os idiamas contidos nele*/
    @ManyToMany(mappedBy = "bookLanguages")
    private List<Books> books;


    /*--------------------Constructors-------------------*/
    public Languages() {
    }

    public Languages(int id, String languageName, int priority) {
        this.language_id = id;
        this.languageName = languageName;
        this.priority = priority;
    }

    /*--------------------Constructors-------------------*/
    public int getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(int language_id) {
        this.language_id = language_id;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public List<Movies> getMovies() {
        return movies;
    }

    public void setMovies(List<Movies> movies) {
        this.movies = movies;
    }

    public List<Authors> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Authors> authors) {
        this.authors = authors;
    }

    public List<Books> getBooks() {
        return books;
    }

    public void setBooks(List<Books> books) {
        this.books = books;
    }
}
