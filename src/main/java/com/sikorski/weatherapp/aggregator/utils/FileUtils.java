package com.sikorski.weatherapp.aggregator.utils;

import java.io.File;

/**
 * Metody statyczne związane z działaniami wykonywanymi na plikach
 */
public class FileUtils {

    /**
     * Sprawdza, czy plik istnieje już na dysku
     *
     * @param filename
     *      nazwa pliku
     * @return
     *      true (plik istnieje) lub false (plik nie istnieje)
     */
    public static boolean fileExists(String filename) {
        File file = new File(filename);
        return file.exists();
    }

}
