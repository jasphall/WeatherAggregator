package com.sikorski.weatheraggregator.domain.aggregator;

import com.sikorski.weatheraggregator.config.logs.Loggable;
import com.sikorski.weatheraggregator.domain.api.data.WeatherApiData;
import com.sikorski.weatheraggregator.config.customobservable.CustomObservable;

/**
 * Komponent odpowiedzialny za informowanie chętnych obserwatorów o przyjściu najświeższych danych pogodowych
 */
public interface WeatherAggregator extends CustomObservable, Loggable {

    /**
     * Metoda wykonywana w momencie pojawienia się nowych danych
     *
     * @param weatherApiData
     */
    void onData(WeatherApiData weatherApiData);

}
