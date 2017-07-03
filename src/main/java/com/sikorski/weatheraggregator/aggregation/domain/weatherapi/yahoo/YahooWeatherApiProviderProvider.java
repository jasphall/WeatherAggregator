package com.sikorski.weatheraggregator.aggregation.domain.weatherapi.yahoo;

import com.github.fedy2.weather.data.Channel;
import com.github.fedy2.weather.data.unit.DegreeUnit;
import com.sikorski.weatheraggregator.aggregation.domain.dto.weatherdata.WeatherApiData;
import com.sikorski.weatheraggregator.aggregation.domain.dto.weatherdata.basic.BasicWeatherApiData;
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
class YahooWeatherApiProviderProvider implements WeatherApiProvider {

    private final ConfigurationProperties configurationProperties;
    private final YahooApiAccessor yahooApiAccessor;
    private final WeatherApiMapper weatherApiMapper;

    @Autowired
    public YahooWeatherApiProviderProvider(
            ConfigurationProperties configurationProperties,
            YahooApiAccessor yahooApiAccessor,
            @Qualifier("yahooWeatherApiMapper") WeatherApiMapper weatherApiMapper) {
        this.configurationProperties = configurationProperties;
        this.yahooApiAccessor = yahooApiAccessor;
        this.weatherApiMapper = weatherApiMapper;
    }

    @Override
    public WeatherApiData getNewestData() {
        Channel currentWeather;

        try {
            currentWeather = yahooApiAccessor.getLocationCurrentWeather(configurationProperties.getOwmLocation(), DegreeUnit.CELSIUS);
        } catch (YahooApiLocationUnavailableException e) {
            return BasicWeatherApiData.empty();
        }

        WeatherApiData newestData = weatherApiMapper.map(currentWeather);

        return newestData;
    }

}
