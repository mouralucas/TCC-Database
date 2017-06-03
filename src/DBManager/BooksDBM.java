package DBManager;

import Conn.Connection;
import entities.Books;
import java.util.List;
import javax.persistence.Query;

/**
 * @author Jociane Franzoni de Lima
 * @author Lucas Penha de Moura
 *
 * ------------------- Trabalho de Conclusão de Curso ---------------------
 * ---------------------- Engenharia de Computação ------------------------
 * ------------- Universidade Tecnológica Federal do Paraná ---------------
 *
 */
public class BooksDBM {

    /*----------------------- Insertion Book Query -------------------------*/
    public boolean insertBook(Books books) {
        try {
            Connection.getCon().merge(books);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /*-------------------------Retrieve Book Query -------------------------*/
    public List retrieveAllBooks() {
        return Connection.getCon().createQuery("SELECT b FROM Books b "
                + "ORDER BY b.bookTitle").getResultList();
    }

    public List retrieveBookByTitle(String bookTitle) {
        return Connection.getCon().createQuery("SELECT b FROM Books b "
                + "WHERE b.bookTitle LIKE CONCAT('%',:bookTitle,'%')")
                .setParameter("bookTitle", bookTitle)
                .getResultList();
    }

    //Query that'll be used in the test
    public List retrieveBookByMultipleValues(String isbn, String title, String author, String serie, String publisher) {
        return Connection.getCon().createQuery("SELECT "
                + "b.bookISBN, b.bookTitle, a.authorName, bs.bookSerieName, p.publisherName "
                + "FROM Books b "
                + "INNER JOIN b.bookAuthors a "
                + "INNER JOIN b.bookSeries bs "
                + "INNER JOIN b.bookPublisher p "
                + "WHERE "
                + "b.bookISBN LIKE CONCAT('%',:bookISBN,'%') OR "
                + "b.bookTitle LIKE CONCAT('%',:bookTitle,'%') OR "
                + "a.authorName  LIKE CONCAT('%',:authorName,'%') OR "
                + "bs.bookSerieName LIKE CONCAT('%',:bookSerieName,'%') OR "
                + "p.publisherName  LIKE CONCAT('%',:bookPublisher,'%')")
                .setParameter("bookISBN", isbn)
                .setParameter("bookTitle", title)
                .setParameter("authorName", author)
                .setParameter("bookSerieName", serie)
                .setParameter("bookPublisher", publisher)
                .getResultList();
    }
//    (select ba.book_id from book_author ba inner join authors a on ba.author_id = a.author_id where a.author_id =
//    (select a.author_id
//    FROM authors a INNER JOIN languages l ON l.language_id = a.language_id where l.languageName like "%auctor"));

    public List retrieveBookByAuthorByLanguage(String languageName) {
//        Query queryAuthorLanguage = Connection.getCon().createQuery("SELECT ";
//                + "a.author_id "
//                + "FROM Authors a "
//                + "INNER JOIN a.authorLanguage l "
//                + "WHERE "
//                + "l.languageName LIKE CONCAT('%',:languageName,'%')"
//        ).setParameter("languageName", languageName);

//Verificar porque a pesquisa não retornou corretamente
        Query queryBook_Author = Connection.getCon().createQuery("SELECT "
                + "b "
                + "FROM Books b "
                + "JOIN Authors a"
                + " WHERE a.author_id = "
                + "(SELECT "
                + "a.author_id "
                + "FROM Authors a "
                + "INNER JOIN a.authorLanguage l "
                + "WHERE "
                + "l.languageName LIKE CONCAT('%',:languageName,'%'))"
        ).setParameter("languageName", languageName);
        return queryBook_Author.getResultList();
    }

    /*------------------------- Remove Book Query --------------------------*/
    public void removeBook(Books book) {
        try {
            Connection.getCon().remove(Connection.getCon().find(Books.class, book.getBook_id()));
        } catch (Exception e) {
            e.printStackTrace();
            Connection.getCon().getTransaction().rollback();
        }
    }
}
