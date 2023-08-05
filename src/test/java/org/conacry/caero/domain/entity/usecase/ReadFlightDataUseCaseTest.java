package org.conacry.caero.domain.entity.usecase;

import org.conacry.caero.domain.entity.Flight;
import org.conacry.caero.shared.exception.CodedException;
import org.junit.jupiter.api.Test;
import testdouble.entity.FlightStub;

import static org.junit.jupiter.api.Assertions.*;

class ReadFlightDataUseCaseTest {
    @Test
    void findByID_IsNull_ThrowEx() {
        var flight = FlightStub.getBaseFlight();
        var ex = assertThrows(CodedException.class, () -> );
    }

}