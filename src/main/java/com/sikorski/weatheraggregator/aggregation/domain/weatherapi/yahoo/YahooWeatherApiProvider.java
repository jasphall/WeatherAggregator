package com.sikorski.weatheraggregator.aggregation.domain.weatherapi.yahoo;

import com.github.fedy2.weather.data.Channel;
import com.github.fedy2.weather.data.unit.DegreeUnit;
import com.sikorski.weatheraggregator.aggregation.domain.location.Location;
import com.sikorski.weatheraggregator.aggregation.domain.model.dto.BasicWeatherApiData;
import com.sikorski.weatheraggregator.aggregation.domain.model.dto.WeatherApiData;
import com.sikorski.weatheraggregator.aggregation.domain.weatherapi.WeatherApiProvider;
import com.sikorski.weatheraggregator.aggregation.domain.weatherapi.mapper.WeatherApiMapper;
import com.sikorski.weatheraggregator.aggregation.domain.weatherapi.yahoo.exceptions.YahooApiLocationUnavailableException;
import com.sikorski.weatheraggregator.config.properties.ConfigurationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Obsługa API Yahoo
 */
@Service(value = "yahoo")
class YahooWeatherApiProvider implements WeatherApiProvider {

    private final YahooApiAccessor yahooApiAccessor;
    private final WeatherApiMapper weatherApiMapper;

    @Autowired
    public YahooWeatherApiProvider(
            YahooApiAccessor yahooApiAccessor,
            @Qualifier("yahooWeatherApiMapper") WeatherApiMapper weatherApiMapper) {
        this.yahooApiAccessor = yahooApiAccessor;
        this.weatherApiMapper = weatherApiMapper;
    }

    @Override
    public WeatherApiData getNewestData(Location location) {
        Channel currentWeather;

        try {
            currentWeather = yahooApiAccessor.getLocationCurrentWeather(location, DegreeUnit.CELSIUS);
        } catch (YahooApiLocationUnavailableException e) {
            return BasicWeatherApiData.empty();
        }

        WeatherApiData newestData = weatherApiMapper.map(currentWeather);

        return newestData;
    }

}