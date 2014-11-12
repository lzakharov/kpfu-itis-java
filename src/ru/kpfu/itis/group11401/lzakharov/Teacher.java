package ru.kpfu.itis.group11401.lzakharov;/**
 * @author Lev Zakharov
 * 11401
 * Created on 12.11.2014.
 */

public class Teacher {
    private String fio;
    private String lesson;
    final String[] marks = {"неудовлетворительно", "удовлетворительно", "хорошо", "отлично"};

    public Teacher(String fio, String lesson) {
        this.fio = fio;
        this.lesson = lesson;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public void rate(Student student) {
        System.out.println("Преподаватель " + this.getFio() + " оценил студента с именем " + student.getFio() + " по предмету " + this.getLesson() + " на оценку " + marks[(int)(Math.random()*4)]);
    }
}