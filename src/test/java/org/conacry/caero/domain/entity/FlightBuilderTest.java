package org.conacry.caero.domain.entity;

import org.conacry.caero.shared.exception.CodedException;
import org.junit.jupiter.api.Test;
import testdouble.entity.AircraftStub;
import testdouble.entity.AirportStub;
import testdouble.entity.FlightNumberStub;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

public class FlightBuilderTest {

    @Test
    void build_FlightIDIsNull_ThrowEx() {
        var flightNumber = FlightNumberStub.getFlightNumber();
        var aircraft = AircraftStub.getAircraft();
        var scheduledDeparture = Instant.now();
        var scheduledArrival = Instant.now();
        var actualDeparture = Instant.now();
        var actualArrival = Instant.now();
        var flightStatus = FlightStatus.ARRIVED;
        var createdAt = Instant.now();
        var updatedAt = Instant.now();

        var builder = new FlightBuilder().
                id(null).
                number(flightNumber).
                aircraft(aircraft).
                scheduledDeparture(scheduledDeparture).
                scheduledArrival(scheduledArrival).
                actualDeparture(actualDeparture).
                actualArrival(actualArrival).
                status(flightStatus).
                createdAt(createdAt).
                updatedAt(updatedAt);

        var ex = assertThrows(CodedException.class, builder::build);
        assertEquals(FlightError.FLIGHT_ID_VALUE_IS_REQUIRED, ex.getCode());
    }

    @Test
    void build_FlightNumberIsNull_ThrowEx() {
        var flightID = FlightID.newID();
        //var arrivalAirport = AirportStub.getAirport();
        var aircraft = AircraftStub.getAircraft();
        var scheduledDeparture = Instant.now();
        var scheduledArrival = Instant.now();
        var actualDeparture = Instant.now();
        var actualArrival = Instant.now();
        var flightStatus = FlightStatus.ARRIVED;
        var createdAt = Instant.now();
        var updatedAt = Instant.now();

        var builder = new FlightBuilder().
                id(flightID).
                number(null).
                aircraft(aircraft).
                scheduledDeparture(scheduledDeparture).
                scheduledArrival(scheduledArrival).
                actualDeparture(actualDeparture).
                actualArrival(actualArrival).
                status(flightStatus).
                createdAt(createdAt).
                updatedAt(updatedAt);

        var ex = assertThrows(CodedException.class, builder::build);
        assertEquals(FlightError.FLIGHT_NUMBER_REQUIRED, ex.getCode());
    }

    @Test
    void build_AircraftIsNull_ThrowEx() {///***
        var flightID = FlightID.newID();
        var flightNumber = FlightNumberStub.getFlightNumber();
        var arrivalAirport = AirportStub.getAirport();
        var departureAirport = AirportStub.getAirport();
        var scheduledDeparture = Instant.now();
        var scheduledArrival = Instant.now();
        var actualDeparture = Instant.now();
        var actualArrival = Instant.now();
        var flightStatus = FlightStatus.ARRIVED;
        var createdAt = Instant.now();
        var updatedAt = Instant.now();

        var builder = new FlightBuilder().
                id(flightID).
                number(flightNumber).
                departureAirport(departureAirport).
                arrivalAirport(arrivalAirport).
                aircraft(null).
                scheduledDeparture(scheduledDeparture).
                scheduledArrival(scheduledArrival).
                actualDeparture(actualDeparture).
                actualArrival(actualArrival).
                status(flightStatus).
                createdAt(createdAt).
                updatedAt(updatedAt);

        var ex = assertThrows(CodedException.class, builder::build);
        assertEquals(FlightError.AIRCRAFT_IS_REQUIRED, ex.getCode());
    }

