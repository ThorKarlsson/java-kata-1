package org.echocat.kata.java.part1.controllers;

import org.echocat.kata.java.part1.exceptions.NotFoundException;
import org.echocat.kata.java.part1.model.Publication;
import org.echocat.kata.java.part1.service.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/publications")
public class PublicationController {

    @Autowired
    private PublicationService publicationService;

    @RequestMapping
    public List<Publication> getAllPublications() {
        return publicationService.getAllPublications();
    }

    @RequestMapping("/sort")
    public List<Publication> getSortedPublications() {
        return publicationService.getSortedPublications();
    }

    @RequestMapping("/isbn/{isbn}")
    public Publication getPublicationById(@PathVariable("isbn") String isbn) {
        return publicationService.getPublicationByIsbn(isbn).orElseThrow(() -> new NotFoundException("No publication found with that ISBN"));
    }

    @RequestMapping("/author/{email}")
    public List<Publication> getPublicationsByAuthorEmail(@PathVariable("email") String email) {
        return publicationService.getPublicationsByAuthor(email);
    }
}
