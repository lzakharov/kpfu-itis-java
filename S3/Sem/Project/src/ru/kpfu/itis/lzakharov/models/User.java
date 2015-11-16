package ru.kpfu.itis.lzakharov.models;

import ru.kpfu.itis.lzakharov.respository.UserRepository;

import java.sql.Date;

/**
 * Created by lzakharov on 16.10.15.
 */
public class User {
    private int id;
    private String username;
    private String first_name;
    private String last_name;
    private String password;
    private String email;
    private Date birthdate;
    private String address;
    private String avatar;

    public User(String username, String first_name, String last_name, String password, String email, Date birthdate, String address) {
        this.username = username;
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
        this.email = email;
        this.birthdate = birthdate;
        this.address = address;
    }

    public User(int id, String username, String first_name, String last_name, String password, String email, Date birthdate, String address, String avatar) {
        this.id = id;
        this.username = username;
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
        this.email = email;
        this.birthdate = birthdate;
        this.address = address;
        this.avatar = avatar;
    }

    public User(int id, String username, String first_name, String last_name, String password, String email, Date birthdate, String address) {
        this.id = id;
        this.username = username;
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
        this.email = email;
        this.birthdate = birthdate;
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public String getAddress() {
        return address;
    }

    public String getAvatar() {
        return avatar;
    }

    public boolean isCorrectPassword(String password) {
        return this.password.equals(password);
    }
}
