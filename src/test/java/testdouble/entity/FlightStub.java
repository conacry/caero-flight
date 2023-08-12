package testdouble.entity;

import org.conacry.caero.domain.entity.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FlightStub {

    public static Flight getBaseFlight() {
        return new FlightBuilder().
                id(FlightID.newID()).
                number(FlightNumberStub.getFlightNumber()).
                aircraft(AircraftStub.getAircraft()).
                scheduledArrival(Instant.now()).
                scheduledDeparture(Instant.now()).
                departureAirport(AirportStub.getAirport()).
                arrivalAirport(AirportStub.getAirport()).
                createdAt(Instant.now()).
                updatedAt(Instant.now()).
                status(FlightStatus.SCHEDULED).
                build();
    }

    public static Flight getFullFlight() {
        var status = FlightStatus.ARRIVED;

        return new FlightBuilder().
                id(FlightID.newID()).
                number(FlightNumberStub.getFlightNumber()).
                aircraft(AircraftStub.getAircraft()).
                scheduledArrival(Instant.now()).
                departureAirport(AirportStub.getAirport()).
                arrivalAirport(AirportStub.getAirport()).
                scheduledDeparture(Instant.now()).
                actualArrival(Instant.now()).
                actualDeparture(Instant.now()).
                createdAt(Instant.now()).
                updatedAt(Instant.now()).
                status(FlightStatus.SCHEDULED).
                build();
    }
    public static List<Flight> getListFullFlight(int count) {
        if (count <= 0) {
            return Collections.emptyList();
        }

        var flightList = new ArrayList<Flight>(count);

        while (flightList.size() < count){
            flightList.add(getFullFlight());
        }

        return flightList;
    }
}
