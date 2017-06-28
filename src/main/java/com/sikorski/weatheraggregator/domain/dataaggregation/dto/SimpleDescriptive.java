package com.sikorski.weatheraggregator.domain.dataaggregation.dto;

/**
 * Interfejs określa, że obiekt musi być opisany poprzez krótki opis,
 * który może być później zrzucany na przykład do pliku czy innej zewnętrznej formy
 */
public interface SimpleDescriptive {

    /**
     * Zwraca prosty opis obiektu
     * @return
     */
    String toOneLiner();

}
