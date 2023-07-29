package org.conacry.caero.domain.entity.flight;

import org.conacry.caero.domain.entity.Flight;
import org.conacry.caero.domain.entity.FlightError;
import org.conacry.caero.shared.exception.CodedException;
import org.junit.jupiter.api.Test;
import testdouble.entity.FlightStub;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FlightTest {
    @Test
    void setActualArrival_TimeIsNull_ThrowEx() {
        var flight = FlightStub.getFlight();
        var ex = assertThrows(CodedException.class, () -> flight.setActualArrival(null));
        assertEquals(FlightError.ACTUAL_ARRIVAL_IS_REQUIRED,ex.getCode());
    }
}
