package ru.kpfu.itis.lzakharov.models;

/**
 * Created by lzakharov on 30.10.15.
 */
public class BookAuthor {
    private int book_id;
    private int author_id;

    public BookAuthor(int book_id, int author_id) {
        this.book_id = book_id;
        this.author_id = author_id;
    }
}
