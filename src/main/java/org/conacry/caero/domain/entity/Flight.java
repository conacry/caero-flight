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


    public Instant getActualDeparture() {
        return actualDeparture;
    }

    public void setActualDeparture(Instant actualDeparture) {
        if (actualDeparture == null) {
            throw FlightError.errActualDepartureIsRequired();
        }

        this.actualDeparture = actualDeparture;
    }

    public Instant getActualArrival() {
        return actualArrival;
    }

    public void setActualArrival(Instant actualArrival) {
        if (actualArrival == null) {
            throw FlightError.errAclualArrivalIsRequired();
        }
        this.actualArrival = actualArrival;
    }
}
