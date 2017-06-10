package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class Publishers implements Serializable {

    @Id
    private int publisher_id;
    private String publisherName;
    private String publisherAbout;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "country_id")
    private Countries publisherCountry;

    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "bookPublisher")
    private List<Books> books;

    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "mangaPublisher")
    private List<Mangas> mangas;

    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "hqPublisher")
    private List<HQS> hqs;

    /*--------------------Constructors-------------------*/
    public Publishers() {
    }

    public Publishers(int publisher_id, String publisherName, Countries publisherCountry, String publisherAbout) {
        this.publisher_id = publisher_id;
        this.publisherName = publisherName;
        this.publisherAbout = publisherAbout;
        this.publisherCountry = publisherCountry;
    }

    /*--------------------Constructors-------------------*/
    public int getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(int publisher_id) {
        this.publisher_id = publisher_id;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getPublisherAbout() {
        return publisherAbout;
    }

    public void setPublisherAbout(String publisherAbout) {
        this.publisherAbout = publisherAbout;
    }

    public Countries getPublisherCountry() {
        return publisherCountry;
    }

    public void setPublisherCountry(Countries publisherCountry) {
        this.publisherCountry = publisherCountry;
    }

    public List<Books> getBooks() {
        return books;
    }

    public void setBooks(List<Books> books) {
        this.books = books;
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

}
