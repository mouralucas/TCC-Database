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
@Table(name = "hqs")
public class HQS implements Serializable {

    @Id
    @GeneratedValue
    private int hq_id;
    private String hqISBN;
    private String hqTitle;
    private int hqVolume;
    private int hqPages;
    private Date hqPublishingDate;
    private double hqCoverPrice;
    private String hqSynopsis;
    private String hqObservation;

    /*Relaçãoe entre livro e autor*/
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "HQ_Author",
            joinColumns = @JoinColumn(name = "hq_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Authors> hqAuthors;

    /*relação entre livro e serie*/
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "HQ_BookSerie",
            joinColumns = @JoinColumn(name = "hq_id"),
            inverseJoinColumns = @JoinColumn(name = "bookSerie_id"))
    private List<BookSeries> hqSeries;

    /*reaciona livro com lingua*/
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "HQ_Language",
            joinColumns = @JoinColumn(name = "hq_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id"))
    private List<Languages> hqLanguages;

    /*relaciona livro com editora*/
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "publisher_id")
    private Publishers hqPublisher;

    /*relaciona livro com generos*/
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "HQ_Genre",
            joinColumns = @JoinColumn(name = "hq_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id)"))
    private List<Genres> hqGenres;

    public int getHq_id() {
        return hq_id;
    }

    public void setHq_id(int hq_id) {
        this.hq_id = hq_id;
    }

    public String getHqISBN() {
        return hqISBN;
    }

    public void setHqISBN(String hqISBN) {
        this.hqISBN = hqISBN;
    }

    public String getHqTitle() {
        return hqTitle;
    }

    public void setHqTitle(String hqTitle) {
        this.hqTitle = hqTitle;
    }

    public int getHqVolume() {
        return hqVolume;
    }

    public void setHqVolume(int hqVolume) {
        this.hqVolume = hqVolume;
    }

    public int getHqPages() {
        return hqPages;
    }

    public void setHqPages(int hqPages) {
        this.hqPages = hqPages;
    }

    public Date getHqPublishingDate() {
        return hqPublishingDate;
    }

    public void setHqPublishingDate(Date hqPublishingDate) {
        this.hqPublishingDate = hqPublishingDate;
    }

    public double getHqCoverPrice() {
        return hqCoverPrice;
    }

    public void setHqCoverPrice(double hqCoverPrice) {
        this.hqCoverPrice = hqCoverPrice;
    }

    public String getHqSynopsis() {
        return hqSynopsis;
    }

    public void setHqSynopsis(String hqSynopsis) {
        this.hqSynopsis = hqSynopsis;
    }

    public String getHqObservation() {
        return hqObservation;
    }

    public void setHqObservation(String hqObservation) {
        this.hqObservation = hqObservation;
    }

    public List<Authors> getHqAuthors() {
        return hqAuthors;
    }

    public void setHqAuthors(List<Authors> hqAuthors) {
        this.hqAuthors = hqAuthors;
    }

    public List<BookSeries> getHqSeries() {
        return hqSeries;
    }

    public void setHqSeries(List<BookSeries> hqSeries) {
        this.hqSeries = hqSeries;
    }

    public List<Languages> getHqLanguages() {
        return hqLanguages;
    }

    public void setHqLanguages(List<Languages> hqLanguages) {
        this.hqLanguages = hqLanguages;
    }

    public Publishers getHqPublisher() {
        return hqPublisher;
    }

    public void setHqPublisher(Publishers hqPublisher) {
        this.hqPublisher = hqPublisher;
    }

    public List<Genres> getHqGenres() {
        return hqGenres;
    }

    public void setHqGenres(List<Genres> hqGenres) {
        this.hqGenres = hqGenres;
    }
}
