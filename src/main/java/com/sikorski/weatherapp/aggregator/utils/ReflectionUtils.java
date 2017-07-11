package com.sikorski.weatherapp.aggregator.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
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

    public static int countNotEmptyFieldsInObject(List<Field> fields, Object o) {
        int counter = 0;
        for (Field field: fields) {
            field.setAccessible(true);

            try {
                Object value = field.get(o);

                if (value instanceof Collection) {
                    Collection collection = (Collection) value;
                    if (!collection.isEmpty()) {
                        counter++;
                    }
                } else if (value != null) {
                    counter++;
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return counter;
    }

}
