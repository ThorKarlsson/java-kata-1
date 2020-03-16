package org.echocat.kata.java.part1.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class Publication {

    protected String title;
    protected String isbn;
    protected List<String> authors;

    public Publication(String title, String isbn, List<String> authors) {
        this.title = title;
        this.isbn = isbn;
        this.authors = authors;
    }

    public String print() {
        return "";
    }
}
