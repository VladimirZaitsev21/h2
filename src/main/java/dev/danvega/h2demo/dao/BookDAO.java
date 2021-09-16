package dev.danvega.h2demo.dao;

import dev.danvega.h2demo.models.Book;

import java.util.List;

public interface BookDAO {
    Book getById(long id);
    void create(Book book);
    void update(Book book);
    void deleteById(long book);
    List<Book> getAll();
}
