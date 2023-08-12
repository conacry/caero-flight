package org.conacry.caero.boundary.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateFlightInfo {

    private String flightNumber;
    private String departureAirportID;
    private String arrivalAirportID;
    private String aircraftID;
    private long scheduledDeparture;
    private long scheduledArrival;
}
