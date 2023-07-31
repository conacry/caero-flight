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

    public void setActualArrival(Instant time) {
        if (time == null) {
            throw FlightError.errActualArrivalIsRequired();
        }

        this.actualArrival = time;
    }

    public void setActualDeparture(Instant time) {
        if (time == null) {
            throw FlightError.errActualDepartureIsRequired();
        }

        this.actualDeparture = time;
    }

    public FlightID getId() {
        return id;
    }

    public FlightNumber getNumber() {
        return number;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public Instant getScheduledDeparture() {
        return scheduledDeparture;
    }

    public Instant getScheduledArrival() {
        return scheduledArrival;
    }

    public Instant getActualDeparture() {
        return actualDeparture;
    }

    public Instant getActualArrival() {
        return actualArrival;
    }

    public FlightStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
