package dev.danvega.h2demo.dao;

import dev.danvega.h2demo.models.Book;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookExtractor implements ResultSetExtractor<Book> {
    @Override
    public Book extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        return new Book(
                resultSet.getLong(1),
                resultSet.getString(2),
                resultSet.getLong(3),
                resultSet.getLong(4),
                resultSet.getLong(5)
        );
    }
}
