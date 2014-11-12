package ru.kpfu.itis.group11401.lzakharov;
/**
 * @author Lev Zakharov
 * 11401
 * Created on 12.11.2014.
 */


public class Student{
    private String fio;
    private int year;

    public Student(String fio, int year) {
        this.fio = fio;
        this.year = year;
    }

    public String getFio() {
        return this.fio;
    }

    public int getYear() {
        return this.year;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public void setYear(int year) {
        this.year = year;
    }

}