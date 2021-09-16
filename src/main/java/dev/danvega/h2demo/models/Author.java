package dev.danvega.h2demo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Author {

    private long id;
    private String firstName;
    private String lastName;
    private double age;

    public Author(String firstName, String lastName, double age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
}
