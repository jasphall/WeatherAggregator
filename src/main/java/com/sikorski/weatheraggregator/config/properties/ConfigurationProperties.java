package com.sikorski.weatheraggregator.config.properties;

/**
 * Interfejs udostępniający propertisy potrzebne do działania aplikacji
 */
public interface ConfigurationProperties {

    /**
     * Pobranie api key OpenWeatherMap
     * @return
     */
    String getOwmApiKey();

    /**
     * Pobranie lokalizacji do śledzenia pogodowego
     * @return
     */
    String getOwmLocation();

    /**
     * Pobranie nazwy pliku csv do eksportu danych
     * @return
     */
    String getCsvExportFilename();

}
