package org.conacry.caero.domain.entity;

import org.conacry.caero.shared.exception.CodedException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AirportNameTest {

    @Test
    void from_ValueIsNull_ThrowEx() {
        var ex = assertThrows(CodedException.class, () -> AirportName.from(null));
        assertEquals(AirportError.AIRPORT_NAME_REQUIRED, ex.getCode());
    }

    @Test
    void from_ValueIsEmpty_ThrowEx() {
        var emptyValue = "";
        var ex = assertThrows(CodedException.class, () -> AirportName.from(emptyValue));
        assertEquals(AirportError.AIRPORT_NAME_REQUIRED, ex.getCode());
    }

    @Test
    void from_IllegalValue_ThrowEx() {
        var illegalStrings = List.of("@b", "boeing#4", "airbus!-", "%");

        for (var illegalValue : illegalStrings) {
            var ex = assertThrows(CodedException.class, () -> AirportName.from(illegalValue));
            assertEquals(AirportError.AIRPORT_NAME_ILLEGAL_FORMAT, ex.getCode());
        }
    }

    @Test
    void from_ValidValue_ReturnModel() {
        var validValue = "Boeing-747";
        var airportName = AirportName.from(validValue);
        assertNotNull(airportName);
        assertEquals(validValue, airportName.getValue());
    }
}