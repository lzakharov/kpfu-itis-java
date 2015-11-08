package ru.kpfu.itis.lzakharov.models;

import ru.kpfu.itis.lzakharov.respository.BookAuthorRepository;

/**
 * Created by lzakharov on 30.10.15.
 */
public class Book {
    private int book_id;
    private String name;
    private Integer year;
    private String publisher;
    private Integer rate;

    public Book(int book_id, String name, Integer year, String publisher, Integer rate) {
        this.book_id = book_id;
        this.name = name;
        this.year = year;
        this.publisher = publisher;
        this.rate = rate;
    }

    public int getBook_id() {
        return book_id;
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

    public String getAuthors() {
        return BookAuthorRepository.getAuthorsByBookId(book_id);
    }
}
