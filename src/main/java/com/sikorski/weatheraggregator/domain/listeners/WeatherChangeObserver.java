package com.sikorski.weatheraggregator.domain.listeners;

import com.sikorski.weatheraggregator.config.Loggable;

import java.util.Observer;

/**
 * Interfejs nasłuchujący na zmiany pogodowe, który przychodzą z API
 */
public interface WeatherChangeObserver extends Observer, Loggable {

    void init();

}
