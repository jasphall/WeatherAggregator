package com.sikorski.weatheraggregator.utils;

import java.util.List;

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
        return input.toString()
                .replaceAll("\\[", "")
                .replaceAll("\\]", "")
                .replaceAll(" ", "")
                .concat("\n");
    }

}
