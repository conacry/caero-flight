package org.conacry.caero.boundary.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateFlightInfo {

    private String flightNumber;
    private String departureAirportId;
    private String arrivalAirportId;
    private String aircraftId;
    private long scheduledDeparture;
    private long scheduledArrival;
}
