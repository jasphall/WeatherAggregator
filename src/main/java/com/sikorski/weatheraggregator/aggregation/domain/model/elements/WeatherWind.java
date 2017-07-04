package com.sikorski.weatheraggregator.aggregation.domain.model.elements;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class WeatherWind {

    private Integer chill;
    private Integer direction;
    private Float speed;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WeatherWind that = (WeatherWind) o;

        if (chill != null ? !chill.equals(that.chill) : that.chill != null) return false;
        if (direction != null ? !direction.equals(that.direction) : that.direction != null) return false;
        return speed != null ? speed.equals(that.speed) : that.speed == null;
    }

    @Override
    public int hashCode() {
        int result = chill != null ? chill.hashCode() : 0;
        result = 31 * result + (direction != null ? direction.hashCode() : 0);
        result = 31 * result + (speed != null ? speed.hashCode() : 0);
        return result;
    }
}
