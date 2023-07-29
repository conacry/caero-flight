package org.conacry.caero.domain.entity;

import org.conacry.caero.shared.exception.CodedException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CoordinateTest {

    @Test
    void of_latitudeValueIsIllegal_ThrowEx() {
        var illegalCoordinates = List.of(123.213, -123.123);
        for (double illegalCoordinate: illegalCoordinates) {
            var ex = assertThrows(CodedException.class, () -> Coordinate.of(illegalCoordinate, 120.000));
            assertEquals(AirportError.COORDINATE_LATITUDE_ILLEGAL_FORMAT, ex.getCode());
        }
    }

    @Test
    void of_longitudeValueIsIllegal_ThrowEx() {
        var illegalCoordinates = List.of(240.000, -240.123);
        for (double illegalCoordinate: illegalCoordinates) {
            var ex = assertThrows(CodedException.class, () -> Coordinate.of(80, illegalCoordinate));
            assertEquals(AirportError.COORDINATE_LONGITUDE_ILLEGAL_FORMAT, ex.getCode());
        }
    }

    @Test
    void of_AllParamsIsValid_ReturnCoordinate() {
        var latitudeValue = 80.789456;
        var longitudeValue = 160.456465;
        var coordinate = Coordinate.of(latitudeValue, longitudeValue);

        assertNotNull(coordinate);
        assertEquals(latitudeValue, coordinate.getLatitude());
        assertEquals(longitudeValue, coordinate.getLongitude());
    }


}
