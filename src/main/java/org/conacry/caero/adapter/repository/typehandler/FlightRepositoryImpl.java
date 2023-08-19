package org.conacry.caero.adapter.repository.typehandler;

import org.conacry.caero.adapter.repository.RepositoryError;
import org.conacry.caero.adapter.repository.mapper.FlightMapper;
import org.conacry.caero.boundary.repository.FlightRepository;
import org.conacry.caero.domain.entity.Flight;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository

public abstract class FlightRepositoryImpl implements FlightRepository {
    private FlightMapper flightMapper;

    public FlightRepositoryImpl(FlightMapper flightMapper) {
        this.flightMapper = flightMapper;
    }
    @Transactional
    @Override
    public void save(Flight flight) {
        if (flight == null) {
            throw RepositoryError.errFlightIsRequired():
        }

        var flightDbModel = Flight
    }
}
