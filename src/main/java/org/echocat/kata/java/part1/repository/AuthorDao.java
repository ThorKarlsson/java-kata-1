package org.echocat.kata.java.part1.repository;

import org.echocat.kata.java.part1.model.Author;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AuthorDao {

    private final List<Author> authors;

    public AuthorDao() {
        authors = new ArrayList<>();
    }

    public void addAllAuthors(List<Author> authors) {
        this.authors.addAll(authors);
    }

}
