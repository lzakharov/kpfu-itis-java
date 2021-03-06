package ru.kpfu.itis.lzakharov.models;

import ru.kpfu.itis.lzakharov.respository.UserRepository;

import java.sql.Timestamp;

/**
 * Created by lzakharov on 20.10.15.
 */
public class Article {
    private int article_id;
    private String title;
    private int author_id;
    private Timestamp timestamp;
    private String description;

    public Article(int article_id, String title, int author_id, Timestamp timestamp, String description) {
        this.article_id = article_id;
        this.title = title;
        this.author_id = author_id;
        this.timestamp = timestamp;
        this.description = description;
    }

    public int getArticle_id() {
        return article_id;
    }

    public String getTitle() {
        return title;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public String getDescription() {
        return description;
    }



    public String getAuthorName() {
        return UserRepository.getNameById(author_id);
    }
}
