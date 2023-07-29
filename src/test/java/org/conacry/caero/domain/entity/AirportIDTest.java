package org.conacry.caero.domain.entity;

import org.conacry.caero.shared.exception.CodedException;
import org.junit.jupiter.api.Test;
import util.generator.StringGenerator;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class AirportIDTest {

    @Test
    void newID_ReturnAirportID() {
        var airportID = AirportID.newID();
        assertNotNull(airportID);
    }

    @Test
    void from_ValueStrIsNull_ThrowEx() {
        var ex = assertThrows(CodedException.class, () -> AirportID.from(null));
        assertEquals(AirportError.AIRPORT_ID_VALUE_IS_REQUIRED, ex.getCode());
        assertFalse(ex.getMessage().isEmpty());
    }

    @Test
    void from_ValueStrIsEmpty_ThrowEx() {
        var emptyValueStr = "";
        var ex = assertThrows(CodedException.class, () -> AirportID.from(emptyValueStr));
        assertEquals(AirportError.AIRPORT_ID_VALUE_IS_REQUIRED, ex.getCode());
        assertFalse(ex.getMessage().isEmpty());
    }

    @Test
    void from_IllegalFormatOfValueStr_ThrowEx() {
        var strWithIllegalFormat = StringGenerator.getRandomString();
        var ex = assertThrows(CodedException.class, () -> AirportID.from(strWithIllegalFormat));
        assertEquals(AirportError.ILLEGAL_AIRPORT_ID_VALUE, ex.getCode());
        assertFalse(ex.getMessage().isEmpty());
        assertNotNull(ex.getCause());
    }

    @Test
    void from_ValidValueStr_ReturnAirportID() {
        var validValueStr = UUID.randomUUID().toString();
        var airportID = AirportID.from(validValueStr);
        assertNotNull(airportID);
        assertEquals(validValueStr, airportID.getValue().toString());
    }

}
