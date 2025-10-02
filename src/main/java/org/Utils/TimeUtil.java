package org.Utils;


import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class TimeUtil {

    public static String getCurrentIsoTime() {
        ZonedDateTime now = ZonedDateTime.now(ZoneOffset.UTC);
        return now.format(DateTimeFormatter.ISO_INSTANT);
    }

    public static void main(String[] args) {
        System.out.println(getCurrentIsoTime());
    }
}