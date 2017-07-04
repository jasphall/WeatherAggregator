package com.sikorski.weatheraggregator.application.dto;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class NamedParameters {

    private Map<String, Object> parameters;

    public NamedParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
    }

    public static NamedParameters empty() {
        return new NamedParameters(Collections.emptyMap());
    }

    /**
     * Obiekt z pojedynczym parametrem
     *
     * @param key
     *      nazwa parametru
     * @param value
     *      wartość parametru
     * @return
     */
    public static NamedParameters oneParameter(String key, Object value) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put(key, value);

        return new NamedParameters(parameters);
    }

    public Map<String, Object> getParameters() {
        return parameters;
    }

    /**
     * Pobiera z listy parametrów wartość parametru o podanej nazwie (jeżeli istnieje)
     *
     * @param name
     * @return
     */
    public Optional<Object> getParameterIfExists(String name) {
        if (parameters.containsKey(name)) {
            return Optional.ofNullable(parameters.get(name));
        }

        return Optional.empty();
    }

    /**
     * Zwraca ilość parametrów
     *
     * @return
     */
    public int length() {
        return parameters.size();
    }
}
