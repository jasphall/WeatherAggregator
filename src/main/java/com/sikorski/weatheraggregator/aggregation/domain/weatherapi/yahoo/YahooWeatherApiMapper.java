package com.sikorski.weatheraggregator.aggregation.domain.weatherapi.yahoo;

import com.github.fedy2.weather.data.Channel;
import com.github.fedy2.weather.data.unit.Time;
import com.sikorski.weatheraggregator.aggregation.domain.model.dto.BasicWeatherApiData;
import com.sikorski.weatheraggregator.aggregation.domain.model.dto.WeatherApiData;
import com.sikorski.weatheraggregator.aggregation.domain.model.elements.*;
import com.sikorski.weatheraggregator.aggregation.domain.weatherapi.mapper.WeatherApiMapper;
import com.sikorski.weatheraggregator.aggregation.domain.weatherapi.yahoo.timeconverter.TimeConventionConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
class YahooWeatherApiMapper implements WeatherApiMapper<Channel> {

    private final TimeConventionConverter timeConventionConverter;

    @Autowired
    YahooWeatherApiMapper(TimeConventionConverter timeConventionConverter) {
        this.timeConventionConverter = timeConventionConverter;
    }

    @Override
    public WeatherApiData map(Channel channel) {
        if (channel == null) {
            return BasicWeatherApiData.empty();
        }

        Date dateTime = channel.getLastBuildDate();
        WeatherLocation location = mapLocation(channel);
        List<WeatherUnit> units = mapUnits(channel);
        WeatherWind wind = mapWind(channel);
        WeatherAtmosphere atmosphere = mapAtmosphere(channel);
        List<WeatherForecast> forecasts = mapForecasts(channel);

        Date sunrise = null;
        Date sunset = null;
        if (channel.getAstronomy() != null) {
            sunrise = mapSunTime(dateTime, channel.getAstronomy().getSunrise());
            sunset = mapSunTime(dateTime, channel.getAstronomy().getSunset());
        }

        return BasicWeatherApiData.builder()
                .withDateTime(dateTime)
                .withLocation(location)
                .withUnits(units)
                .withWind(wind)
                .withAtmosphere(atmosphere)
                .withSunrise(sunrise)
                .withSunset(sunset)
                .withTemperature((double) channel.getItem().getCondition().getTemp())
                .withForecasts(forecasts)
                .statusOK()
                .build();
    }

    private WeatherLocation mapLocation(Channel channel) {
        if (channel.getLocation() == null) {
            return null;
        }

        return new WeatherLocation(
                channel.getLocation().getCity(),
                channel.getLocation().getRegion(),
                channel.getLocation().getCountry());
    }

    private List<WeatherUnit> mapUnits(Channel channel) {
        if (channel.getUnits() == null) {
            return null;
        }

        return Arrays.asList(
                WeatherUnit.of("distance", channel.getUnits().getDistance().name()),
                WeatherUnit.of("pressure", channel.getUnits().getPressure().name()),
                WeatherUnit.of("speed", channel.getUnits().getSpeed().name()),
                WeatherUnit.of("temperature", channel.getUnits().getTemperature().name())
        );
    }

    private WeatherWind mapWind(Channel channel) {
        if (channel.getWind() == null) {
            return null;
        }

        return new WeatherWind(
                channel.getWind().getChill(),
                channel.getWind().getDirection(),
                channel.getWind().getSpeed()
        );
    }

    private WeatherAtmosphere mapAtmosphere(Channel channel) {
        if (channel.getAtmosphere() == null) {
            return null;
        }

        return new WeatherAtmosphere(
                channel.getAtmosphere().getHumidity(),
                channel.getAtmosphere().getVisibility(),
                channel.getAtmosphere().getPressure()
            );
    }

    private Date mapSunTime(Date date, Time time) {
        if (date == null || time == null) {
            return null;
        }

        LocalTime localTime = timeConventionConverter.convert12HourTo24HourFormat(time);
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);

        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    private List<WeatherForecast> mapForecasts(Channel channel) {
        if (channel.getItem().getForecasts() == null) {
            return null;
        }

        return channel.getItem().getForecasts()
                .stream()
                .map(f -> WeatherForecast.of(f.getDate(), f.getLow(), f.getHigh()))
                .collect(Collectors.toList());
    }

}
