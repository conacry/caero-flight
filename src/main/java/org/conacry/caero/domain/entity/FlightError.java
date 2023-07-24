package org.conacry.caero.domain.entity;

import org.conacry.caero.shared.exception.CodedException;

public final class FlightError {

    public static final String FLIGHT_NUMBER_REQUIRED = "3d1f50e6-001";
    public static final String ILLEGAL_FLIGHT_NUMBER = "3d1f50e6-002";
    public static final String FLIGHT_ID_VALUE_IS_REQUIRED = "3d1f50e6-003";
    public static final String ILLEGAL_FLIGHT_ID_VALUE = "3d1f50e6-004";


    public static CodedException errFlightNumberIsRequired() {
        var errMsg = "Value to create FlightNumber is required";
        return new CodedException(FLIGHT_NUMBER_REQUIRED, errMsg);
    }

    public static CodedException errIllegalFlightNumber(String flightNumberStr) {
        var errMsg = String.format("Illegal value = '%s' format to create FlightNumber", flightNumberStr);
        return new CodedException(ILLEGAL_FLIGHT_NUMBER, errMsg);
    }

    public static CodedException errFlightIDValueIsRequired() {
        var errMsg = "Value to create FlightID is required";
        return new CodedException(FLIGHT_ID_VALUE_IS_REQUIRED, errMsg);
    }

    public static CodedException errIllegalFlightIDValue(String valueStr, Throwable cause) {
        var errMsg = String.format("Illegal value = '%s' format to create FlightID", valueStr);
        return new CodedException(ILLEGAL_FLIGHT_ID_VALUE, errMsg, cause);
    }
}
