package com.example.todoApp.helpers;

import java.time.LocalDateTime;

public class StringHelper {
    public static boolean isStringReallyExist(String text){
        return text != null && !text.isEmpty();
    }

    public static String getDate(LocalDateTime dateTime){
        String day = toStringAndAddMeaninglessZero(dateTime.getDayOfMonth());
        String mon = toStringAndAddMeaninglessZero(dateTime.getMonthValue());
        String year = String.valueOf(dateTime.getYear());
        return day + "." + mon + "." + year;

    }
    public static String getTime(LocalDateTime dateTime){
        String min = toStringAndAddMeaninglessZero(dateTime.getDayOfMonth());
        String hour = toStringAndAddMeaninglessZero(dateTime.getMonthValue());
        return hour + ":" + min;

    }

    private static String toStringAndAddMeaninglessZero(Integer num){
        StringBuilder str = new StringBuilder();
        if (num < 10){
            str.append('0');
        }
        str.append(num);
        return str.toString();
    }

}
