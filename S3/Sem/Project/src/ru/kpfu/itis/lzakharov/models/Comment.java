package ru.kpfu.itis.lzakharov.models;

import ru.kpfu.itis.lzakharov.respository.UserRepository;

import java.sql.Time;
import java.sql.Timestamp;

/**
 * Created by lzakharov on 20.10.15.
 */
public class Comment {
    private int id;
    private int article_id;
    private int author_id;
    private String text;
    private Timestamp timestamp;

    public Comment(int id, int article_id, int author_id, String text, Timestamp timestamp) {
        this.id = id;
        this.article_id = article_id;
        this.author_id = author_id;
        this.text = text;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public int getArticle_id() {
        return article_id;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public String getText() {
        return text;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public String getAuthorName()
    {
        return UserRepository.getNameById(author_id);
    }
}

