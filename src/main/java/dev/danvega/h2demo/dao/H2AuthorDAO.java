package dev.danvega.h2demo.dao;

import dev.danvega.h2demo.models.Author;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class H2AuthorDAO implements AuthorDAO {

    private final NamedParameterJdbcOperations jdbc;

    public H2AuthorDAO(NamedParameterJdbcOperations jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Author getById(long id) {
        final Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        return jdbc.queryForObject("SELECT * FROM AUTHORS WHERE ID = :id;",
                params,
                new AuthorMapper());
    }

    @Override
    public Author getByFirstName(String firstName) {
        final Map<String, Object> params = new HashMap<>();
        params.put("firstName", firstName);
        return jdbc.queryForObject("SELECT * FROM AUTHORS WHERE FIRSTNAME = :firstName;",
                params,
                new AuthorMapper());
    }

    @Override
    public void save(Author author) {
        final Map<String, Object> params = new HashMap<>();
        params.put("firstName", author.getFirstName());
        params.put("lastName", author.getFirstName());
        params.put("age", author.getAge());
        jdbc.update("INSERT INTO AUTHORS (FIRSTNAME, LASTNAME, AGE) VALUES (:firstName, :lastName, :age)",
                    params);
    }
}
