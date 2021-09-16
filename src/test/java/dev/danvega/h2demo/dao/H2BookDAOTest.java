package dev.danvega.h2demo.dao;

import dev.danvega.h2demo.models.Author;
import dev.danvega.h2demo.models.Book;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Тест методов H2AuthorDAO")
@JdbcTest
@Import(H2BookDAO.class)
class H2BookDAOTest {

    @Autowired
    private BookDAO bookDAO;
    @Test
    void getById() {
        Book book = bookDAO.getById(1);
        assertThat(book).hasFieldOrPropertyWithValue("title", "Deep Lake");
    }

    @Test
    void create() {
        Book book = new Book("New Book", 1000, 1, 1);
        bookDAO.create(book);
        Book createdBook = bookDAO.getById(4);
        assertThat(createdBook).hasFieldOrPropertyWithValue("title", "New Book");
    }

    @Test
    void update() {
        Book book = bookDAO.getById(3);
        book.setTitle("Updated title");
        bookDAO.update(book);
        assertThat(book).hasFieldOrPropertyWithValue("title", "Updated title");
    }

    @Test
    void deleteById() {
        bookDAO.deleteById(1);
        assertThat(bookDAO.getById(1)).isNull();
    }

    @Test
    void getAll() {
        List<Book> books = bookDAO.getAll();
        assertThat(books).hasSizeGreaterThanOrEqualTo(2);
    }
}