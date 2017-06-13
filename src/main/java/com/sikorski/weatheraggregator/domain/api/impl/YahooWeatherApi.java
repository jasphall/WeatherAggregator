package com.sikorski.weatheraggregator.domain.api.impl;

import com.github.fedy2.weather.YahooWeatherService;
import com.github.fedy2.weather.data.Channel;
import com.github.fedy2.weather.data.unit.DegreeUnit;
import com.sikorski.weatheraggregator.config.properties.ConfigurationProperties;
import com.sikorski.weatheraggregator.domain.api.WeatherApi;
import com.sikorski.weatheraggregator.domain.api.data.basic.BasicWeatherApiData;
import com.sikorski.weatheraggregator.domain.api.data.basic.builder.BasicWeatherApiDataBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

/**
 * Obsługa API Yahoo
 */
@Service(value = "yahoo")
public class YahooWeatherApi implements WeatherApi {

    private final ConfigurationProperties configurationProperties;
    private final YahooWeatherService yahooWeatherService;

    @Autowired
    public YahooWeatherApi(ConfigurationProperties configurationProperties) throws JAXBException {
        this.configurationProperties = configurationProperties;
        this.yahooWeatherService = new YahooWeatherService();
    }

    @Override
    public BasicWeatherApiData getNewestData() {
        YahooWeatherService.LimitDeclaration location = yahooWeatherService
                .getForecastForLocation(configurationProperties.getOwmLocation(), DegreeUnit.CELSIUS);

        try {
            List<Channel> currentLocationsWeather = location.all();
            logger().info("Ilość danych pogodowych: {}.", currentLocationsWeather.size());

            if (currentLocationsWeather.size() == 0) {
                return BasicWeatherApiData.empty();
            }

            Channel currentWeather = currentLocationsWeather.get(0);

            return new BasicWeatherApiDataBuilder()
                    .withDateTime(currentWeather.getLastBuildDate())
                    .withTemperature((double) currentWeather.getItem().getCondition().getTemp())
                    .withPressure(Double.valueOf(currentWeather.getAtmosphere().getPressure()))
                    .statusOK()
                    .build();

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return BasicWeatherApiData.empty();
    }

}
