package com.sikorski.weatheraggregator.aggregation.domain.location;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class LocationBuilder {

    private String cityName;
    private String provinceName;
    private String countryName;

    public LocationBuilder withCity(String cityName) {
        this.cityName = cityName;
        return this;
    }

    public LocationBuilder withProvince(String provinceName) {
        this.provinceName = provinceName;
        return this;
    }

    public LocationBuilder withCountry(String countryName) {
        this.countryName = countryName;
        return this;
    }

    public Location build() {
        return new Location(this);
    }

}
