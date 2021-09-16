package dev.danvega.h2demo.dao;

import dev.danvega.h2demo.models.Author;

public interface AuthorDAO {

    Author getById(long id);

    Author getByFirstName(String firstName);

    void save(Author author);

}
