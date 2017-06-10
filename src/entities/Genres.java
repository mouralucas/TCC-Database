package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

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
public class Genres implements Serializable {

    @Id
    private int genre_id;
    private String genreName;

    public int getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(int genre_id) {
        this.genre_id = genre_id;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    /*----------Relações com publicações impressas-----------*/
    @ManyToMany(mappedBy = "bookGenres")
    private List<Books> boooks;

    @ManyToMany(mappedBy = "mangaGenres")
    private List<Mangas> mangas;

    @ManyToMany(mappedBy = "hqGenres")
    private List<HQS> hqs;
    /*------Fim das Relações com publicações impressas-------*/

    /*----------Relações com Filmes e Séries-----------*/
    @ManyToMany(mappedBy = "movieGenres")
    private List<Movies> movies;

    @ManyToMany(mappedBy = "tvSerieGenres")
    private List<TVSeries> tvSeries;

    /*------Fim das Relações com Filmes e Séries-------*/

    /*--------------------Constructors-------------------*/
    public Genres() {
    }

    public Genres(int genre_id, String genreName) {
        this.genre_id = genre_id;
        this.genreName = genreName;
    }

    /*--------------------Constructors-------------------*/
    public List<Books> getBoooks() {
        return boooks;
    }

    public void setBoooks(List<Books> boooks) {
        this.boooks = boooks;
    }

    public List<Mangas> getMangas() {
        return mangas;
    }

    public void setMangas(List<Mangas> mangas) {
        this.mangas = mangas;
    }

    public List<HQS> getHqs() {
        return hqs;
    }

    public void setHqs(List<HQS> hqs) {
        this.hqs = hqs;
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
