package org.echocat.kata.java.part1.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Magazine extends Publication {

    private LocalDate publishedAt;

    @Builder
    public Magazine(String title, String isbn, List<String> authors, LocalDate publishedAt) {
        super(title, isbn, authors);
        this.publishedAt = publishedAt;
    }
}
