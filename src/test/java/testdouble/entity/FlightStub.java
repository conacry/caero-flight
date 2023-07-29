package testdouble.entity;

import org.conacry.caero.domain.entity.*;

import java.time.Instant;

public class FlightStub {

    public static Flight getFlight() {
        var status = FlightStatus.ARRIVED;

        return new FlightBuilder().
                id(FlightID.newID()).
                number(FlightNumberStub.getFlightNumber()).
                aircraft(AircraftStub.getAircraft()).
                scheduledArrival(Instant.now()).
                scheduledDeparture(Instant.now()).
                actualArrival(Instant.now()).
                actualDeparture(Instant.now()).
                createdAt(Instant.now()).
                updatedAt(Instant.now()).
                build();

    }
}
