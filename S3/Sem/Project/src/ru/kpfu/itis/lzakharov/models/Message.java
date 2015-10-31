package ru.kpfu.itis.lzakharov.models;

import java.sql.Date;

/**
 * Created by lzakharov on 30.10.15.
 */
public class Message {
    private int id;
    private int sender_id;
    private int receiver_id;
    private String subject;
    private String text;
    private Date date;

    public Message(int id, int sender_id, int receiver_id, String subject, String text, Date date) {
        this.id = id;
        this.sender_id = sender_id;
        this.receiver_id = receiver_id;
        this.subject = subject;
        this.text = text;
        this.date = date;
    }

    public String getSubject() {
        return subject;
    }

    public Date getDate() {
        return date;
    }
}
