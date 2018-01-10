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
 * @author Jociane Franzoni de Lima
 * @author Lucas Penha de Moura
 *
 * ------------------- Trabalho de Conclusão de Curso ---------------------
 * ---------------------- Engenharia de Computação ------------------------
 * ------------- Universidade Tecnológica Federal do Paraná ---------------
 *
 */

@Entity
public class Writers implements Serializable {

    @Id
    private int writer_id;
    private String writerName;
    private String writerAbout;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "country_id")
    private Countries writerCountry;

    @ManyToMany(mappedBy = "movieWriters")
    private List<Movies> movie;


    /*--------------------Constructors-------------------*/
    public Writers() {
    }

    public Writers(int writer_id, String writerName, Countries writerCountry, String writerAbout) {
        this.writer_id = writer_id;
        this.writerName = writerName;
        this.writerAbout = writerAbout;
        this.writerCountry = writerCountry;
    }

    /*--------------------Constructors-------------------*/
    public int getWriter_id() {
        return writer_id;
    }

    public void setWriter_id(int writer_id) {
        this.writer_id = writer_id;
    }

    public String getWriterName() {
        return writerName;
    }

    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }

    public String getWriterAbout() {
        return writerAbout;
    }

    public void setWriterAbout(String writerAbout) {
        this.writerAbout = writerAbout;
    }

    public Countries getWriterCountry() {
        return writerCountry;
    }

    public void setWriterCountry(Countries writerCountry) {
        this.writerCountry = writerCountry;
    }

    public List<Movies> getMovie() {
        return movie;
    }

    public void setMovie(List<Movies> movie) {
        this.movie = movie;
    }
}
