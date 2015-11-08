package ru.kpfu.itis.lzakharov.models;

import ru.kpfu.itis.lzakharov.respository.UserRepository;

import java.sql.Timestamp;

/**
 * Created by lzakharov on 30.10.15.
 */
public class Review {
    private int review_id;
    private int book_id;
    private int author_id;
    private int type;
    private String text;
    private Timestamp timestamp;

    public Review(int review_id, int book_id, int author_id, int type, String text, Timestamp timestamp) {
        this.review_id = review_id;
        this.book_id = book_id;
        this.author_id = author_id;
        this.type = type;
        this.text = text;
        this.timestamp = timestamp;
    }

    public int getReview_id() {
        return review_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public int getType() {
        return type;
    }

    public String getText() {
        return text;
    }

    public String getAuthorName()
    {
        return UserRepository.getNameById(author_id);
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }
}
