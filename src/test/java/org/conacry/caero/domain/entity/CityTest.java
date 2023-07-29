package org.conacry.caero.domain.entity;

import org.conacry.caero.shared.exception.CodedException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CityTest {

    @Test
    void of_CityStrIsNull_ThrowEx() {
        var ex = assertThrows(CodedException.class, () -> City.of(null));
        assertEquals(AirportError.AIRPORT_CITY_REQUIRED, ex.getCode());
    }

    @Test
    void of_CityStrIsBlank_ThrowEx() {
        var blankValue = " ";
        var ex = assertThrows(CodedException.class, () -> City.of(blankValue));
        assertEquals(AirportError.AIRPORT_CITY_REQUIRED, ex.getCode());
    }

    @Test
    void of_CityStrIsValid_ReturnCity() {
        var cityStr = "Almaty";
        var city = City.of(cityStr);

        assertNotNull(city);
        assertEquals(cityStr, city.getValue());
    }
}
