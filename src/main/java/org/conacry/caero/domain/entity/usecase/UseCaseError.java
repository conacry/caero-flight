package org.conacry.caero.domain.entity.usecase;

import org.conacry.caero.domain.entity.FlightID;
import org.conacry.caero.shared.exception.CodedException;

public class UseCaseError {

    public static final String FLIGHT_NOT_FOUND = "1d3537b5-001";

    public static CodedException errFlightNotFound(FlightID flightID) {
        var errMsg = "Flight not found";
        return new CodedException(FLIGHT_NOT_FOUND, errMsg);
    }
}
