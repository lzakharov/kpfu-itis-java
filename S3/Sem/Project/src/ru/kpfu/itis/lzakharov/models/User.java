package ru.kpfu.itis.lzakharov.models;

import java.sql.Date;

/**
 * Created by lzakharov on 16.10.15.
 */
public class User {
    private int id;
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private Date birthdate;
    private String address;

    public User(String username, String firstName, String lastName, String password, String email, Date birthdate, String address) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.birthdate = birthdate;
        this.address = address;
    }

    public User(int id, String username, String firstName, String lastName, String password, String email, Date birthdate, String address) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.birthdate = birthdate;
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
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

    public boolean isCorrectPassword(String password) {
        return this.password.equals(password);
    }
}
