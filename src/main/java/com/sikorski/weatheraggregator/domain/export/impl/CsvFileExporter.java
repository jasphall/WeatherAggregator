package com.sikorski.weatheraggregator.domain.export.impl;

import com.sikorski.weatheraggregator.domain.api.data.WeatherApiData;
import com.sikorski.weatheraggregator.domain.export.DataExporter;
import com.sikorski.weatheraggregator.domain.export.ExportParameters;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Eksport danych pogodowych do pliku csv
 */
@Service
public class CsvFileExporter implements DataExporter {

    @Override
    public void export(WeatherApiData weatherApiData, ExportParameters parameters) {
        String filename = (String) parameters.getParameterIfExists("filename")
                .orElseThrow(() -> new RuntimeException("Parametr filename nie został dostarczony. Dane nie zostaną zapisane."));

        boolean fileExists = fileExists(filename);
        String headers = headers(weatherApiData);

        try (FileWriter fileWriter = new FileWriter(filename, true)) {
            if (!fileExists) {
                fileWriter.append(headers);
            }

            fileWriter.append(weatherApiData.toOneLinerWithCommaSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Sprawdza, czy plik istnieje już na dysku
     *
     * @param filename
     * @return
     */
    private boolean fileExists(String filename) {
        File file = new File(filename);
        if (file.exists()) {
            return true;
        }

        return false;
    }

    /**
     * Pobiera nagłówki pliku csv na podstawie nazw pól w obiekcie transportowym
     *
     * @param weatherApiData
     * @return
     */
    private String headers(WeatherApiData weatherApiData) {
        List<String> headers = new ArrayList<>();
        for (Field field: weatherApiData.getClass().getDeclaredFields()) {
            headers.add(field.getName().toLowerCase());
        }

        String headersLine = headers.toString()
                .replaceAll("\\[", "")
                .replaceAll("\\]", "")
                .replaceAll(" ", "")
                .concat("\n");

        return headersLine;
    }

}
