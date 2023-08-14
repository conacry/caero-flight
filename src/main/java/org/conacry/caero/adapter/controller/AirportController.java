package org.conacry.caero.adapter.controller;

import org.conacry.caero.adapter.controller.converter.RequestConverter;
import org.conacry.caero.adapter.controller.request.CreateAirportRequest;
import org.conacry.caero.boundary.usecase.CreateAirport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1")
public class AirportController {

    private final CreateAirport createAirportUseCase;

    public AirportController(CreateAirport createAirportUseCase) {
        this.createAirportUseCase = createAirportUseCase;
    }

    @PostMapping(path = "/create-airport")
    public ResponseEntity<Void> createAirport(@RequestBody CreateAirportRequest request) {
        var info = RequestConverter.createAirportRequestToInfo(request);
        createAirportUseCase.execute(info);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }
}
