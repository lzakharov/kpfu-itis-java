package ru.kpfu.itis.lzakharov.models;

import java.sql.Date;

/**
 * Created by lzakharov on 26.10.15.
 */
public class Author {
    private int id;
    private String name;
    private Date birthdate;
    private int rate;

    public Author(int id, String name, Date birthdate, int rate) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
        this.rate = rate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public int getRate() {
        return rate;
    }
}
