package com.sikorski.weatheraggregator.aggregation.domain.weatherapi.yahoo;

import com.github.fedy2.weather.YahooWeatherService;
import com.github.fedy2.weather.data.Channel;
import com.github.fedy2.weather.data.unit.DegreeUnit;
import com.sikorski.weatheraggregator.aggregation.domain.weatherapi.yahoo.exceptions.YahooApiLocationUnavailableException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

@Component
@Slf4j
class YahooApiAccessorImpl implements YahooApiAccessor {

    private final YahooWeatherService yahooWeatherService;

    @Autowired
    public YahooApiAccessorImpl() throws JAXBException {
        this.yahooWeatherService = new YahooWeatherService();
    }

    @Override
    public Channel getLocationCurrentWeather(String location, DegreeUnit degreeUnit)
            throws YahooApiLocationUnavailableException {

        YahooWeatherService.LimitDeclaration locationState = yahooWeatherService
                .getForecastForLocation(location, degreeUnit);

        try {
            List<Channel> currentLocationsWeather = locationState.all();
            log.info("Ilość danych pogodowych: {}.", currentLocationsWeather.size());

            if (currentLocationsWeather.size() == 0) {
                throw new YahooApiLocationUnavailableException();
            }

            return currentLocationsWeather.get(0);
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }

        throw new RuntimeException("Błąd krytyczny API Yahoo.");
    }

}
