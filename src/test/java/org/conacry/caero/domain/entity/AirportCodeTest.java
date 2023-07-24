package org.conacry.caero.domain.entity;

import org.conacry.caero.shared.exception.CodedException;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AirportCodeTest {

    @Test
    void of_CodeValueIsNull_ThrowEx() {
        var ex = assertThrows(CodedException.class, () -> AirportCode.of(null));
        assertEquals(AirportError.AIRPORT_CODE_VALUE_EMPTY, ex.getCode());
    }

    @Test
    void of_CodeValueIsBlank_ThrowEx() {
        var blankValue = " ";
        var ex = assertThrows(CodedException.class, () -> AirportCode.of(blankValue));
        assertEquals(AirportError.AIRPORT_CODE_VALUE_EMPTY, ex.getCode());
    }

    @Test
    void of_CodeValueIsTooLongLength_ThrowEx() {
        var longLength = "ABCD";
        var ex = assertThrows(CodedException.class, () -> AirportCode.of(longLength));
        assertEquals(AirportError.AIRPORT_CODE_VALUE_ILLEGAL_FORMAT, ex.getCode());
    }

    @Test
    void of_CodeValueIsIllegalFormat_ThrowEx() {
        var illegalStrings = List.of("abc", "123", "a23", "@42");
        for (String illegalString: illegalStrings) {
            var ex = assertThrows(CodedException.class, () -> AirportCode.of(illegalString));
            assertEquals(AirportError.AIRPORT_CODE_VALUE_ILLEGAL_FORMAT, ex.getCode());
        }
    }

    @Test
    void of_CodeValueIsValid_ReturnAirportCode() {
        var codeValue = "ABC";
        var airportCode = AirportCode.of(codeValue);

        assertNotNull(airportCode);
        assertEquals(codeValue, airportCode.getValue());
    }



}