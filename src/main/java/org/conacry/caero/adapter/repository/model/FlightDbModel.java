package org.conacry.caero.adapter.repository.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
public class FlightDbModel {
    private UUID flightID;
    private int number;
    private AirportDbModel departureAirport;
    private AirportDbModel arrivalAirport;
    private AircraftDbModel aircraft;
    private long scheduledDeparture;
    private long scheduledArrival;
    private long actualDeparture;
    private long actualArrival;
    private String status;
    private long createdAt;
    private long updatedAt;
}
