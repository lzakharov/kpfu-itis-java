package ru.kpfu.itis.lzakharov.models;

import org.postgresql.largeobject.LargeObject;

/**
 * Created by lzakharov on 30.10.15.
 */
public class BookData {
    private int book_id;
    private String description;
    private LargeObject text;
    private LargeObject cover;

    public BookData(int book_id, String description, LargeObject text, LargeObject cover) {
        this.book_id = book_id;
        this.description = description;
        this.text = text;
        this.cover = cover;
    }
}
