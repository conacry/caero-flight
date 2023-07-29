package org.conacry.caero.domain.entity;

import org.conacry.caero.shared.exception.CodedException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AirportBuilderTest {

    @Test
    void build_AirportIDIsNull_ThrowEx() {
        var airportCode = AirportCode.of("ABC");
        var airportName = AirportName.from("Almaty Airport");
        var city = City.of("Almaty");
        var coordinate = Coordinate.of(80.123456, 160.123456);
        var timezone = "UTC +6";

        var builder = new AirportBuilder();

        var ex = assertThrows(CodedException.class,
                () -> builder.
                        airportID(null).
                        airportCode(airportCode).
                        airportName(airportName).
                        city(city).
                        coordinates(coordinate).
                        timezone(timezone).
                        build()
        );
        assertEquals(AirportError.AIRPORT_ID_BUILDER_REQUIRED, ex.getCode());
    }

    @Test
    void build_AirportCodeIsNull_ThrowEx() {
        var airportID = AirportID.newID();
        var airportName = AirportName.from("Almaty Airport");
        var city = City.of("Almaty");
        var coordinate = Coordinate.of(80.123456, 160.123456);
        var timezone = "UTC +6";

        var builder = new AirportBuilder();

        var ex = assertThrows(CodedException.class,
                () -> builder.
                        airportID(airportID).
                        airportCode(null).
                        airportName(airportName).
                        city(city).
                        coordinates(coordinate).
                        timezone(timezone).
                        build()
        );
        assertEquals(AirportError.AIRPORT_CODE_BUILDER_REQUIRED, ex.getCode());
    }

    @Test
    void build_AirportNameIsNull_ThrowEx() {
        var airportID = AirportID.newID();
        var airportCode = AirportCode.of("ABC");
        var city = City.of("Almaty");
        var coordinate = Coordinate.of(80.123456, 160.123456);
        var timezone = "UTC +6";

        var builder = new AirportBuilder();

        var ex = assertThrows(CodedException.class,
                () -> builder.
                        airportID(airportID).
                        airportCode(airportCode).
                        airportName(null).
                        city(city).
                        coordinates(coordinate).
                        timezone(timezone).
                        build()
        );
        assertEquals(AirportError.AIRPORT_NAME_BUILDER_REQUIRED, ex.getCode());
    }

    @Test
    void build_CityIsNull_ThrowEx() {
        var airportID = AirportID.newID();
        var airportCode = AirportCode.of("ABC");
        var airportName = AirportName.from("Almaty Airport");
        var coordinate = Coordinate.of(80.123456, 160.123456);
        var timezone = "UTC +6";

        var builder = new AirportBuilder();

        var ex = assertThrows(CodedException.class,
                () -> builder.
                        airportID(airportID).
                        airportCode(airportCode).
                        airportName(airportName).
                        city(null).
                        coordinates(coordinate).
                        timezone(timezone).
                        build()
        );
        assertEquals(AirportError.AIRPORT_CITY_BUILDER_REQUIRED, ex.getCode());
    }

    @Test
    void build_CoordinateIsNull_ThrowEx() {
        var airportID = AirportID.newID();
        var airportCode = AirportCode.of("ABC");
        var airportName = AirportName.from("Almaty Airport");
        var city = City.of("Almaty");
        var timezone = "UTC +6";

        var builder = new AirportBuilder();

        var ex = assertThrows(CodedException.class,
                () -> builder.
                        airportID(airportID).
                        airportCode(airportCode).
                        airportName(airportName).
                        city(city).
                        coordinates(null).
                        timezone(timezone).
                        build()
        );
        assertEquals(AirportError.AIRPORT_COORDINATE_BUILDER_REQUIRED, ex.getCode());
    }

    @Test
    void build_TimezoneIsNull_ThrowEx() {
        var airportID = AirportID.newID();
        var airportCode = AirportCode.of("ABC");
        var airportName = AirportName.from("Almaty Airport");
        var city = City.of("Almaty");
        var coordinate = Coordinate.of(80.123456, 160.123456);

        var builder = new AirportBuilder();

        var ex = assertThrows(CodedException.class,
                () -> builder.
                        airportID(airportID).
                        airportCode(airportCode).
                        airportName(airportName).
                        city(city).
                        coordinates(coordinate).
                        timezone(null).
                        build()
        );
        assertEquals(AirportError.AIRPORT_TIMEZONE_BUILDER_REQUIRED, ex.getCode());
    }

    @Test
    void build_AllParamsIsValid_ReturnAirport() {
        var airportID = AirportID.newID();
        var airportCode = AirportCode.of("ABC");
        var airportName = AirportName.from("Almaty Airport");
        var city = City.of("Almaty");
        var coordinate = Coordinate.of(80.123456, 160.123456);
        var timezone = "UTC +6";

        var airport = new AirportBuilder().
                airportID(airportID).
                airportCode(airportCode).
                airportName(airportName).
                city(city).
                coordinates(coordinate).
                timezone(timezone).
                build();

        assertNotNull(airport);
        assertEquals(airportID, airport.getAirportID());
        assertEquals(airportCode, airport.getAirportCode());
        assertEquals(airportName, airport.getAirportName());
        assertEquals(city, airport.getCity());
        assertEquals(coordinate, airport.getCoordinate());
        assertEquals(timezone, airport.getTimezone());
    }

}
