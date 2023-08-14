package org.conacry.caero.integration.adapter.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.conacry.caero.adapter.controller.request.CreateAirportRequest;
import org.conacry.caero.boundary.model.CreateAirportInfo;
import org.conacry.caero.boundary.usecase.CreateAirport;
import org.conacry.caero.shared.exception.CodedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import util.annotation.IntegrationTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@IntegrationTest
class AirportControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private CreateAirport createAirport;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders.
                webAppContextSetup(webApplicationContext).
                build();
    }

    @Test
    void createAirport_UseCaseThrowRuntimeEx_ResponseWithHttp500() throws Exception {
        doThrow(RuntimeException.class).when(createAirport).execute(any(CreateAirportInfo.class));

        var createAirportRequest = new CreateAirportRequest();
        createAirportRequest.setAirportCode("123");
        createAirportRequest.setAirportName("Dubai");
        createAirportRequest.setCity("Dubai");
        createAirportRequest.setTimezone("UTC +6");

        var coordinateRequest = new CreateAirportRequest.CoordinateInfo();
        coordinateRequest.setLatitude(80.789456);
        coordinateRequest.setLongitude(160.456465);
        createAirportRequest.setCoordinate(coordinateRequest);

        var objectMapper = new ObjectMapper();
        mockMvc.perform(post("/api/v1/create-airport")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createAirportRequest)))
                .andExpect(status().isInternalServerError());
    }

    @Test
    void createAirport_UseCaseThrowCodedEx_ResponseWithHttp422() throws Exception {
        doThrow(CodedException.class).when(createAirport).execute(any(CreateAirportInfo.class));

        var createAirportRequest = new CreateAirportRequest();
        createAirportRequest.setAirportCode("123");
        createAirportRequest.setAirportName("Dubai");
        createAirportRequest.setCity("Dubai");
        createAirportRequest.setTimezone("UTC +6");

        var coordinateRequest = new CreateAirportRequest.CoordinateInfo();
        coordinateRequest.setLatitude(80.789456);
        coordinateRequest.setLongitude(160.456465);
        createAirportRequest.setCoordinate(coordinateRequest);

        var objectMapper = new ObjectMapper();
        mockMvc.perform(post("/api/v1/create-airport")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createAirportRequest)))
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    void createAirport_CreateAirportRequestIsNull_ResponseWithHttp401() throws Exception {
        mockMvc.perform(post("/api/v1/create-airport")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void createAirport_CreateAirportRequest_ResponseWithHttp201() throws Exception {
        var createAirportRequest = new CreateAirportRequest();
        createAirportRequest.setAirportCode("123");
        createAirportRequest.setAirportName("Dubai");
        createAirportRequest.setCity("Dubai");
        createAirportRequest.setTimezone("UTC +6");

        var coordinateRequest = new CreateAirportRequest.CoordinateInfo();
        coordinateRequest.setLatitude(80.789456);
        coordinateRequest.setLongitude(160.456465);
        createAirportRequest.setCoordinate(coordinateRequest);

        var objectMapper = new ObjectMapper();
        mockMvc.perform(post("/api/v1/create-airport")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createAirportRequest)))
                .andExpect(status().isCreated());
    }
}
