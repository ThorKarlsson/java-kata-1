package org.echocat.kata.java.part1.repository;

import org.echocat.kata.java.part1.model.Magazine;
import org.echocat.kata.java.part1.model.Publication;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PublicationDao {

    private final List<Publication> publications;

    public PublicationDao() {
        publications = new ArrayList<>();
    }

    public void addAllPublications(List<Publication> publications) {
        this.publications.addAll(publications);
    }

    public List<Publication> getPublications() {
        return new ArrayList<>(publications);
    }

    public Optional<Publication> getPublicationByIsbn(String isbn) {
        return publications.stream()
                .filter(p -> p.getIsbn().equals(isbn))
                .findFirst();

    }

    public List<Publication> getPublicationsByAuthor(String email) {
        return publications.stream()
                .filter(p -> p.getAuthors().contains(email))
                .collect(Collectors.toList());
    }

}
