package com.sikorski.weatheraggregator.domain.export.impl;

import com.sikorski.weatheraggregator.domain.api.data.WeatherApiData;
import com.sikorski.weatheraggregator.domain.api.data.basic.builder.BasicWeatherApiDataBuilder;
import com.sikorski.weatheraggregator.domain.export.DataExporter;
import com.sikorski.weatheraggregator.domain.export.ExportParameters;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

public class CsvFileExporterTest {

    private DataExporter csvFileExporter;

    @Before
    public void setUp() {
        csvFileExporter = new CsvFileExporter();
    }

    @Test(expected = RuntimeException.class)
    public void test_empty_parameter_list() {
        // given
        WeatherApiData weatherApiData = givenWeatherApiData();
        ExportParameters exportParameters = givenEmptyExportParameters();

        // when
        csvFileExporter.export(weatherApiData, exportParameters);
    }

    private WeatherApiData givenWeatherApiData() {
        return new BasicWeatherApiDataBuilder().build();
    }

    private ExportParameters givenEmptyExportParameters() {
        return new ExportParameters(new HashMap<>());
    }
}