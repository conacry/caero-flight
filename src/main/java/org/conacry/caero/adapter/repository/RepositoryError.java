package org.conacry.caero.adapter.repository;

import org.conacry.caero.shared.exception.CodedException;

public final class RepositoryError {

    public static final String AIRPORT_IS_REQUIRED = "7ed7af32-001";
    public static final String AIRPORT_ID_IS_REQUIRED = "7ed7af32-002";
    public static final String AIRPORT_DB_MODEL_IS_REQUIRED = "7ed7af32-003";
    public static final String AIRPORTS_IS_REQUIRED = "7ed7af32-004";
    public static final String AIRPORT_DB_MODELS_IS_REQUIRED = "7ed7af32-005";
    public static final String FLIGHT_IS_REQUIRED = "7ed7af32-006";

    public static CodedException errAirportIsRequired() {
        var errMsg = "Value to create Airport is required";
        return new CodedException(AIRPORT_IS_REQUIRED, errMsg);
    }

    public static CodedException errAirportIDIsRequired() {
        var errMsg = "Value to create AirportID is required";
        return new CodedException(AIRPORT_ID_IS_REQUIRED, errMsg);
    }

    public static CodedException errAirportDbModelIsRequired() {
        var errMsg = "Value to create AirportDbModel is required";
        return new CodedException(AIRPORT_DB_MODEL_IS_REQUIRED, errMsg);
    }

    public static CodedException errAirportsIsRequired() {
        var errMsg = "Value to create Airports is required";
        return new CodedException(AIRPORTS_IS_REQUIRED, errMsg);
    }

    public static CodedException errAirportDbModelsIsRequired() {
        var errMsg = "Value to create AirportDbModels is required";
        return new CodedException(AIRPORT_DB_MODELS_IS_REQUIRED, errMsg);
    }

    public static CodedException errFlightIsRequired() {
        var errMsg = "Flight is required";
        return new CodedException(FLIGHT_IS_REQUIRED, errMsg)
    }

    private RepositoryError() {}
}
