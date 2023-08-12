package org.conacry.caero.adapter.controller.converter;

import org.conacry.caero.adapter.controller.AirportController;
import org.conacry.caero.adapter.controller.ControllerError;
import org.conacry.caero.adapter.controller.request.CreateAirportRequest;
import org.conacry.caero.shared.exception.CodedException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RequestConverterTest {

    @Test
    void createAirportRequestToInfo_RequestIsNull_ThrowEx() {
        var ex = assertThrows(CodedException.class, () -> RequestConverter.createAirportRequestToInfo(null));
        assertEquals(ControllerError.CREATE_AIRPORT_REQUEST_IS_NULL, ex.getCode());
    }

    @Test
    void createAirportRequestToInfo_CoordinateIsNull_ThrowEx() {
        var createAirportRequest = new CreateAirportRequest();
        createAirportRequest.setAirportCode("123");
        createAirportRequest.setAirportName("Dubai");
        createAirportRequest.setCity("Dubai");
        createAirportRequest.setCoordinate(null);
        createAirportRequest.setTimezone("UTC +6");
        var ex = assertThrows(CodedException.class, ()-> RequestConverter.createAirportRequestToInfo(createAirportRequest));
        assertEquals(ControllerError.CREATE_AIRPORT_REQUEST_COORDINATE_IS_NULL, ex.getCode());
    }

    @Test
    void createAirportRequestToInfo_NoExceptionsOccurred_ReturnCreateAirportInfo() {
        var createAirportRequest = new CreateAirportRequest();
        createAirportRequest.setAirportCode("123");
        createAirportRequest.setAirportName("Dubai");
        createAirportRequest.setCity("Dubai");
        createAirportRequest.setTimezone("UTC +6");

        var coordinateRequest = new CreateAirportRequest.CoordinateInfo();
        coordinateRequest.setLatitude(80.789456);
        coordinateRequest.setLongitude(160.456465);
        createAirportRequest.setCoordinate(coordinateRequest);

        var info = RequestConverter.createAirportRequestToInfo(createAirportRequest);
        assertNotNull(info);
        assertEquals(createAirportRequest.getAirportCode(), info.getAirportCode());
        assertEquals(createAirportRequest.getAirportName(), info.getAirportName());
        assertEquals(createAirportRequest.getCity(), info.getCity());
        assertEquals(createAirportRequest.getTimezone(), info.getTimezone());
        assertNotNull(createAirportRequest.getCoordinate());
        assertEquals(coordinateRequest.getLatitude(), info.getCoordinate().getLatitude());
        assertEquals(coordinateRequest.getLongitude(), info.getCoordinate().getLongitude());
    }
}