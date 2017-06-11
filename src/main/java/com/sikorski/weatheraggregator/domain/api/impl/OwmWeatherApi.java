package com.sikorski.weatheraggregator.domain.api.impl;

import com.sikorski.weatheraggregator.config.ConfigurationProperties;
import com.sikorski.weatheraggregator.domain.api.WeatherApi;
import com.sikorski.weatheraggregator.domain.api.data.WeatherApiData;
import com.sikorski.weatheraggregator.domain.api.data.builder.WeatherApiDataBuilder;
import net.aksingh.owmjapis.CurrentWeather;
import net.aksingh.owmjapis.OpenWeatherMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Obsługa API Open Weather Map
 */
@Service
public class OwmWeatherApi implements WeatherApi {

    @Autowired
    private final ConfigurationProperties configurationProperties;
    private final OpenWeatherMap owm;

    public OwmWeatherApi(ConfigurationProperties configurationProperties) {
        this.configurationProperties = configurationProperties;
        this.owm = new OpenWeatherMap(configurationProperties.getOwmApiKey());
    }

    @Override
    public WeatherApiData getNewestData() {
        CurrentWeather currentWeather = null;

        try {
            currentWeather = owm.currentWeatherByCityName(configurationProperties.getOwmLocation());

            if (currentWeather.getDateTime() == null) {
                // API nie odpowiada
                return WeatherApiData.empty();
            }

            float fahrenheitTemperature = currentWeather.getMainInstance().getTemperature();
            double celsiusTemperature = (fahrenheitTemperature - 32) * 5 / 9;
            logger().info("{}", celsiusTemperature);

            return new WeatherApiDataBuilder()
                    .withDateTime(currentWeather.getDateTime())
                    .withMinTemperature((double) currentWeather.getMainInstance().getMinTemperature())
                    .withMaxTemperature((double) currentWeather.getMainInstance().getMaxTemperature())
                    .withTemperature((double) currentWeather.getMainInstance().getTemperature())
                    .withPressure((double) currentWeather.getMainInstance().getPressure())
                    .statusOK()
                    .build();

        } catch (IOException e) {
            e.printStackTrace();
            return WeatherApiData.empty();
        }
    }

}
