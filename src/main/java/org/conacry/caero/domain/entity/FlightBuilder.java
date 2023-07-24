package org.conacry.caero.domain.entity;

import java.time.Instant;

public class FlightBuilder {
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

    public FlightBuilder id (FlightID id) {
        this.id = id;
        return this;
    }
    public FlightBuilder number (FlightNumber number) {
        this.number = number;
        return this;
    }
    public FlightBuilder aircraft (Aircraft aircraft) {
        this.aircraft = aircraft;
        return this;
    }
    public FlightBuilder scheduledDeparture (Instant scheduledDeparture) {
        this.scheduledDeparture = scheduledDeparture;
        return this;
    }
    public FlightBuilder scheduledArrival (Instant scheduledArrival) {
        this.scheduledArrival = scheduledArrival;
        return this;
    }
    public FlightBuilder status (FlightStatus status) {
        this.status = status;
        return this;
    }
    public FlightBuilder createdAt (Instant createdAt) {
        this.createdAt = createdAt;
        return this;
    }
    public FlightBuilder updatedAt (Instant updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }
    private void checkRequiredFields() {
        if(this.id == null){
            throw AircraftError.errAircraftIDIsRequired();
        }
        if(this.model == null){
            throw AircraftError.errModelIsRequired();
        }
        if (this.status == null) {
            throw AircraftError.errStatusIsRequired();
        }
    }

}
