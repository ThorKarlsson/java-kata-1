package org.echocat.kata.java.part1.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.echocat.kata.java.part1.repository.AuthorDao;
import org.echocat.kata.java.part1.repository.PublicationDao;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Slf4j
@AllArgsConstructor
public class DataLoader {

    private AuthorDao authorDao;
    private PublicationDao publicationDao;
    private CSVReader csvReader;

    @PostConstruct
    public void loadDao() {
        log.info("Preloading data");
        authorDao.addAllAuthors(csvReader.readAuthorCsv("org/echocat/kata/java/part1/data/authors.csv"));
        publicationDao.addAllPublications(csvReader.readBookCsv("org/echocat/kata/java/part1/data/books.csv"));
        publicationDao.addAllPublications(csvReader.readMagazineCsv("org/echocat/kata/java/part1/data/magazines.csv"));
    }
}
