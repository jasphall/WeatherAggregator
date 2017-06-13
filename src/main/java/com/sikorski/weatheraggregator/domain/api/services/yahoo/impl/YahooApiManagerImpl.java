package com.sikorski.weatheraggregator.domain.api.services.yahoo.impl;

import com.github.fedy2.weather.YahooWeatherService;
import com.github.fedy2.weather.data.Channel;
import com.github.fedy2.weather.data.unit.DegreeUnit;
import com.sikorski.weatheraggregator.domain.api.services.yahoo.YahooApiManager;
import com.sikorski.weatheraggregator.domain.api.services.yahoo.exceptions.YahooApiLocationUnavailableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

@Component
public class YahooApiManagerImpl implements YahooApiManager {

    private final YahooWeatherService yahooWeatherService;

    @Autowired
    public YahooApiManagerImpl() throws JAXBException {
        this.yahooWeatherService = new YahooWeatherService();
    }

    @Override
    public Channel getLocationCurrentWeather(String location, DegreeUnit degreeUnit)
            throws YahooApiLocationUnavailableException {

        YahooWeatherService.LimitDeclaration locationState = yahooWeatherService
                .getForecastForLocation(location, degreeUnit);

        try {
            List<Channel> currentLocationsWeather = locationState.all();
            logger().info("Ilość danych pogodowych: {}.", currentLocationsWeather.size());

            if (currentLocationsWeather.size() == 0) {
                throw new YahooApiLocationUnavailableException();
            }

            return currentLocationsWeather.get(0);
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        throw new RuntimeException("Błąd krytyczny API Yahoo.");
    }

}
