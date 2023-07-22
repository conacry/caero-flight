package org.conacry.caero.domain.entity;

import org.conacry.caero.shared.exception.CodedException;

public final class FlightError {

    public static final String FLIGHT_NUMBER_REQUIRED = "3ab992f0-001";
    public static final String ILLEGAL_FLIGHT_NUMBER = "3ab992f0-002";

    public static CodedException errFlightNumberIsRequired() {
        var errMsg = "Value to create FlightNumber is required";
        return new CodedException(FLIGHT_NUMBER_REQUIRED, errMsg);
    }

    public static CodedException errIllegalFlightNumber(String flightNumberStr) {
        var errMsg = String.format("Illegal value = '%s' format to create FlightNumber", flightNumberStr);
        return new CodedException(ILLEGAL_FLIGHT_NUMBER, errMsg);

    }
}
