package com.andrew.schedule.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeConverterUtil {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

    public static LocalDateTime fromString(String time_str) {
        return LocalDateTime.parse(time_str, formatter);
    }

    public static String toString(LocalDateTime time) {
        return time.format(formatter);
    }
}
