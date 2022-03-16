package com.example.todoApp.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

import static com.example.todoApp.helpers.StringHelper.*;

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
        this.tag = formatStringToTag(tag);
        setDateTime(LocalDateTime.now());
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
        this.tag = formatStringToTag(tag);
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



    private void setDateTime(LocalDateTime localDateTime){
        creationDateTime = localDateTime;
        creationDateString = getDate(localDateTime);
        creationTimeString = getTime(localDateTime);
    }

    private String formatStringToTag(String text){
        text = removeSpaces(text);
        text = addHashtagSign(text);
        return text;
    }

    private String removeSpaces(String tag){
        if (isStringReallyExist(tag)) {
            tag = tag.replace(" ", "");
        }
        return tag;
    }

    private String addHashtagSign(String tag){
        if (isStringReallyExist(tag) && tag.charAt(0) != '#'){
            tag = tag.replaceFirst(tag.charAt(0) + "", "#" + tag.charAt(0));
        }
        return tag;
    }
}
