package com.sikorski.weatherapp.aggregator.qualityscoring.domain;

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

    /**
     * Ilość wszystkich możliwych do wypełnienia wartości
     * @return
     */
    int allFillableValuesSize();

}
