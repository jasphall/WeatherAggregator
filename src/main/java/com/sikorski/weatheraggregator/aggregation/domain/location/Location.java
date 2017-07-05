package com.sikorski.weatheraggregator.aggregation.domain.location;

import com.sikorski.weatheraggregator.application.persistence.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "LOCATIONS")
@NoArgsConstructor
@Getter
public class Location extends BaseEntity {

    public static LocationBuilder builder() {
        return new LocationBuilder();
    }

    /**
     * Miasto
     */
    private String cityName;

    /**
     * Województwo
     */
    private String provinceName;

    /**
     * Kraj
     */
    private String countryName;

    public Location(LocationBuilder builder) {
        this.cityName = builder.getCityName();
        this.provinceName = builder.getProvinceName();
        this.countryName = builder.getCountryName();
    }

    public static Location ofCity(String cityName) {
        return new Location(new LocationBuilder().withCity(cityName));
    }
}