    @Test
    void build_ScheduledDepartureIsNull_ThrowEx() {///***
        var flightID = FlightID.newID();
        var flightNumber = FlightNumberStub.getFlightNumber();
        var arrivalAirport = AirportStub.getAirport();
        var departureAirport = AirportStub.getAirport();
        var aircraft = AircraftStub.getAircraft();
        var scheduledArrival = Instant.now();
        var actualDeparture = Instant.now();
        var actualArrival = Instant.now();
        var flightStatus = FlightStatus.ARRIVED;
        var createdAt = Instant.now();
        var updatedAt = Instant.now();

        var builder = new FlightBuilder().
                id(flightID).
                number(flightNumber).
                departureAirport(departureAirport).
                arrivalAirport(arrivalAirport).
                aircraft(aircraft).
                scheduledDeparture(null).
                scheduledArrival(scheduledArrival).
                actualDeparture(actualDeparture).
                actualArrival(actualArrival).
                status(flightStatus).
                createdAt(createdAt).
                updatedAt(updatedAt);

        var ex = assertThrows(CodedException.class, builder::build);
        assertEquals(FlightError.SCHEDULED_DEPARTURE_IS_REQUIRED, ex.getCode());
    }

    @Test
    void build_ScheduledArrivalIsNull_ThrowEx() {
        var flightID = FlightID.newID();
        var flightNumber = FlightNumberStub.getFlightNumber();
        var arrivalAirport = AirportStub.getAirport();
        var departureAirport = AirportStub.getAirport();
        var aircraft = AircraftStub.getAircraft();
        var scheduledDeparture = Instant.now();
        var actualDeparture = Instant.now();
        var actualArrival = Instant.now();
        var flightStatus = FlightStatus.ARRIVED;
        var createdAt = Instant.now();
        var updatedAt = Instant.now();

        var builder = new FlightBuilder().
                id(flightID).
                number(flightNumber).
                departureAirport(departureAirport).
                arrivalAirport(arrivalAirport).
                aircraft(aircraft).
                scheduledDeparture(scheduledDeparture).
                scheduledArrival(null).
                actualDeparture(actualDeparture).
                actualArrival(actualArrival).
                status(flightStatus).
                createdAt(createdAt).
                updatedAt(updatedAt);

        var ex = assertThrows(CodedException.class, builder::build);
        assertEquals(FlightError.SCHEDULED_ARRIVAL_IS_REQUIRED, ex.getCode());
    }

    @Test
    void build_FlightStatusIsNull_ThrowEx() {
        var flightID = FlightID.newID();
        var flightNumber = FlightNumberStub.getFlightNumber();
        var arrivalAirport = AirportStub.getAirport();
        var departureAirport = AirportStub.getAirport();
        var aircraft = AircraftStub.getAircraft();
        var scheduledDeparture = Instant.now();
        var scheduledArrival = Instant.now();
        var actualDeparture = Instant.now();
        var actualArrival = Instant.now();
        var createdAt = Instant.now();
        var updatedAt = Instant.now();

        var builder = new FlightBuilder().
                id(flightID).
                number(flightNumber).
                departureAirport(departureAirport).
                arrivalAirport(arrivalAirport).
                aircraft(aircraft).
                scheduledDeparture(scheduledDeparture).
                scheduledArrival(scheduledArrival).
                actualDeparture(actualDeparture).
                actualArrival(actualArrival).
                status(null).
                createdAt(createdAt).
                updatedAt(updatedAt);

        var ex = assertThrows(CodedException.class, builder::build);
        assertEquals(FlightError.STATUS_IS_REQUIRED, ex.getCode());
    }

