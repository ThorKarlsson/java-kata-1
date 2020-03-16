package org.echocat.kata.java.part1.service;

import org.echocat.kata.java.part1.model.Book;
import org.echocat.kata.java.part1.model.Magazine;
import org.echocat.kata.java.part1.model.Publication;
import org.echocat.kata.java.part1.repository.PublicationDao;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PublicationServiceTest {

    List<Publication> publications;

    @Before
    public void init() {
        publications = new ArrayList<>();
        publications.add(
                Magazine.builder()
                        .title("XYZ")
                        .build()
        );
        publications.add(
                Magazine.builder()
                        .title("123")
                        .build()
        );
        publications.add(
                Book.builder()
                        .title("BBB")
                        .build()
        );
        publications.add(
                Book.builder()
                        .title("AAA")
                        .build()
        );
    }

    @Test
    public void testGetSorted() {
        PublicationDao dao = mock(PublicationDao.class);
        when(dao.getPublications()).thenReturn(publications);

        PublicationService service = new PublicationService(dao);

        List<Publication> sorted = service.getSortedPublications();

        assertEquals("123", sorted.get(0).getTitle());
        assertEquals("AAA", sorted.get(1).getTitle());
        assertEquals("BBB", sorted.get(2).getTitle());
        assertEquals("XYZ", sorted.get(3).getTitle());
    }
}
