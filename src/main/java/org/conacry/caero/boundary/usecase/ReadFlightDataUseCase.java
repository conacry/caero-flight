package org.conacry.caero.boundary.usecase;

import org.conacry.caero.domain.entity.Flight;

import java.util.List;

public interface ReadFlightDataUseCase {
    Flight findByID(String flightIDStr);

    List<Flight> findAll();
}
