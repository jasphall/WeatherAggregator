package com.sikorski.weatheraggregator.qualityscoring.domain;

import java.util.List;

public interface QualityMeasurable {

    /**
     * Nazwy pól, które będą ignorowane w pomiarze jakości
     * @return
     */
    List<String> ignoredFieldNames();

    /**
     * Ilość wypełnionych wartości
     * @return
     */
    int filledValuesSize();

}
