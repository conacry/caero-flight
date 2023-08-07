package org.conacry.caero.domain.usecase;

import org.conacry.caero.boundary.model.CreateFlightInfo;
import org.conacry.caero.boundary.repository.AirportRepository;
import org.conacry.caero.boundary.repository.FlightRepository;
import org.conacry.caero.boundary.usecase.CreateFlight;
import org.conacry.caero.domain.entity.AirportID;
import org.conacry.caero.domain.entity.FlightNumber;

public class CreateFlightImpl implements CreateFlight {
    private final FlightRepository flightRepository;
    private final AirportRepository airportRepository;

    public CreateFlightImpl(FlightRepository flightRepository, AirportRepository airportRepository) {
        this.flightRepository = flightRepository;
        this.airportRepository = airportRepository;
    }

    @Override
    public void execute(CreateFlightInfo info) {
        if (info == null) {
            throw UsecaseError.errFlightInfoIsNull();
        }

        var flightNumber = FlightNumber.of(info.getFlightNumber());

        var departureAirportId = AirportID.from(info.getDepartureAirportId());
        var depAirport = airportRepository.findByID(departureAirportId);

        var arrivalAirportId = info.getArrivalAirportId();
        var aircraftId = info.getAircraftId();
        var scheduledDeparture = info.getScheduledDeparture();
        var scheduledArrival = info.getScheduledArrival();

        var isFlightThere = flightRepository.exist(flightNumber);
        if(isFlightThere) {
            throw UsecaseError.errAirportAlreadyExist();
        }
        // из аирпорт репо по айди вытащить аирпорт прибытия и вылета
        // интерфейс аиркрафт гетевей для того чтобы из другого сервиса получить данные по аиркрфат

    }
}
