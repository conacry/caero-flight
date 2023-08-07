package org.conacry.caero.adapter.repository.model;

import lombok.Getter;
import lombok.Setter;
import org.conacry.caero.domain.entity.*;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
public class FlightDbModel {
    private UUID flightID;
    private int number;
    private AirportDbModel departureAirport;
    private AirportDbModel arrivalAirport;
    private AircraftDbModel aircraft;
    private String scheduledDeparture;
    private String scheduledArrival;
    private String actualDeparture;
    private String actualArrival;
    private String status;
    private String createdAt;
    private String updatedAt;
}
