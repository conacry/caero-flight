package org.conacry.caero.domain.entity;

import java.time.Instant;

public class Flight {
    private FlightID id;
    private FlightNumber number;
    //private Airport departureAirport;
    //private Airport arrivalAirport;
    private Aircraft aircraft;
    private Instant scheduledDeparture;
    private Instant scheduledArrival;
    private Instant actualDeparture;
    private Instant actualArrival;
    private FlightStatus status;
    private Instant createdAt;
    private Instant updatedAt;

    Flight(FlightID id,
           FlightNumber number,
           Aircraft aircraft,
           Instant scheduledDeparture,
           Instant scheduledArrival,
           Instant actualDeparture,
           Instant actualArrival,
           FlightStatus status,
           Instant createdAt,
           Instant updatedAt) {
        this.id = id;
        this.number = number;
        this.aircraft = aircraft;
        this.scheduledDeparture = scheduledDeparture;
        this.scheduledArrival = scheduledArrival;
        this.actualDeparture = actualDeparture;
        this.actualArrival = actualArrival;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
