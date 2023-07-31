package org.conacry.caero.domain.entity;

import java.time.Instant;

public class FlightBuilder {
    private FlightID id;
    private FlightNumber number;
    private Airport departureAirport;
    private Airport arrivalAirport;
    private Aircraft aircraft;
    private Instant scheduledDeparture;
    private Instant scheduledArrival;
    private Instant actualDeparture;
    private Instant actualArrival;
    private FlightStatus status;
    private Instant createdAt;
    private Instant updatedAt;

    public FlightBuilder id(FlightID id) {
        this.id = id;
        return this;
    }

    public FlightBuilder number(FlightNumber number) {
        this.number = number;
        return this;
    }

    public FlightBuilder departureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
        return this;
    }

    public FlightBuilder arrivalAirport(Airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
        return this;
    }

    public FlightBuilder aircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
        return this;
    }

    public FlightBuilder scheduledDeparture(Instant scheduledDeparture) {
        this.scheduledDeparture = scheduledDeparture;
        return this;
    }

    public FlightBuilder scheduledArrival(Instant scheduledArrival) {
        this.scheduledArrival = scheduledArrival;
        return this;
    }

    public FlightBuilder actualDeparture(Instant actualDeparture) {
        this.actualDeparture = actualDeparture;
        return this;
    }

    public FlightBuilder actualArrival(Instant actualArrival) {
        this.actualArrival = actualArrival;
        return this;
    }

    public FlightBuilder status(FlightStatus status) {
        this.status = status;
        return this;
    }

    public FlightBuilder createdAt(Instant createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public FlightBuilder updatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    private void checkRequiredFields() {
        if (this.id == null) {
            throw FlightError.errFlightIDValueIsRequired();
        }
        if (this.number == null) {
            throw FlightError.errFlightNumberIsRequired();
        }
        if (this.departureAirport == null) {
            throw FlightError.errDepartureAirportIsRequired();
        }
        if (this.arrivalAirport == null) {
            throw FlightError.errArrivalAirportIsRequired();
        }
        if (this.aircraft == null) {
            throw FlightError.errAircraftIsRequired();
        }
        if (this.scheduledDeparture == null) {
            throw FlightError.errScheduledDepartureIsRequired();
        }
        if (this.scheduledArrival == null) {
            throw FlightError.errScheduledArrivalIsRequired();
        }
        if (this.status == null) {
            throw FlightError.errStatusIsRequired();
        }
        if (this.createdAt == null) {
            throw FlightError.errCreatedAtIsRequired();
        }
        if (this.updatedAt == null) {
            throw FlightError.errUpdatedAtIsRequired();
        }
    }

    public Flight build() {
        this.checkRequiredFields();

        return new Flight(
                this.id,
                this.number,
                this.departureAirport,
                this.arrivalAirport,
                this.aircraft,
                this.scheduledDeparture,
                this.scheduledArrival,
                this.actualDeparture,
                this.actualArrival,
                this.status,
                this.createdAt,
                this.updatedAt);
    }

}
