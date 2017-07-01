package com.sikorski.weatheraggregator.persistence;

import com.sikorski.weatheraggregator.aggregation.domain.dto.weatherdata.WeatherApiData;
import com.sikorski.weatheraggregator.application.dto.NamedParameters;
import com.sikorski.weatheraggregator.utils.*;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Eksport danych pogodowych do pliku csv
 */
@Service
class CsvFilePersistenceProvider implements DataPersistenceProvider {

    @Override
    public void persist(WeatherApiData weatherApiData, NamedParameters parameters) {
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
            AppFileWriter appFileWriter = new AppFileWriterImpl(fileWriter);
            if (!fileExists) {
                saveLineToFile(headers, appFileWriter);
            }

            saveLineToFile(weatherApiData.toOneLiner(), appFileWriter);
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

    private String saveLineToFile(String line, AppFileWriter fileWriter) throws IOException {
        fileWriter.append(line);
        return line;
    }

}
