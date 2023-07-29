package testdouble.entity;

import org.conacry.caero.domain.entity.FlightNumber;

public class FlightNumberStub {

    public static FlightNumber getFlightNumber() {
        return FlightNumber.of("K-1107");
    }
}
