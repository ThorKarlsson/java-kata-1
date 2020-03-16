package org.echocat.kata.java.part1.service;

import org.echocat.kata.java.part1.model.Publication;
import org.echocat.kata.java.part1.repository.PublicationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class PublicationService {

    private final PublicationDao dao;

    @Autowired
    public PublicationService(PublicationDao publicationDao) {
        this.dao = publicationDao;
    }

    public List<Publication> getAllPublications() {
        return dao.getPublications();
    }

    public List<Publication> getSortedPublications() {
        List<Publication> publications = dao.getPublications();
        publications.sort(Comparator.comparing(Publication::getTitle));
        return publications;
    }

    public Optional<Publication> getPublicationByIsbn(String isbn) {
        return dao.getPublicationByIsbn(isbn);
    }

    public List<Publication> getPublicationsByAuthor(String email) {
        return dao.getPublicationsByAuthor(email);
    }
}
