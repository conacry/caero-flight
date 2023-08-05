package org.conacry.caero.domain.entity.usecase;

import org.conacry.caero.boundary.repository.FlightRepository;
import org.conacry.caero.domain.entity.Flight;
import org.conacry.caero.domain.entity.FlightID;

import java.util.List;

public class ReadFlightDataUseCase {

    public final FlightRepository flightRepository;


    public ReadFlightDataUseCase(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public Flight findByID(String flightIDStr) {
        var flightID = FlightID.from(flightIDStr);
        var flightOpt = flightRepository.findByID(flightID);

        return flightOpt.
                orElseThrow(()-> UseCaseError.errFlightNotFound(flightID));
    }
    public List<Flight> findAll() {
        return flightRepository.findAll();
    }
}