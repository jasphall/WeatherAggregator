package com.sikorski.weatheraggregator.domain.listeners.impl;

import com.sikorski.weatheraggregator.config.ConfigurationProperties;
import com.sikorski.weatheraggregator.domain.aggregator.WeatherAggregator;
import com.sikorski.weatheraggregator.domain.api.data.WeatherApiData;
import com.sikorski.weatheraggregator.domain.export.ExportParameters;
import com.sikorski.weatheraggregator.domain.export.impl.CsvFileExporter;
import com.sikorski.weatheraggregator.domain.listeners.WeatherChangeObserver;
import org.springframework.stereotype.Component;

import java.util.Observable;

/**
 * Obiekt nasłuchujący danych pogodywych i zlecający ich zapis do pliku csv
 */
@Component
public class CsvListener implements WeatherChangeObserver {

    private final WeatherAggregator weatherAggregator;
    private final CsvFileExporter csvFileExporter;
    private final ConfigurationProperties configurationProperties;
    private final String exportFilename;

    public CsvListener(WeatherAggregator weatherAggregator, CsvFileExporter csvFileExporter,
                       ConfigurationProperties configurationProperties) {
        this.weatherAggregator = weatherAggregator;
        this.csvFileExporter = csvFileExporter;
        this.configurationProperties = configurationProperties;
        this.exportFilename = this.configurationProperties.getCsvExportFilename();
        init();
    }

    @Override
    public void init() {
        weatherAggregator.addObserver(this);
    }

    @Override
    public void update(Observable o, Object update) {
        csvFileExporter.export((WeatherApiData) update, ExportParameters.oneParameter("filename", this.exportFilename));
        logger().info(getClass().getSimpleName() + " updated.");
    }

}