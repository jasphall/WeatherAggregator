package com.sikorski.weatheraggregator.config.properties;

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
