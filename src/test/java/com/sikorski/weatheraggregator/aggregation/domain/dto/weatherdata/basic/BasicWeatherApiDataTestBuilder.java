package com.sikorski.weatheraggregator.aggregation.domain.dto.weatherdata.basic;

import java.util.Date;
import java.util.Random;

public class BasicWeatherApiDataTestBuilder {

    private static Random random = new Random();

    public static BasicWeatherApiData withOneParameter() {
        return BasicWeatherApiData.builder()
                .withTemperature(random.nextDouble())
                .build();
    }

    public static BasicWeatherApiData withTwoParameters() {
        return BasicWeatherApiData.builder()
                .withTemperature(random.nextDouble())
                .withSunrise(new Date())
                .build();
    }

    public static BasicWeatherApiData withThreeParameters() {
        return BasicWeatherApiData.builder()
                .withTemperature(random.nextDouble())
                .withSunrise(new Date())
                .withSunset(new Date())
                .build();
    }

}