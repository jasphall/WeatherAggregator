package com.sikorski.weatheraggregator.domain.api.impl;

import com.sikorski.weatheraggregator.config.properties.ConfigurationProperties;
import com.sikorski.weatheraggregator.domain.api.WeatherApi;
import com.sikorski.weatheraggregator.domain.api.data.WeatherApiData;
import com.sikorski.weatheraggregator.domain.api.services.yahoo.YahooApiManager;
import com.sikorski.weatheraggregator.domain.api.services.yahoo.exceptions.YahooApiLocationUnavailableException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import javax.xml.bind.JAXBException;

@RunWith(MockitoJUnitRunner.class)
public class YahooWeatherApiTest {

    @Mock
    private ConfigurationProperties configurationProperties;

    @Mock
    private YahooApiManager yahooApiManager;

    private WeatherApi yahooWeatherApi;

    @Before
    public void setUp() throws JAXBException {
        yahooWeatherApi = new YahooWeatherApi(configurationProperties, yahooApiManager);
    }

    @Test
    public void test_get_newest_returns_empty_when_no_channels() throws YahooApiLocationUnavailableException {
        // given
        Mockito.when(yahooApiManager.getLocationCurrentWeather(Matchers.anyString(), Matchers.anyObject()))
                .thenThrow(new YahooApiLocationUnavailableException());

        // when
        WeatherApiData newestData = yahooWeatherApi.getNewestData();

        // then
        Assert.assertTrue(newestData.isEmpty());
    }

}