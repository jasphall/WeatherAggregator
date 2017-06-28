package com.sikorski.weatheraggregator.domain.export.impl;

import com.sikorski.weatheraggregator.domain.dataaggregation.dto.weatherdata.WeatherApiData;
import com.sikorski.weatheraggregator.domain.export.DataExporter;
import com.sikorski.weatheraggregator.domain.export.ExportParameters;
import com.sikorski.weatheraggregator.utils.FileUtils;
import com.sikorski.weatheraggregator.utils.ReflectionUtils;
import com.sikorski.weatheraggregator.utils.StringFormatter;
import org.springframework.stereotype.Service;
import java.io.FileWriter;
import java.io.IOException;
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

        boolean fileExists = FileUtils.fileExists(filename);
        saveDataToCsv(weatherApiData, filename, fileExists);
    }

    /**
     * Zapis danych do pliku
     *
     * @param weatherApiData
     * @param filename
     * @param fileExists
     */
    private void saveDataToCsv(WeatherApiData weatherApiData, String filename, boolean fileExists) {
        String headers = headers(weatherApiData);

        try (FileWriter fileWriter = new FileWriter(filename, true)) {
            if (!fileExists) {
                fileWriter.append(headers);
            }

            fileWriter.append(weatherApiData.toOneLiner());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Dostarcza nagłówki do pliku csv na podstawie pól w klasie danych
     *
     * @param weatherApiData
     * @return
     */
    private String headers(WeatherApiData weatherApiData) {
        List<String> headers = ReflectionUtils.getClassFields(weatherApiData.getClass());
        return StringFormatter.formatListToSingleString(headers);
    }

}
