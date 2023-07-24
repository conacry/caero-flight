package testdouble.entity;

import org.conacry.caero.domain.entity.Flight;

public class FlightStub {

    public static Flight getFlight() {
        return new Flight();
    }
}
