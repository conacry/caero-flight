package org.conacry.caero.domain.entity;

import java.util.regex.Pattern;

public class FlightNumber {

    private static final Pattern FORMAT_PATTERN = Pattern.compile("[^a-zA-Z0-9-]");

    private final String value;

    private FlightNumber(String value) {
        this.value = value;
    }

    public static FlightNumber of(String flightNumberStr) {
        if (flightNumberStr == null || flightNumberStr.isBlank()) {
            throw FlightError.errFlightNumberIsRequired();
        }

        var matcher = FORMAT_PATTERN.matcher(flightNumberStr);
        if (matcher.find()) {
            throw FlightError.errIllegalFlightNumber(flightNumberStr);
        }

        return new FlightNumber(flightNumberStr);
    }

    public String getValue() {
        return value;
    }
}
