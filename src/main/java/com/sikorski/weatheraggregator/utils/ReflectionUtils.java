package com.sikorski.weatheraggregator.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Metody statyczne działające na refleksji w klasach
 */
public class ReflectionUtils {

    /**
     * Zwraca listę nazw pól w klasie
     *
     * @param c
     *      klasa
     * @return
     */
    public static List<String> getClassFields(Class c) {
        List<String> headers = new ArrayList<>();
        for (Field field: c.getDeclaredFields()) {
            headers.add(field.getName().toLowerCase());
        }

        return headers;
    }

}
