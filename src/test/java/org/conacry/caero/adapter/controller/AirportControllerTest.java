package org.conacry.caero.adapter.controller;

import org.conacry.caero.adapter.controller.request.CreateAirportRequest;
import org.conacry.caero.boundary.model.CreateAirportInfo;
import org.conacry.caero.boundary.usecase.CreateAirport;
import org.conacry.caero.shared.exception.CodedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;

@ExtendWith(MockitoExtension.class)
class AirportControllerTest {

    @Mock
    private CreateAirport createAirportUseCase;

    private AirportController airportController;

    @BeforeEach
    void setUp() {
        this.airportController = new AirportController(createAirportUseCase);
    }

    @Test
    void createAirport_requestIsNull_ThrowEx() {
        var ex = assertThrows(CodedException.class, () -> airportController.createAirport(null));
        assertEquals(ControllerError.CREATE_AIRPORT_REQUEST_IS_NULL, ex.getCode());
    }

    @Test
    void createAirport_UseCaseError_ThrowEx() {
        doThrow(RuntimeException.class).when(createAirportUseCase).execute(any(CreateAirportInfo.class));

        var createAirportRequest = new CreateAirportRequest();
        createAirportRequest.setAirportCode("123");
        createAirportRequest.setAirportName("Dubai");
        createAirportRequest.setCity("Dubai");
        createAirportRequest.setTimezone("UTC +6");

        var coordinateRequest = new CreateAirportRequest.CoordinateInfo();
        coordinateRequest.setLatitude(80.789456);
        coordinateRequest.setLongitude(160.456465);
        createAirportRequest.setCoordinate(coordinateRequest);

        assertThrows(RuntimeException.class, () -> airportController.createAirport(createAirportRequest));
    }

    @Test
    void createAirport_NoExIsOccurred_ReturnCreated() {
        var createAirportRequest = new CreateAirportRequest();
        createAirportRequest.setAirportCode("123");
        createAirportRequest.setAirportName("Dubai");
        createAirportRequest.setCity("Dubai");
        createAirportRequest.setTimezone("UTC +6");

        var coordinateRequest = new CreateAirportRequest.CoordinateInfo();
        coordinateRequest.setLatitude(80.789456);
        coordinateRequest.setLongitude(160.456465);
        createAirportRequest.setCoordinate(coordinateRequest);

        var response = airportController.createAirport(createAirportRequest);
        assertNotNull(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNull(response.getBody());
    }
}