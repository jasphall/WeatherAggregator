package com.sikorski.weatheraggregator.domain.aggregator;

import com.sikorski.weatheraggregator.config.Loggable;
import com.sikorski.weatheraggregator.domain.api.data.WeatherApiData;
import org.springframework.stereotype.Component;

import java.util.Observable;

/**
 * Komponent odpowiedzialny za informowanie chętnych obserwatorów o przyjściu najświeższych danych pogodowych
 */
@Component
public class WeatherAggregator extends Observable implements Loggable {

    /**
     * Metoda wykonywana w momencie pojawienia się nowych danych
     *
     * @param weatherApiData
     */
    public void onData(WeatherApiData weatherApiData) {
        setChanged();
        notifyObservers(weatherApiData);
    }

}
