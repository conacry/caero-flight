package org.conacry.caero.domain.usecase;

import org.conacry.caero.boundary.model.CreateAirportInfo;
import org.conacry.caero.boundary.repository.AirportRepository;
import org.conacry.caero.boundary.usecase.CreateAirport;
import org.conacry.caero.domain.entity.*;

public class CreateAirportImpl implements CreateAirport {

    private final AirportRepository airportRepository;

    public CreateAirportImpl(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    @Override
    public void execute(CreateAirportInfo info) {
        if (info == null) {
            throw new RuntimeException();
        }

        var airportID = AirportID.newID();
        var airportCode = AirportCode.of(info.getAirportCode());
        var airportName = AirportName.from(info.getAirportName());
        var city = City.of(info.getCity());
        var coordinate = Coordinate.of(info.getCoordinate().getLatitude(), info.getCoordinate().getLongitude());
        var timezone = info.getTimezone();

        var isThere = airportRepository.exist(airportCode);
        if(isThere) {
            throw UsecaseError.errAirportAlreadyExist();
        }

        var airport = new AirportBuilder().
                airportID(airportID).
                airportCode(airportCode).
                airportName(airportName).
                city(city).
                coordinates(coordinate).
                timezone(timezone).
                build();

        airportRepository.save(airport);
    }
}
