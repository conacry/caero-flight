package org.conacry.caero.domain.entity;

import org.conacry.caero.shared.exception.CodedException;
import org.junit.jupiter.api.Test;
import testdouble.entity.FlightStub;

import static org.junit.jupiter.api.Assertions.*;

class FlightTest {

    @Test
    void setActualDeparture_ParamIsNull_ThrowEx() {
        var flight = FlightStub.getFlight();
        var ex = assertThrows(CodedException.class, () -> flight.setActualDeparture(null));
        assertEquals(FlightError.FLIGHT_ACTUAL_DEPATURE_IS_REQUIRED, ex.getCode());
    }
}