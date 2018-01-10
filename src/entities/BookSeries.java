package entities;

import enums.SerieTypeEnum;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

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
public class BookSeries implements Serializable {

    @Id
    private int bookSerie_id;
    private String bookSerieName;
    private int nVolumes;
    private SerieTypeEnum serieType;
    private String serieSynopsis;

    /*relaciona bookSerie com livro*/
    @ManyToMany(mappedBy = "bookSeries")
    private List<Books> books;

    /*--------------------Constructors-------------------*/
    public BookSeries() {
    }

    public BookSeries(int bookSerie_id, String serieName, int nVolumes, SerieTypeEnum serieType, String bookSynopsis) {
        this.bookSerie_id = bookSerie_id;
        this.bookSerieName = serieName;
        this.nVolumes = nVolumes;
        this.serieType = serieType;
        this.serieSynopsis = bookSynopsis;
    }

    /*--------------------Constructors-------------------*/
    public int getBookSerie_id() {
        return bookSerie_id;
    }

    public void setBookSerie_id(int bookSerie_id) {
        this.bookSerie_id = bookSerie_id;
    }

    public String getSerieName() {
        return bookSerieName;
    }

    public void setSerieName(String serieName) {
        this.bookSerieName = serieName;
    }

    public int getnVolumes() {
        return nVolumes;
    }

    public void setnVolumes(int nVolumes) {
        this.nVolumes = nVolumes;
    }

    public SerieTypeEnum getSerieType() {
        return serieType;
    }

    public void setSerieType(SerieTypeEnum serieType) {
        this.serieType = serieType;
    }

    public String getSerieSynopsis() {
        return serieSynopsis;
    }

    public void setSerieSynopsis(String serieSynopsis) {
        this.serieSynopsis = serieSynopsis;
    }

    public List<Books> getBooks() {
        return books;
    }

    public void setBooks(List<Books> books) {
        this.books = books;
    }
}
