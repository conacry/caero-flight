package org.conacry.caero.boundary.repository;

import org.conacry.caero.domain.entity.Airport;
import org.conacry.caero.domain.entity.AirportID;

import java.util.Optional;

public interface AirportRepository {

    void save(Airport airport);
    Optional<Airport> findByID(AirportID airportID);
}
