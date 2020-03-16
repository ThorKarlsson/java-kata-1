package org.echocat.kata.java.part1.service;

import lombok.extern.slf4j.Slf4j;
import org.echocat.kata.java.part1.model.Author;
import org.echocat.kata.java.part1.model.Book;
import org.echocat.kata.java.part1.model.Magazine;
import org.echocat.kata.java.part1.model.Publication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Slf4j
public class CSVReader {


    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public List<Author> readAuthorCsv(String filename) {
        try(Stream<String> stream = Files.lines(Paths.get(getClass().getClassLoader().getResource(filename).getPath())).skip(1)) {
            return stream.map(line -> line.split(";"))
                    .map(x -> Author.builder()
                            .email(x[0])
                            .firstName(x[1])
                            .lastName(x[2]).build())
                    .collect(Collectors.toList());
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    public List<Publication> readMagazineCsv(String filename) {
        try(Stream<String> stream = Files.lines(Paths.get(getClass().getClassLoader().getResource(filename).getPath())).skip(1)) {
            return stream.map(line -> line.split(";"))
                    .map(x -> Magazine.builder()
                            .title(x[0])
                            .isbn(x[1])
                            .authors(parseAuthors(x[2]))
                            .publishedAt(parseDate(x[3]))
                            .build())
                    .collect(Collectors.toList());
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    private LocalDate parseDate(String date) {
        return LocalDate.parse(date, DATE_FORMATTER);
    }

    public List<Publication> readBookCsv(String filename) {
        try(Stream<String> stream = Files.lines(Paths.get(getClass().getClassLoader().getResource(filename).getPath())).skip(1)) {
            return stream.map(line -> line.split(";"))
                    .map(x -> Book.builder()
                            .title(x[0])
                            .isbn(x[1])
                            .authors(parseAuthors(x[2]))
                            .description(x[3])
                            .build())
                    .collect(Collectors.toList());
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    private List<String> parseAuthors(String authors) {
        return new ArrayList<>(Arrays.asList(authors.split(",")));
    }
}
