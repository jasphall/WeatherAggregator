package com.sikorski.weatheraggregator.utils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Metody statyczne związane z formatowaniem tekstu
 */
public class StringFormatter {

    /**
     * Formatuje listę [a,b,c] do tekstu postaci: a,b,c
     *
     * @param input
     *      lista
     * @return
     *      tekst
     */
    public static String formatListToSingleString(List<String> input) {
        input = input.stream()
                     .map(word -> word.replaceAll(",", ""))
                     .collect(Collectors.toList());

        return input.toString()
                .replaceAll("\\[", "")
                .replaceAll("\\]", "")
                .replaceAll(" ", "")
                .concat("\n");
    }

}
