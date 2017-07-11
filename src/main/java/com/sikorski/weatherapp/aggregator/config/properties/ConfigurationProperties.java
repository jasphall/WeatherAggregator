package com.sikorski.weatherapp.aggregator.config.properties;

/**
 * Interfejs udostępniający propertisy potrzebne do działania aplikacji
 */
public interface ConfigurationProperties {

    /**
     * Pobranie lokalizacji do śledzenia pogodowego
     * @return
     */
    String getLocation();

}
