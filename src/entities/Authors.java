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
public class Authors implements Serializable {

    @Id
    private int author_id;
    private String authorName;
    private String authorAbout;

    /*Relaciona autor com um lingua*/
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "language_id")
    private Languages authorLanguage;

    /*relaciona author com um pais*/
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "country_id")
    private Countries authorCountry;

    /*relaciona autor com livro*/
    @ManyToMany(mappedBy = "bookAuthors")
    private List<Books> books;

    /*--------------------Constructors-------------------*/
    public Authors() {
    }

    public Authors(int author_id, String authorName, Languages authorLanguage, Countries authorCountry, String authorAbout) {
        this.author_id = author_id;
        this.authorName = authorName;
        this.authorAbout = authorAbout;
        this.authorLanguage = authorLanguage;
        this.authorCountry = authorCountry;
    }

    /*--------------------Constructors-------------------*/
    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorAbout() {
        return authorAbout;
    }

    public void setAuthorAbout(String authorAbout) {
        this.authorAbout = authorAbout;
    }

    public Languages getAuthorLanguage() {
        return authorLanguage;
    }

    public void setAuthorLanguage(Languages authorLanguage) {
        this.authorLanguage = authorLanguage;
    }

    public Countries getAuthorCountry() {
        return authorCountry;
    }

    public void setAuthorCountry(Countries authorCountry) {
        this.authorCountry = authorCountry;
    }

    public List<Books> getBooks() {
        return books;
    }

    public void setBooks(List<Books> books) {
        this.books = books;
    }
}
