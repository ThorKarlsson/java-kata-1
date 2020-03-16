package org.echocat.kata.java.part1.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class Book extends Publication {
    private String description;

    @Builder
    public Book(String title, String isbn, List<String> authors, String description) {
        super(title, isbn, authors);
        this.description = description;
    }

    @Override
    public String print() {
        return "Book: " + title + " - " + isbn + " - " + description + " by " + String.join(",", authors);
    }
}
