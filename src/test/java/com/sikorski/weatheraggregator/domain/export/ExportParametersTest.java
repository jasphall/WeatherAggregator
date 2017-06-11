package com.sikorski.weatheraggregator.domain.export;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.junit.Assert.*;

public class ExportParametersTest {

    @Test
    public void test_one_parameter_returns_correct_parameters_number() {
        // given
        String key = "key";
        Long value = 0l;

        // when
        ExportParameters parameters = ExportParameters.oneParameter(key, value);

        // then
        Assert.assertEquals(1, parameters.length());
    }

    @Test
    public void test_get_parameter_returns_parameter_when_it_exists() {
        // given
        ExportParameters parameters = givenParameters();
        String parameterName = "parameter1";

        // when
        Optional<Object> parameter = parameters.getParameterIfExists(parameterName);

        // then
        assertTrue(parameter.isPresent());
    }

    @Test
    public void test_get_parameter_returns_optional_null_when_parameter_not_exists() {
        // given
        ExportParameters parameters = givenParameters();
        String parameterName = "parameter4";

        // when
        Optional<Object> parameter = parameters.getParameterIfExists(parameterName);

        // then
        assertFalse(parameter.isPresent());
    }

    private ExportParameters givenParameters() {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("parameter1", 1);
        parameters.put("parameter2", 2);
        parameters.put("parameter3", 3);

        return new ExportParameters(parameters);
    }

}