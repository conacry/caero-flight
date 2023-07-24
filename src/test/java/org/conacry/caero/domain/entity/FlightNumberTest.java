package org.conacry.caero.domain.entity;

import org.conacry.caero.shared.exception.CodedException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FlightNumberTest {

    @Test
    void of_ValueIsNull_ThrowEx() {
        var ex = assertThrows(CodedException.class, () -> FlightNumber.of(null));
        assertEquals(FlightError.FLIGHT_NUMBER_REQUIRED, ex.getCode());
    }

    @Test
    void of_ValueIsBlank_ThrowEx() {
        var blankValue = " ";
        var ex = assertThrows(CodedException.class, () -> FlightNumber.of(blankValue));
        assertEquals(FlightError.FLIGHT_NUMBER_REQUIRED, ex.getCode());
    }

    @Test
    void of_ValueIsIllegal_ThrowEx() {
        var illegalStrings = List.of("@b", "F#", "2!-", "%");

        for (var illegalValue : illegalStrings) {
            var ex = assertThrows(CodedException.class, () -> FlightNumber.of(illegalValue));
            assertEquals(FlightError.ILLEGAL_FLIGHT_NUMBER, ex.getCode());
        }
    }

    @Test
    void of_ValidValue_ReturnFlightNumber() {
        var validValue = "K-1107";
        var flightNumber = FlightNumber.of(validValue);
        assertNotNull(flightNumber);
        assertEquals(validValue, flightNumber.getValue());
    }
}
