package org.conacry.caero.domain.entity.flight;

import org.conacry.caero.domain.entity.FlightError;
import org.conacry.caero.domain.entity.FlightID;
import org.conacry.caero.shared.exception.CodedException;
import org.junit.jupiter.api.Test;
import util.generator.StringGenerator;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class FlightIDTest {

    @Test
    void newID_ReturnFlightID() {
        var flightID = FlightID.newID();
        assertNotNull(flightID);
    }

    @Test
    void from_ValueStrIsNull_ThrowEx() {
        var ex = assertThrows(CodedException.class, () -> FlightID.from(null));
        assertEquals(FlightError.FLIGHT_ID_VALUE_IS_REQUIRED, ex.getCode());
        assertFalse(ex.getMessage().isEmpty());
    }

    @Test
    void from_ValueStrIsEmpty_ThrowEx() {
        var emptyValueStr = "";
        var ex = assertThrows(CodedException.class, () -> FlightID.from(emptyValueStr));
        assertEquals(FlightError.FLIGHT_ID_VALUE_IS_REQUIRED, ex.getCode());
        assertFalse(ex.getMessage().isEmpty());
    }

    @Test
    void from_IllegalFormatOfValueStr_ThrowEx() {
        var strWithIllegalFormat = StringGenerator.getRandomString();
        var ex = assertThrows(CodedException.class, () -> FlightID.from(strWithIllegalFormat));
        assertEquals(FlightError.ILLEGAL_FLIGHT_ID_VALUE, ex.getCode());
        assertFalse(ex.getMessage().isEmpty());
        assertNotNull(ex.getCause());
    }

    @Test
    void from_ValidValueStr_ReturnFlightID() {
        var validValueStr = UUID.randomUUID().toString();
        var flightID = FlightID.from(validValueStr);
        assertNotNull(flightID);
        assertEquals(validValueStr, flightID.getValue().toString());
    }
}
