package ru.kpfu.itis.lzakharov.models;

/**
 * Created by lzakharov on 30.10.15.
 */
public class Review {
    private int id;
    private int book_id;
    private int author_id;
    private int type;
    private String text;

    public Review(int id, int book_id, int author_id, int type, String text) {
        this.id = id;
        this.book_id = book_id;
        this.author_id = author_id;
        this.type = type;
        this.text = text;
    }

    public int getType() {
        return type;
    }

    public String getText() {
        return text;
    }
}
