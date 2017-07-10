package com.sikorski.weatheraggregator.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtils {

    static final String standardDateTimePattern = "yyyy-MM-dd HH:mm";
    static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(standardDateTimePattern);

    public static Date asDate(LocalDateTime ldt) {
        if (ldt != null) {
            return Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
        }

        throw new RuntimeException("Podany obiekt daty / czasu jest pusty.");
    }

    /**
     * Tworzy obiekt daty w oparciu o datę podaną w formacie yyyy-MM-dd HH:mm
     * @param datePattern
     * @return
     */
    public static Date fromPattern(String datePattern) {
        LocalDateTime ldt = LocalDateTime.parse(datePattern, DateUtils.formatter);
        return asDate(ldt);
    }

}
