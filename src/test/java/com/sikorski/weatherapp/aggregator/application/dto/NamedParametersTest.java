package com.sikorski.weatherapp.aggregator.application.dto;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NamedParametersTest {

    @Test
    public void test_one_parameter_returns_correct_parameters_number() {
        // given
        String key = "key";
        Long value = 0l;

        // when
        NamedParameters parameters = NamedParameters.oneParameter(key, value);

        // then
        Assert.assertEquals(1, parameters.length());
    }

    @Test
    public void test_get_parameter_returns_parameter_when_it_exists() {
        // given
        NamedParameters parameters = givenParameters();
        String parameterName = "parameter1";

        // when
        Optional<Object> parameter = parameters.getParameterIfExists(parameterName);

        // then
        assertTrue(parameter.isPresent());
    }

    @Test
    public void test_get_parameter_returns_optional_null_when_parameter_not_exists() {
        // given
        NamedParameters parameters = givenParameters();
        String parameterName = "parameter4";

        // when
        Optional<Object> parameter = parameters.getParameterIfExists(parameterName);

        // then
        assertFalse(parameter.isPresent());
    }

    private NamedParameters givenParameters() {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("parameter1", 1);
        parameters.put("parameter2", 2);
        parameters.put("parameter3", 3);

        return new NamedParameters(parameters);
    }

}