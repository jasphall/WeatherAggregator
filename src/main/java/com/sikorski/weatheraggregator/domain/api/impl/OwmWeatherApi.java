package com.sikorski.weatheraggregator.domain.api.impl;

import com.sikorski.weatheraggregator.domain.api.WeatherApi;
import com.sikorski.weatheraggregator.domain.api.data.WeatherApiData;
import net.aksingh.owmjapis.CurrentWeather;
import net.aksingh.owmjapis.OpenWeatherMap;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Obsługa API Open Weather Map
 */
@Service
public class OwmWeatherApi implements WeatherApi {

    private OpenWeatherMap owm = new OpenWeatherMap("");

    @Override
    public WeatherApiData getNewestData() {
        CurrentWeather currentWeather = null;

        try {
            currentWeather = owm.currentWeatherByCityName("Torun");
        } catch (IOException e) {
            e.printStackTrace();
            return WeatherApiData.empty();
        }

        return WeatherApiData.empty();
    }

}
