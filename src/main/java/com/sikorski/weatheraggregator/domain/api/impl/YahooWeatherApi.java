package com.sikorski.weatheraggregator.domain.api.impl;

import com.github.fedy2.weather.data.Channel;
import com.github.fedy2.weather.data.unit.DegreeUnit;
import com.sikorski.weatheraggregator.config.properties.ConfigurationProperties;
import com.sikorski.weatheraggregator.domain.api.WeatherApi;
import com.sikorski.weatheraggregator.domain.api.data.WeatherApiData;
import com.sikorski.weatheraggregator.domain.api.data.basic.BasicWeatherApiData;
import com.sikorski.weatheraggregator.domain.api.data.basic.builder.BasicWeatherApiDataBuilder;
import com.sikorski.weatheraggregator.domain.api.services.yahoo.YahooApiManager;
import com.sikorski.weatheraggregator.domain.api.services.yahoo.exceptions.YahooApiLocationUnavailableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Obsługa API Yahoo
 */
@Service(value = "yahoo")
public class YahooWeatherApi implements WeatherApi {

    private final ConfigurationProperties configurationProperties;
    private final YahooApiManager yahooApiManager;

    @Autowired
    public YahooWeatherApi(ConfigurationProperties configurationProperties, YahooApiManager yahooApiManager) {
        this.configurationProperties = configurationProperties;
        this.yahooApiManager = yahooApiManager;
    }

    @Override
    public WeatherApiData getNewestData() {
        Channel currentWeather;

        try {
            currentWeather = yahooApiManager.getLocationCurrentWeather(configurationProperties.getOwmLocation(), DegreeUnit.CELSIUS);
        } catch (YahooApiLocationUnavailableException e) {
            return BasicWeatherApiData.empty();
        }

        return new BasicWeatherApiDataBuilder()
                    .withDateTime(currentWeather.getLastBuildDate())
                    .withTemperature((double) currentWeather.getItem().getCondition().getTemp())
                    .withPressure(Double.valueOf(currentWeather.getAtmosphere().getPressure()))
                    .statusOK()
                    .build();
    }

}
