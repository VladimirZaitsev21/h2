package dev.danvega.h2demo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Genre {

    private long id;
    private String title;

    public Genre(String title) {
        this.title = title;
    }
}
