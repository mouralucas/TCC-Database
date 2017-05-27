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
@Table(name = "books")
public class Books implements Serializable {

    @Id
    @GeneratedValue
    private int book_id;
    private String bookISBN;
    private String bookTitle;
    private String bookSubTitle;
    private int booksPages;
    private Date bookPublishingDate;
    private double bookCoverPrice;
    private int bookEdition;
    private String bookSynopsis;
    private String bookObservation;

    /*Relações entre livro e autor*/
    @ManyToMany(cascade = {CascadeType.REFRESH})
    @JoinTable(name = "Book_Author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Authors> bookAuthors;

    /*relação entre livro e serie*/
    @ManyToMany(cascade = {CascadeType.REFRESH})
    @JoinTable(name = "Book_BookSerie",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "bookSerie_id"))
    private List<BookSeries> bookSeries;

    /*reaciona livro com lingua*/
    @ManyToMany(cascade = {CascadeType.REFRESH})
    @JoinTable(name = "Book_Language",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id"))
    private List<Languages> bookLanguages;

    /*relaciona livro com editora*/
    @ManyToOne(cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "publisher_id")
    private Publishers bookPublisher;

    /*Relaciona Book com Genres*/
    @ManyToMany(cascade = {CascadeType.REFRESH})
    @JoinTable(name = "Book_Genre",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genres> bookGenres;
    
    @ManyToMany(mappedBy = "movieBooks")
    private List<Movies> movies;

    @ManyToMany(mappedBy = "tvSerieBooks")
    private List<TVSeries> tvSeries;

    /*--------------------Constructors-------------------*/
    public Books() {
    }

    public Books(String bookISBN, String bookTitle, String bookSubTitle, int booksPages, 
            Date bookPublishingDate, double bookCoverPrice, int bookEdition, 
            String bookSynopsis, String bookObservation, List<Authors> bookAuthors,
            List<BookSeries> bookSeries, List<Languages> bookLanguages, Publishers bookPublisher,
            List<Genres> bookGenres) {
        this.bookISBN = bookISBN;
        this.bookTitle = bookTitle;
        this.bookSubTitle = bookSubTitle;
        this.booksPages = booksPages;
        this.bookPublishingDate = bookPublishingDate;
        this.bookCoverPrice = bookCoverPrice;
        this.bookEdition = bookEdition;
        this.bookSynopsis = bookSynopsis;
        this.bookObservation = bookObservation;
        this.bookAuthors = bookAuthors; //-> precisa de vetor
        this.bookSeries = bookSeries; //-> precisa de vetor
        this.bookLanguages = bookLanguages; //-> precisa de vetor
        this.bookPublisher = bookPublisher; //-> precisa de vetor
        this.bookGenres = bookGenres; // -> precisa de vetor
    }

    /*--------------------Constructors-------------------*/
    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getBookISBN() {
        return bookISBN;
    }

    public void setBookISBN(String bookISBN) {
        this.bookISBN = bookISBN;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookSubTitle() {
        return bookSubTitle;
    }

    public void setBookSubTitle(String bookSubTitle) {
        this.bookSubTitle = bookSubTitle;
    }

    public int getBooksPages() {
        return booksPages;
    }

    public void setBooksPages(int booksPages) {
        this.booksPages = booksPages;
    }

    public Date getBookPublishingDate() {
        return bookPublishingDate;
    }

    public void setBookPublishingDate(Date bookPublishingDate) {
        this.bookPublishingDate = bookPublishingDate;
    }

    public double getBookCoverPrice() {
        return bookCoverPrice;
    }

    public void setBookCoverPrice(double bookCoverPrice) {
        this.bookCoverPrice = bookCoverPrice;
    }

    public int getBookEdition() {
        return bookEdition;
    }

    public void setBookEdition(int bookEdition) {
        this.bookEdition = bookEdition;
    }

    public String getBookSynopsis() {
        return bookSynopsis;
    }

    public void setBookSynopsis(String bookSynopsis) {
        this.bookSynopsis = bookSynopsis;
    }

    public String getBookObservation() {
        return bookObservation;
    }

    public void setBookObservation(String bookObservation) {
        this.bookObservation = bookObservation;
    }

    public List<Authors> getBookAuthors() {
        return bookAuthors;
    }

    public void setBookAuthors(List<Authors> bookAuthors) {
        this.bookAuthors = bookAuthors;
    }

    public List<BookSeries> getBookSeries() {
        return bookSeries;
    }

    public void setBookSeries(List<BookSeries> bookSeries) {
        this.bookSeries = bookSeries;
    }

    public List<Languages> getBookLanguages() {
        return bookLanguages;
    }

    public void setBookLanguages(List<Languages> bookLanguages) {
        this.bookLanguages = bookLanguages;
    }

    public Publishers getBookPublisher() {
        return bookPublisher;
    }

    public void setBookPublisher(Publishers bookPublisher) {
        this.bookPublisher = bookPublisher;
    }

    public List<Genres> getBookGenres() {
        return bookGenres;
    }

    public void setBookGenres(List<Genres> bookGenres) {
        this.bookGenres = bookGenres;
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
