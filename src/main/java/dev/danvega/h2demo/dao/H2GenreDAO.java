package dev.danvega.h2demo.dao;

import dev.danvega.h2demo.models.Genre;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class H2GenreDAO implements GenreDAO {

    private final NamedParameterJdbcOperations jdbc;

    public H2GenreDAO(NamedParameterJdbcOperations jdbc) {
        this.jdbc = jdbc;
    }


    @Override
    public Genre getById(long id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        return jdbc.queryForObject("SELECT * FROM GENRES WHERE ID = :id",
                            params,
                            new GenreMapper());
    }

    @Override
    public void create(Genre genre) {
        Map<String, Object> params = new HashMap<>();
        params.put("title", genre.getTitle());
        jdbc.update("INSERT INTO GENRES (TITLE) VALUES (:title);",
                    params);
    }
}
