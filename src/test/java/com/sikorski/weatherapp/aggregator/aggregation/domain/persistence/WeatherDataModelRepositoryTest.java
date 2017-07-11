package com.sikorski.weatherapp.aggregator.aggregation.domain.persistence;

import com.sikorski.weatherapp.aggregator.aggregation.domain.model.persistence.WeatherDataModel;
import com.sikorski.weatherapp.aggregator.utils.DateUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Transactional
public class WeatherDataModelRepositoryTest {

    @Autowired
    private WeatherDataModelRepository weatherDataModelRepository;

    @Before
    public void init() {
        weatherDataModelRepository.deleteAll();
        addToRepositoryThreeExampleWeatherDataModels();
    }

    @Test
    public void test_find_data_when_completely_present() throws Exception {
        // given
        Date startDate = DateUtils.fromPattern("2017-01-01 00:00");
        Date endDate = DateUtils.fromPattern("2017-06-01 00:00");

        // when
        List<WeatherDataModel> result = weatherDataModelRepository.findByDateTimeBetween(startDate, endDate);

        // then
        assertEquals(3, result.size());
    }

    @Test
    public void test_find_data_when_partially_present() throws Exception {
        // given
        Date startDate = DateUtils.fromPattern("2017-01-01 00:00");
        Date endDate = DateUtils.fromPattern("2017-02-15 00:00");

        // when
        List<WeatherDataModel> result = weatherDataModelRepository.findByDateTimeBetween(startDate, endDate);

        // then
        assertEquals(1, result.size());
    }

    @Test
    public void test_find_data_when_no_data_in_range() throws Exception {
        // given
        Date startDate = DateUtils.fromPattern("2017-01-01 00:00");
        Date endDate = DateUtils.fromPattern("2017-02-01 00:00");

        // when
        List<WeatherDataModel> result = weatherDataModelRepository.findByDateTimeBetween(startDate, endDate);

        // then
        assertEquals(0, result.size());
    }

    private void addToRepositoryThreeExampleWeatherDataModels() {
        WeatherDataModel first = buildWeatherDataModel(DateUtils.fromPattern("2017-02-05 12:30"));
        weatherDataModelRepository.save(first);

        WeatherDataModel second = buildWeatherDataModel(DateUtils.fromPattern("2017-03-05 12:30"));
        weatherDataModelRepository.save(second);

        WeatherDataModel third = buildWeatherDataModel(DateUtils.fromPattern("2017-05-05 12:30"));
        weatherDataModelRepository.save(third);
    }

    private WeatherDataModel buildWeatherDataModel(Date date) {
        return WeatherDataModel.builder()
                .withDateTime(date)
                .build();
    }

}