    @Test
    void build_CreatedAtIsNull_ThrowEx() {
        var flightID = FlightID.newID();
        var flightNumber = FlightNumberStub.getFlightNumber();
        var arrivalAirport = AirportStub.getAirport();
        var departureAirport = AirportStub.getAirport();
        var aircraft = AircraftStub.getAircraft();
        var scheduledDeparture = Instant.now();
        var scheduledArrival = Instant.now();
        var actualDeparture = Instant.now();
        var actualArrival = Instant.now();
        var flightStatus = FlightStatus.ARRIVED;
        var updatedAt = Instant.now();

        var builder = new FlightBuilder().
                id(flightID).
                number(flightNumber).
                departureAirport(departureAirport).
                arrivalAirport(arrivalAirport).
                aircraft(aircraft).
                scheduledDeparture(scheduledDeparture).
                scheduledArrival(scheduledArrival).
                actualDeparture(actualDeparture).
                actualArrival(actualArrival).
                status(flightStatus).
                createdAt(null).
                updatedAt(updatedAt);

        var ex = assertThrows(CodedException.class, builder::build);
        assertEquals(FlightError.CREATED_AT_IS_REQUIRED, ex.getCode());
    }

    @Test
    void build_UpdatedAtIsNull_ThrowEx() {
        var flightID = FlightID.newID();
        var flightNumber = FlightNumberStub.getFlightNumber();
        var arrivalAirport = AirportStub.getAirport();
        var departureAirport = AirportStub.getAirport();
        var aircraft = AircraftStub.getAircraft();
        var scheduledDeparture = Instant.now();
        var scheduledArrival = Instant.now();
        var actualDeparture = Instant.now();
        var actualArrival = Instant.now();
        var flightStatus = FlightStatus.ARRIVED;
        var createdAt = Instant.now();

        var builder = new FlightBuilder().
                id(flightID).
                number(flightNumber).
                departureAirport(departureAirport).
                arrivalAirport(arrivalAirport).
                aircraft(aircraft).
                scheduledDeparture(scheduledDeparture).
                scheduledArrival(scheduledArrival).
                actualDeparture(actualDeparture).
                actualArrival(actualArrival).
                status(flightStatus).
                createdAt(createdAt).
                updatedAt(null);

        var ex = assertThrows(CodedException.class, builder::build);
        assertEquals(FlightError.UPDATED_AT_IS_REQUIRED, ex.getCode());
    }

    @Test
    void build_DepartureAirportIsNull_ThrowEx() {//////////////////////////
        var flightID = FlightID.newID();
        var flightNumber = FlightNumberStub.getFlightNumber();
        var arrivalAirport = AirportStub.getAirport();
        var aircraft = AircraftStub.getAircraft();
        var scheduledDeparture = Instant.now();
        var scheduledArrival = Instant.now();
        var actualDeparture = Instant.now();
        var actualArrival = Instant.now();
        var flightStatus = FlightStatus.ARRIVED;
        var createdAt = Instant.now();
        var updatedAt = Instant.now();

        var builder = new FlightBuilder().
                id(flightID).
                number(flightNumber).
                departureAirport(null).
                arrivalAirport(arrivalAirport).
                aircraft(aircraft).
                scheduledDeparture(scheduledDeparture).
                scheduledArrival(scheduledArrival).
                actualDeparture(actualDeparture).
                actualArrival(actualArrival).
                status(flightStatus).
                createdAt(createdAt).
                updatedAt(updatedAt);

        var ex = assertThrows(CodedException.class, builder::build);
        assertEquals(FlightError.DEPARTURE_AIRPORT_IS_REQUIRED, ex.getCode());
    }

    @Test
    void build_ArrivalAirportIsNull_ThrowEx() {//////////////////////////
        var flightID = FlightID.newID();
        var flightNumber = FlightNumberStub.getFlightNumber();
        var departureAirport = AirportStub.getAirport();
        var aircraft = AircraftStub.getAircraft();
        var scheduledDeparture = Instant.now();
        var scheduledArrival = Instant.now();
        var actualDeparture = Instant.now();
        var actualArrival = Instant.now();
        var flightStatus = FlightStatus.ARRIVED;
        var createdAt = Instant.now();
        var updatedAt = Instant.now();

        var builder = new FlightBuilder().
                id(flightID).
                number(flightNumber).
                departureAirport(departureAirport).
                arrivalAirport(null).
                aircraft(aircraft).
                scheduledDeparture(scheduledDeparture).
                scheduledArrival(scheduledArrival).
                actualDeparture(actualDeparture).
                actualArrival(actualArrival).
                status(flightStatus).
                createdAt(createdAt).
                updatedAt(updatedAt);

        var ex = assertThrows(CodedException.class, builder::build);
        assertEquals(FlightError.ARRIVAL_AIRPORT_IS_REQUIRED, ex.getCode());
    }

