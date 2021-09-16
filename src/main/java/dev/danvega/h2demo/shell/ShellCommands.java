package dev.danvega.h2demo.shell;

import dev.danvega.h2demo.dao.AuthorDAO;
import dev.danvega.h2demo.dao.BookDAO;
import dev.danvega.h2demo.dao.GenreDAO;
import dev.danvega.h2demo.models.Author;
import dev.danvega.h2demo.models.Book;
import dev.danvega.h2demo.models.Genre;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import org.h2.tools.Console;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@ShellComponent
public class ShellCommands {

    private final AuthorDAO jdbcAuthor;
    private final GenreDAO jdbcGenreDao;
    private final BookDAO jdbcBookDao;

    public ShellCommands(AuthorDAO jdbcAuthor, GenreDAO jdbcGenreDao, BookDAO jdbcBookDao) {
        this.jdbcAuthor = jdbcAuthor;
        this.jdbcGenreDao = jdbcGenreDao;
        this.jdbcBookDao = jdbcBookDao;
    }

    @ShellMethod(value = "run H2 console", key = {"console"})
    public String runConsoleH2() throws SQLException {
        Console.main();
        return "Консоль H2 запущена";
    }

    @ShellMethod(value = "add Author to DB", key = {"add-author"})
    public String addAuthor(@ShellOption String firstName,
                            @ShellOption String lastName,
                            @ShellOption long age) throws SQLException, ParseException {
        Author author = new Author(firstName, lastName, age);
        jdbcAuthor.save(author);
        return String.format("Автор %s добавлен", author);
    }

    @ShellMethod(value = "get Author from DB by firstName", key = {"get-author-by-firstName"})
    public String getAuthorByFirstName(@ShellOption String firstName) {
        Author author = jdbcAuthor.getByFirstName(firstName);
        return author.toString();
    }

    @ShellMethod(value = "get Author from DB by id", key = {"get-author-by-id"})
    public String getAuthorByFirstName(@ShellOption long id) {
        Author author = jdbcAuthor.getById(id);
        return author.toString();
    }

    @ShellMethod(value = "delete book from DB", key = {"delete-book"})
    public String deleteBook(@ShellOption long id) throws SQLException {
        jdbcBookDao.deleteById(id);
        return String.format("Книга id=%s удалена", id);
    }

    @ShellMethod(value = "get book from DB", key = {"get-book"})
    public String getBook(@ShellOption long id) throws SQLException {
        Book book = jdbcBookDao.getById(id);
        return book.toString();
    }


    @ShellMethod(value = "add book to DB", key = {"add-book"})
    public String addBook(@ShellOption String title,
                          @ShellOption long recommendedPrice,
                          @ShellOption long authorId,
                          @ShellOption long genreId) {
        Book book = new Book(title, recommendedPrice, authorId, genreId);
        jdbcBookDao.create(book);
        return "Книга " + book.toString() + "добавлена!";
    }

    @ShellMethod(value = "get all books from DB", key = {"get-books"})
    public String getAllBooks() {
        List<Book> books = jdbcBookDao.getAll();
        return books.toString();
    }

    @ShellMethod(value = "update Book in DB", key = {"update-book"})
    public String updateBook(@ShellOption long bookId,
                             @ShellOption String bookTitle,
                             @ShellOption long recommendedPrice,
                             @ShellOption long authorId,
                             @ShellOption long genreId) {
        Book book = new Book(bookId, bookTitle, recommendedPrice, authorId, genreId);
        jdbcBookDao.update(book);
        return String.format("Book %d updated!", bookId);
    }

    @ShellMethod(value = "get genre by id", key = {"get-genre-by-id"})
    public String getGenreById(@ShellOption long id) {
        return jdbcGenreDao.getById(id).toString();
    }

    @ShellMethod(value = "create genre in DB", key = {"create-genre"})
    public String createGenre(@ShellOption String genreTitle) {
        jdbcGenreDao.create(new Genre(genreTitle));
        return String.format("Genre \"%s\" has been added.", genreTitle);
    }

}