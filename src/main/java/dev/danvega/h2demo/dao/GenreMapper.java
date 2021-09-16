package dev.danvega.h2demo.dao;

import dev.danvega.h2demo.models.Genre;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GenreMapper implements RowMapper<Genre> {
    @Override
    public Genre mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Genre(resultSet.getLong(1),
                resultSet.getString(2));
    }
}
