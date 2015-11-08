package ru.kpfu.itis.lzakharov.models;

import org.postgresql.largeobject.LargeObject;
import org.postgresql.largeobject.BlobInputStream;

/**
 * Created by lzakharov on 30.10.15.
 */
public class BookData {
    private int book_id;
    private String description;
//    private BlobInputStream text;
//    private LargeObject cover;

    public BookData(int book_id, String description) {
        this.book_id = book_id;
        this.description = description;
//        this.text = text;
//        this.cover = cover;
    }

    public String getDescription() {
        return description;
    }
}
