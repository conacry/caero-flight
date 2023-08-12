package org.conacry.caero.domain.usecase;

import org.conacry.caero.domain.entity.AircraftID;
import org.conacry.caero.domain.entity.AirportID;
import org.conacry.caero.domain.entity.FlightID;
import org.conacry.caero.shared.exception.CodedException;

public class UsecaseError {
    public static final String AIRPORT_ALREADY_EXIST = "214d9c61-001";
    public static final String AIRPORT_INFO_IS_NULL = "214d9c61-002";
    public static final String FLIGHT_NOT_FOUND = "1d3537b5-003";
    public static final String FLIGHT_INFO_IS_NULL = "214d9c61-004";
    public static final String FLIGHT_ALREADY_EXIST = "214d9c61-005";
    public static final String DEPARTURE_AIRPORT_NOT_FOUND = "214d9c61-006";
    public static final String ARRIVAL_AIRPORT_NOT_FOUND = "214d9c61-007";
    public static final String AIRCRAFT_NOT_FOUND = "214d9c61-008";

    public static CodedException errAirportAlreadyExist() {
        var errMsg = "Airport already exist";
        return new CodedException(AIRPORT_ALREADY_EXIST, errMsg);
    }

    public static CodedException errAirportInfoIsNull() {
        var errMsg = "Airport info cannot be null";
        return new CodedException(AIRPORT_INFO_IS_NULL, errMsg);
    }
    public static CodedException errFlightInfoIsNull() {
        var errMsg = "Flight info cannot be null";
        return new CodedException(FLIGHT_INFO_IS_NULL, errMsg);
    }

    public static CodedException errFlightNotFound(FlightID flightID) {
        var errMsg = String.format("Flight with ID: %s not found", flightID.toString());
        return new CodedException(FLIGHT_NOT_FOUND, errMsg);
    }
    public static CodedException errFlightAlreadyExist() {
        var errMsg = "Flight already exist";
        return new CodedException(FLIGHT_ALREADY_EXIST, errMsg);
    }
    public static CodedException errDepartureAirportNotFound(AirportID airportID) {
        var errMsg = String.format("Departure airport: %s not found", airportID.toString());
        return new CodedException(DEPARTURE_AIRPORT_NOT_FOUND, errMsg);
    }

    public static CodedException errArrivalAirportNotFound(AirportID airportID) {
        var errMsg = String.format("Arrival Airport: %s not found", airportID.toString());
        return new CodedException(ARRIVAL_AIRPORT_NOT_FOUND, errMsg);
    }
    public static CodedException errAircraftOptNotFound(AircraftID aircraftID) {
        var errMsg = String.format("Aircraft with ID: %s not found", aircraftID.toString());
        return new CodedException(AIRCRAFT_NOT_FOUND, errMsg);
    }



}
