package org.echocat.kata.java.part1.model;

public interface CsvModelBuilder<T> {
    T build(String line);
}
