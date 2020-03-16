package org.echocat.kata.java.part1.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Author {
    private String email;
    private String firstName;
    private String lastName;
}
