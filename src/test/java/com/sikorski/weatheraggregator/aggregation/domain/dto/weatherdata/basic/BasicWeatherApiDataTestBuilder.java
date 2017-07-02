package com.sikorski.weatheraggregator.aggregation.domain.dto.weatherdata.basic;

import java.util.Random;

public class BasicWeatherApiDataTestBuilder {

    private static Random random = new Random();

    public static BasicWeatherApiData withOneParameter() {
        return BasicWeatherApiData.builder()
                .withMaxTemperature(random.nextDouble())
                .build();
    }

    public static BasicWeatherApiData withTwoParameters() {
        return BasicWeatherApiData.builder()
                .withMinTemperature(random.nextDouble())
                .withMaxTemperature(10 + random.nextDouble())
                .build();
    }

    public static BasicWeatherApiData withThreeParameters() {
        return BasicWeatherApiData.builder()
                .withMinTemperature(random.nextDouble())
                .withMaxTemperature(10 + random.nextDouble())
                .withPressure(1000 + random.nextDouble())
                .build();
    }

}