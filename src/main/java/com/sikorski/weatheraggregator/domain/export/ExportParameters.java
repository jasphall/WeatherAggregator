package com.sikorski.weatheraggregator.domain.export;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Obiekt przechowujący parametry eksportu pliku
 */
public class ExportParameters {

    private Map<String, Object> parameters;

    public ExportParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
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
    public static ExportParameters oneParameter(String key, Object value) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put(key, value);

        return new ExportParameters(parameters);
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
            return Optional.of(parameters.get(name));
        }

        return Optional.empty();
    }
}
