package org.conacry.caero.domain.entity;

import java.util.Objects;
import java.util.regex.Pattern;

public class AirportName {

    private static final Pattern FORMAT_PATTERN = Pattern.compile("[^a-zA-Z0-9- ]");

    private final String value;

    public static AirportName from(String value) {
        if (value == null || value.isBlank()) {
            throw AirportError.errAirportNameValueIsRequired();
        }

        var matcher = FORMAT_PATTERN.matcher(value);
        if (matcher.find()) {
            throw AirportError.errIllegalAirportNameValue(value);
        }

        return new AirportName(value);
    }

    private AirportName(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        var airportName = (AirportName) o;
        return Objects.equals(value, airportName.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
