package com.sikorski.weatheraggregator.domain.listeners.impl;

import com.sikorski.weatheraggregator.domain.aggregator.WeatherAggregator;
import com.sikorski.weatheraggregator.domain.listeners.WeatherChangeObserver;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DbListenerTest {

    @Autowired
    private WeatherAggregator weatherAggregator;

    @Test
    public void test_new_observer_init() {
        // given
        int initialObserversCount = weatherAggregator.countObservers();
        WeatherChangeObserver weatherChangeObserver;

        // when
        weatherChangeObserver = new DbListener(weatherAggregator);

        // then
        assertTrue(weatherAggregator.countObservers() == initialObserversCount+1);
    }

}