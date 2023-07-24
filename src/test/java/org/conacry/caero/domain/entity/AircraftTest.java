package org.conacry.caero.domain.entity;

import org.conacry.caero.shared.exception.CodedException;
import org.junit.jupiter.api.Test;
import testdouble.entity.AircraftStub;
import testdouble.entity.ModelStub;

import static org.junit.jupiter.api.Assertions.*;

class AircraftTest {

    @Test
    void of_AircraftIsNull_ThrowEx() {
        var model = ModelStub.getModel();
        var ex = assertThrows(CodedException.class, () -> Aircraft.of(null, model));
        assertEquals(AircraftError.AIRCRAFT_ID_VALUE_IS_REQUIRED, ex.getCode());
    }

    @Test
    void of_ModelIsNull_ThrowEx() {
        var aircraftID = AircraftStub.getAircraftID();
        var ex = assertThrows(CodedException.class, () -> Aircraft.of(aircraftID, null));
        assertEquals(AircraftError.AIRCRAFT_MODEL_IS_REQUIRED, ex.getCode());
    }

    @Test
    void of_AllParamsAreValid_ReturnAircraft() {
        var aircraftID = AircraftStub.getAircraftID();
        var model = ModelStub.getModel();
        var aircraft = Aircraft.of(aircraftID, model);
        assertNotNull(aircraft);
        assertEquals(aircraftID, aircraft.getAircraftID());
        assertEquals(model.getValue(), aircraft.getModel().getValue());
    }
}