    @Test
    void build_ActualTimeIsEmpty_ReturnFlightWithoutActualTime() {
        var flightID = FlightID.newID();
        var flightNumber = FlightNumberStub.getFlightNumber();
        var arrivalAirport = AirportStub.getAirport();
        var departureAirport = AirportStub.getAirport();
        var aircraft = AircraftStub.getAircraft();
        var scheduledDeparture = Instant.now();
        var scheduledArrival = Instant.now();
        var flightStatus = FlightStatus.ARRIVED;
        var createdAt = Instant.now();
        var updatedAt = Instant.now();

        var flight = new FlightBuilder().
                id(flightID).
                number(flightNumber).
                departureAirport(departureAirport).
                arrivalAirport(arrivalAirport).
                aircraft(aircraft).
                scheduledDeparture(scheduledDeparture).
                scheduledArrival(scheduledArrival).
                actualDeparture(null).
                actualArrival(null).
                status(flightStatus).
                createdAt(createdAt).
                updatedAt(updatedAt).
                build();

        assertNotNull(flight);
        assertEquals(flightID, flight.getId());
        assertEquals(flightNumber, flight.getNumber());
        assertEquals(aircraft, flight.getAircraft());
        assertEquals(scheduledDeparture, flight.getScheduledDeparture());
        assertEquals(scheduledArrival, flight.getScheduledArrival());
        assertNull(flight.getActualDeparture());
        assertNull(flight.getActualDeparture());
        assertEquals(flightStatus, flight.getStatus());
        assertEquals(createdAt, flight.getCreatedAt());
        assertEquals(updatedAt, flight.getUpdatedAt());
    }

    @Test
    void build_AllParamsIsValid_ReturnFlightWithActualTime() {
        var flightID = FlightID.newID();
        var flightNumber = FlightNumberStub.getFlightNumber();
        var arrivalAirport = AirportStub.getAirport();
        var departureAirport = AirportStub.getAirport();
        var aircraft = AircraftStub.getAircraft();
        var scheduledDeparture = Instant.now();
        var scheduledArrival = Instant.now();
        var actualDeparture = Instant.now();
        var actualArrival = Instant.now();
        var flightStatus = FlightStatus.ARRIVED;
        var createdAt = Instant.now();
        var updatedAt = Instant.now();

        var flight = new FlightBuilder().
                id(flightID).
                number(flightNumber).
                departureAirport(departureAirport).
                arrivalAirport(arrivalAirport).
                aircraft(aircraft).
                scheduledDeparture(scheduledDeparture).
                scheduledArrival(scheduledArrival).
                actualDeparture(actualDeparture).
                actualArrival(actualArrival).
                status(flightStatus).
                createdAt(createdAt).
                updatedAt(updatedAt).
                build();

        assertNotNull(flight);
        assertEquals(flightID, flight.getId());
        assertEquals(flightNumber, flight.getNumber());
        assertEquals(aircraft, flight.getAircraft());
        assertEquals(scheduledDeparture, flight.getScheduledDeparture());
        assertEquals(scheduledArrival, flight.getScheduledArrival());
        assertEquals(actualDeparture, flight.getActualDeparture());
        assertEquals(actualArrival, flight.getActualArrival());
        assertEquals(flightStatus, flight.getStatus());
        assertEquals(createdAt, flight.getCreatedAt());
        assertEquals(updatedAt, flight.getUpdatedAt());
    }
}
