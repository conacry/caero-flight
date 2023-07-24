package org.conacry.caero.domain.entity;

public class City {

    private final String value;

    public City(String value) {
        this.value = value;
    }

    public static City of(String cityStr) {
        if (cityStr == null || cityStr.isBlank()) {
            throw AirportError.errAirportCityIsRequired();
        }
        return new City(cityStr);
    }

    public String getValue() {
        return value;
    }
}
