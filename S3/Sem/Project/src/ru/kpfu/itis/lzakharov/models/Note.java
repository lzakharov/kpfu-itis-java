package ru.kpfu.itis.lzakharov.models;

/**
 * Created by lzakharov on 30.10.15.
 */
public class Note {
    private int id;
    private int user_id;
    private int book_id;
    private String title;
    private String text;

    public Note(int id, int user_id, int book_id, String title, String text) {
        this.id = id;
        this.user_id = user_id;
        this.book_id = book_id;
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}
