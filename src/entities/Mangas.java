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
@Table(name = "mangas")
public class Mangas implements Serializable {

    @Id
    @GeneratedValue
    private int manga_id;
    private String mangaISBN;
    private String mangaTitle;
    private int mangaVolume;
    private int mangaPages;
    private Date mangaPublishingDate;
    private double mangaCoverPrice;
    private String mangaSynopsis;
    private String mangaObservation;

    /*Relaçãoe entre livro e autor*/
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Manga_Author",
            joinColumns = @JoinColumn(name = "manga_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Authors> mangaAuthors;

    /*relação entre livro e serie*/
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Manga_BookSerie",
            joinColumns = @JoinColumn(name = "manga_id"),
            inverseJoinColumns = @JoinColumn(name = "bookSerie_id"))
    private List<BookSeries> mangaSeries;

    /*reaciona livro com lingua*/
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Manga_Language",
            joinColumns = @JoinColumn(name = "manga_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id"))
    private List<Languages> mangaLanguages;

    /*relaciona livro com editora*/
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "publisher_id")
    private Publishers mangaPublisher;

    /*relaciona livro com generos*/
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Manga_Genre",
            joinColumns = @JoinColumn(name = "manga_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id)"))
    private List<Genres> mangaGenres;

    public int getManga_id() {
        return manga_id;
    }

    public void setManga_id(int manga_id) {
        this.manga_id = manga_id;
    }

    public String getMangaISBN() {
        return mangaISBN;
    }

    public void setMangaISBN(String mangaISBN) {
        this.mangaISBN = mangaISBN;
    }

    public String getMangaTitle() {
        return mangaTitle;
    }

    public void setMangaTitle(String mangaTitle) {
        this.mangaTitle = mangaTitle;
    }

    public int getMangaVolume() {
        return mangaVolume;
    }

    public void setMangaVolume(int mangaVolume) {
        this.mangaVolume = mangaVolume;
    }

    public int getMangaPages() {
        return mangaPages;
    }

    public void setMangaPages(int mangaPages) {
        this.mangaPages = mangaPages;
    }

    public Date getMangaPublishingDate() {
        return mangaPublishingDate;
    }

    public void setMangaPublishingDate(Date mangaPublishingDate) {
        this.mangaPublishingDate = mangaPublishingDate;
    }

    public double getMangaCoverPrice() {
        return mangaCoverPrice;
    }

    public void setMangaCoverPrice(double mangaCoverPrice) {
        this.mangaCoverPrice = mangaCoverPrice;
    }

    public String getMangaSynopsis() {
        return mangaSynopsis;
    }

    public void setMangaSynopsis(String mangaSynopsis) {
        this.mangaSynopsis = mangaSynopsis;
    }

    public String getMangaObservation() {
        return mangaObservation;
    }

    public void setMangaObservation(String mangaObservation) {
        this.mangaObservation = mangaObservation;
    }

    public List<Authors> getMangaAuthors() {
        return mangaAuthors;
    }

    public void setMangaAuthors(List<Authors> mangaAuthors) {
        this.mangaAuthors = mangaAuthors;
    }

    public List<BookSeries> getMangaSeries() {
        return mangaSeries;
    }

    public void setMangaSeries(List<BookSeries> mangaSeries) {
        this.mangaSeries = mangaSeries;
    }

    public List<Languages> getMangaLanguages() {
        return mangaLanguages;
    }

    public void setMangaLanguages(List<Languages> mangaLanguages) {
        this.mangaLanguages = mangaLanguages;
    }

    public Publishers getMangaPublisher() {
        return mangaPublisher;
    }

    public void setMangaPublisher(Publishers mangaPublisher) {
        this.mangaPublisher = mangaPublisher;
    }

    public List<Genres> getMangaGenres() {
        return mangaGenres;
    }

    public void setMangaGenres(List<Genres> mangaGenres) {
        this.mangaGenres = mangaGenres;
    }
}
