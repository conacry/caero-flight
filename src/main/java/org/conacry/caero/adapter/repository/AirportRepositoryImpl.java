package org.conacry.caero.adapter.repository;

import org.conacry.caero.adapter.repository.converter.AirportConverter;
import org.conacry.caero.adapter.repository.mapper.AirportMapper;
import org.conacry.caero.boundary.repository.AirportRepository;
import org.conacry.caero.domain.entity.Airport;
import org.conacry.caero.domain.entity.AirportID;

import java.util.Optional;


public class AirportRepositoryImpl implements AirportRepository {

    private final AirportMapper airportMapper;

    public AirportRepositoryImpl(AirportMapper airportMapper) {
        this.airportMapper = airportMapper;
    }

    @Override
    public void save(Airport airport) {
        if (airport == null) {
            throw RepositoryError.errAirportIsRequired();
        }

        var airportDbModel = AirportConverter.toModel(airport);

        airportMapper.insert(airportDbModel);
    }

    @Override
    public Optional<Airport> findByID(AirportID airportID) {
        if (airportID == null) {
            throw RepositoryError.errAirportIDIsRequired();
        }
        var airportDbModel = airportMapper.selectByID(airportID.getValue());

        return airportDbModel == null ?
                Optional.empty() :
                Optional.of(AirportConverter.toEntity(airportDbModel));
    }
}
