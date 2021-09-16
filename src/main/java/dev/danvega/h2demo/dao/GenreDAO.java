package dev.danvega.h2demo.dao;

import dev.danvega.h2demo.models.Genre;

public interface GenreDAO {

    Genre getById(long id);
    void create(Genre genre);

}
