package com.sikorski.weatheraggregator.aggregation.domain.weatherapi.yahoo;

import com.github.fedy2.weather.data.Channel;
import com.github.fedy2.weather.data.unit.DegreeUnit;
import com.sikorski.weatheraggregator.aggregation.domain.dto.weatherdata.WeatherApiData;
import com.sikorski.weatheraggregator.aggregation.domain.dto.weatherdata.basic.BasicWeatherApiData;
import com.sikorski.weatheraggregator.aggregation.domain.weatherapi.WeatherApi;
import com.sikorski.weatheraggregator.aggregation.domain.weatherapi.yahoo.exceptions.YahooApiLocationUnavailableException;
import com.sikorski.weatheraggregator.config.properties.ConfigurationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Obsługa API Yahoo
 */
@Service(value = "yahoo")
class YahooWeatherProvider implements WeatherApi {

    private final ConfigurationProperties configurationProperties;
    private final YahooApiAccessor yahooApiAccessor;

    @Autowired
    public YahooWeatherProvider(ConfigurationProperties configurationProperties, YahooApiAccessor yahooApiAccessor) {
        this.configurationProperties = configurationProperties;
        this.yahooApiAccessor = yahooApiAccessor;
    }

    @Override
    public WeatherApiData getNewestData() {
        Channel currentWeather;

        try {
            currentWeather = yahooApiAccessor.getLocationCurrentWeather(configurationProperties.getOwmLocation(), DegreeUnit.CELSIUS);
        } catch (YahooApiLocationUnavailableException e) {
            return BasicWeatherApiData.empty();
        }

        return BasicWeatherApiData.builder()
                    .withDateTime(currentWeather.getLastBuildDate())
                    .withTemperature((double) currentWeather.getItem().getCondition().getTemp())
                    .withPressure(Double.valueOf(currentWeather.getAtmosphere().getPressure()))
                    .statusOK()
                    .build();
    }

}
