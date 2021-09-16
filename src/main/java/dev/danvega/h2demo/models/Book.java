package dev.danvega.h2demo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Book {

    private long id;
    private String title;
    private long recommendedPrice;
    private long authorId;
    private long genreId;

    public Book(String title, long recommendedPrice, long authorId, long genreId) {
        this.title = title;
        this.recommendedPrice = recommendedPrice;
        this.authorId = authorId;
        this.genreId = genreId;
    }
}
