package org.conacry.caero.domain.entity;

import org.conacry.caero.shared.exception.CodedException;

public final class FlightError {

    public static final String FLIGHT_NUMBER_REQUIRED = "3d1f50e6-001";
    public static final String ILLEGAL_FLIGHT_NUMBER = "3d1f50e6-002";
    public static final String FLIGHT_ID_VALUE_IS_REQUIRED = "3d1f50e6-003";
    public static final String ILLEGAL_FLIGHT_ID_VALUE = "3d1f50e6-004";
    public static final String AIRCRAFT_IS_REQUIRED = "3d1f50e6-005";
    public static final String SCHEDULED_DEPARTURE_IS_REQUIRED = "3d1f50e6-006";
    public static final String SCHEDULED_ARRIVAL_IS_REQUIRED = "3d1f50e6-007";
    public static final String STATUS_IS_REQUIRED = "3d1f50e6-008";
    public static final String CREATED_AT_IS_REQUIRED = "3d1f50e6-009";
    public static final String UPDATED_AT_IS_REQUIRED = "3d1f50e6-010";
    public static final String ACTUAL_ARRIVAL_IS_REQUIRED =  "3d1f50e6-011";

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

    public static CodedException errAircraftIsRequired() {
        var errMsg = "Value to create Aircraft is required";
        return new CodedException(AIRCRAFT_IS_REQUIRED, errMsg);
    }

    public static CodedException errScheduledDepartureIsRequired() {
        var errMsg = "Value to create scheduledDeparture is required";
        return new CodedException(SCHEDULED_DEPARTURE_IS_REQUIRED, errMsg);
    }

    public static CodedException errScheduledArrivalIsRequired() {
        var errMsg = "Value to create scheduledArrival is required";
        return new CodedException(SCHEDULED_ARRIVAL_IS_REQUIRED, errMsg);
    }

    public static CodedException errStatusIsRequired() {
        var errMsg = "Value to create status is required";
        return new CodedException(STATUS_IS_REQUIRED, errMsg);
    }

    public static CodedException errCreatedAtIsRequired() {
        var errMsg = "Value to create createdAt is required";
        return new CodedException(CREATED_AT_IS_REQUIRED, errMsg);
    }

    public static CodedException errUpdatedAtIsRequired() {
        var errMsg = "Value to create updatedAt is required";
        return new CodedException(UPDATED_AT_IS_REQUIRED, errMsg);
    }

    public static CodedException errActualArrivalIsRequired() {
        var errMsg = "Actual arrival is required";
        return new CodedException(ACTUAL_ARRIVAL_IS_REQUIRED, errMsg);
    }
}
