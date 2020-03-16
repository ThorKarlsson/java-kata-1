package org.echocat.kata.java.part1.repository;

import org.echocat.kata.java.part1.model.Book;
import org.echocat.kata.java.part1.model.Magazine;
import org.echocat.kata.java.part1.model.Publication;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.util.AssertionErrors.assertEquals;

public class PublicationDaoTest {

    private List<Publication> publications;
    private PublicationDao dao;

    @Before
    public void init() {
        publications = new ArrayList<>();
        publications.add(
                Magazine.builder()
                        .isbn("B243")
                        .build()
        );
        publications.add(
                Magazine.builder()
                        .isbn("A12")
                        .build()
        );
        dao = new PublicationDao();
        dao.addAllPublications(publications);
    }

    @Test
    public void testGetPublicationByISBN() {
        Optional<Publication> pub = dao.getPublicationByIsbn("A12");

        assertTrue(pub.isPresent());
        assertEquals("Titles do not match", "A12", pub.get().getIsbn());

        pub = dao.getPublicationByIsbn("BLAH");
        assertFalse(pub.isPresent());
    }
}
