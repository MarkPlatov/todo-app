package com.example.todoApp.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String text;

    private String tag;

    private LocalDateTime creationDateTime;

    private String creationDateString;

    private String creationTimeString;

    public Task() {
    }

    public Task(String text, String tag) {
        this.text = text;
        this.tag = tag;
        setTimeMark(LocalDateTime.now());
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(LocalDateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public String getCreationDateString() {
        return creationDateString;
    }

    public void setCreationDateString(String creationDateTimeString) {
        this.creationDateString = creationDateTimeString;
    }

    public String getCreationTimeString() {
        return creationTimeString;
    }

    public void setCreationTimeString(String creationTimeString) {
        this.creationTimeString = creationTimeString;
    }



    private void setTimeMark(LocalDateTime localDateTime){
        creationDateTime = localDateTime;
        String day = localDateTime.getDayOfMonth() < 10 ? "0" + localDateTime.getDayOfMonth() : localDateTime.getDayOfMonth() + "";
        String mon = localDateTime.getMonthValue() < 10 ? "0" + localDateTime.getMonthValue() : localDateTime.getMonthValue() + "";

        creationDateString =
                day + "." +
                mon + "." +
                localDateTime.getYear();
        creationTimeString =
                localDateTime.getHour() + ":" +
                localDateTime.getMinute();
    }
}
