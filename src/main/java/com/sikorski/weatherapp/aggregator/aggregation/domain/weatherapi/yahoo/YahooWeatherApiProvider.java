package com.sikorski.weatherapp.aggregator.aggregation.domain.weatherapi.yahoo;

import com.github.fedy2.weather.data.Channel;
import com.github.fedy2.weather.data.unit.DegreeUnit;
import com.sikorski.weatherapp.aggregator.aggregation.domain.location.Location;
import com.sikorski.weatherapp.aggregator.aggregation.domain.model.dto.BasicWeatherApiData;
import com.sikorski.weatherapp.aggregator.aggregation.domain.model.dto.WeatherApiData;
import com.sikorski.weatherapp.aggregator.aggregation.domain.weatherapi.WeatherApiProvider;
import com.sikorski.weatherapp.aggregator.aggregation.domain.weatherapi.mapper.WeatherApiMapper;
import com.sikorski.weatherapp.aggregator.aggregation.domain.weatherapi.yahoo.exceptions.YahooApiLocationUnavailableException;
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
