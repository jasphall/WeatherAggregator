package com.sikorski.weatherapp.aggregator.aggregation.domain.persistence;

import com.sikorski.weatherapp.aggregator.aggregation.domain.model.dto.BasicWeatherApiData;
import com.sikorski.weatherapp.aggregator.aggregation.domain.model.dto.WeatherApiData;
import com.sikorski.weatherapp.aggregator.aggregation.domain.model.elements.WeatherForecast;
import com.sikorski.weatherapp.aggregator.aggregation.domain.model.elements.WeatherUnit;
import com.sikorski.weatherapp.aggregator.aggregation.domain.model.elements.WeatherWind;
import com.sikorski.weatherapp.aggregator.aggregation.domain.model.persistence.WeatherDataModel;
import com.sikorski.weatherapp.aggregator.application.dto.NamedParameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Transactional
public class DbPersistenceProviderTest {

    @Autowired
    @Qualifier(value = "dbPersistenceProvider")
    private DataPersistenceProvider dataPersistenceProvider;

    @Test
    public void test_object_correctly_saves_to_db() throws Exception {
        // given
        WeatherApiData weatherApiData = givenWeatherApiData();
        WeatherDataModel result;

        // when
        result = dataPersistenceProvider.persist(weatherApiData, NamedParameters.empty());

        // then
        thenCheckWeatherDataModel(result);
    }

    @Test
    public void test_foreign_key_not_null_on_forecasts() throws Exception {
        // given
        WeatherApiData weatherApiData = givenWeatherApiData();
        WeatherDataModel result;

        // when
        result = dataPersistenceProvider.persist(weatherApiData, NamedParameters.empty());

        // then
        thenCheckForecastsFKeyNotNull(result.getForecasts());
    }

    @Test
    public void test_foreign_key_not_null_on_units() throws Exception {
        // given
        WeatherApiData weatherApiData = givenWeatherApiData();
        WeatherDataModel result;

        // when
        result = dataPersistenceProvider.persist(weatherApiData, NamedParameters.empty());

        // then
        thenCheckUnitsFKeyNotNull(result.getUnits());
    }

    private WeatherApiData givenWeatherApiData() {
        List<WeatherUnit> units = new ArrayList<>();
        units.add(WeatherUnit.of("Length", "KM"));

        List<WeatherForecast> forecasts = new ArrayList<>();
        forecasts.add(WeatherForecast.of(new Date(), 1, 20));

        return BasicWeatherApiData.builder()
                .withDateTime(new Date())
                .withSunrise(new Date())
                .withSunset(new Date())
                .withWind(new WeatherWind(1, 2, 3f))
                .withUnits(units)
                .build();
    }

    private void thenCheckWeatherDataModel(WeatherDataModel result) {
        assertNotNull(result.getId());
        assertNotNull(result.getDateTime());
        assertNotNull(result.getSunrise());
        assertNotNull(result.getSunset());
        assertEquals(result.getWind(), new WeatherWind(1, 2, 3f));
    }

    private void thenCheckForecastsFKeyNotNull(List<WeatherForecast> forecasts) {
        forecasts.forEach(f -> assertNotNull(f.getWeatherDataModel()));
    }

    private void thenCheckUnitsFKeyNotNull(List<WeatherUnit> units) {
        units.forEach(u -> assertNotNull(u.getWeatherDataModel()));
    }

}