package dev.danvega.h2demo.dao;

import dev.danvega.h2demo.models.Book;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class H2BookDAO implements BookDAO {

    private final NamedParameterJdbcOperations jdbc;

    public H2BookDAO(NamedParameterJdbcOperations jdbc) {
        this.jdbc = jdbc;
    }
    @Override
    public Book getById(long id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        try {
            return jdbc.queryForObject("SELECT * FROM BOOKS WHERE ID = :id;",
                    params,
                    new BookMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void create(Book book) {
        Map<String, Object> params = new HashMap<>();
        params.put("title", book.getTitle());
        params.put("recommendedPrice", book.getRecommendedPrice());
        params.put("authorsId", book.getAuthorId());
        params.put("genresId", book.getGenreId());
        jdbc.update("INSERT INTO BOOKS (TITLE, RECOMMENDED_PRICE, AUTHORS_ID, GENRES_ID) VALUES (:title, :recommendedPrice, :authorsId, :genresId);",
                params);
    }

    @Override
    public void update(Book book) {
        Map<String, Object> params = new HashMap<>();
        params.put("title", book.getTitle());
        params.put("recommendedPrice", book.getRecommendedPrice());
        params.put("authorsId", book.getAuthorId());
        params.put("genresId", book.getGenreId());
        params.put("id", book.getId());
        jdbc.update("UPDATE BOOKS SET TITLE = :title, " +
                        "RECOMMENDED_PRICE = :recommendedPrice, " +
                        "AUTHORS_ID = :authorsId, " +
                        "GENRES_ID = :genresId WHERE ID = :id",
                    params);
    }

    @Override
    public void deleteById(long book) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", book);
        jdbc.update("DELETE FROM BOOKS WHERE ID = :id",
                    params);
    }

    @Override
    public List<Book> getAll() {
        return jdbc.query("SELECT * FROM BOOKS;",
                        new BookMapper());
    }
}
