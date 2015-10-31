package ru.kpfu.itis.lzakharov.models;

import ru.kpfu.itis.lzakharov.respository.AuthorRepository;

/**
 * Created by lzakharov on 30.10.15.
 */
public class Book {
    private int id;
    private String name;
    private Integer year;
    private String publisher;
    private Integer rate;

    public Book(int id, String name, Integer year, String publisher, Integer rate) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.publisher = publisher;
        this.rate = rate;
    }

    public Integer getRate() {
        return rate;
    }

    public String getPublisher() {

        return publisher;
    }

    public Integer getYear() {

        return year;
    }

    public String getName() {
        return name;
    }

    public String getAuthorName() {
        return null;
    }
}
