package org.conacry.caero.boundary.repository;

import org.conacry.caero.domain.entity.Flight;
import org.conacry.caero.domain.entity.FlightID;

import java.util.List;
import java.util.Optional;

public interface FlightRepository {

    void save(Flight flight);
    Optional<Flight> findByID(FlightID flightID);

    List<Flight> findAll();
}
