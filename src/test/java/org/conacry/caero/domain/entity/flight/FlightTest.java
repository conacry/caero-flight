package org.conacry.caero.domain.entity.flight;

import org.conacry.caero.domain.entity.FlightError;
import org.conacry.caero.shared.exception.CodedException;
import org.junit.jupiter.api.Test;
import testdouble.entity.FlightStub;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class FlightTest {
    @Test
    void setActualArrival_TimeIsNull_ThrowEx() {
        var flight = FlightStub.getFullFlight();
        var ex = assertThrows(CodedException.class, () -> flight.setActualArrival(null));
        assertEquals(FlightError.ACTUAL_ARRIVAL_IS_REQUIRED,ex.getCode());

    }

    @Test
    void setActualDeparture_IsNull_ThrowEx() {
        var flight = FlightStub.getFullFlight();
        var ex = assertThrows(CodedException.class, () -> flight.setActualDeparture(null));
        assertEquals(FlightError.ACTUAL_DEPARTURE_IS_REQUIRED, ex.getCode());
    }

    @Test
    void set_ValidValue_setActualArrival() {
        var flight = FlightStub.getBaseFlight();
        assertNull(flight.getActualArrival());

        var actualArrival = Instant.now();
        flight.setActualArrival(actualArrival);
        assertNotNull(flight.getActualArrival());
        assertEquals(actualArrival, flight.getActualArrival());
    }

    @Test
    void setActualDeparture_setActualDeparture() {
        var flight = FlightStub.getBaseFlight();
        assertNull(flight.getActualDeparture());

        var actualDeparture = Instant.now();
        flight.setActualDeparture(actualDeparture);
        assertEquals(actualDeparture, flight.getActualDeparture());
    }
}
