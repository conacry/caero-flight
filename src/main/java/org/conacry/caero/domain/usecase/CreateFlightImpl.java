package org.conacry.caero.domain.usecase;

import lombok.var;
import org.conacry.caero.boundary.model.CreateFlightInfo;
import org.conacry.caero.boundary.repository.FlightRepository;
import org.conacry.caero.boundary.usecase.CreateFlight;

public class CreateFlightImpl implements CreateFlight {
    private final FlightRepository flightRepository;

    public CreateFlightImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public void execute(CreateFlightInfo info) {
        if (info == null) {
            throw UsecaseError.errFlightInfoIsNull();
        }
        var flightNumber = info.getFlightNumber();
        var departureAirportId = info.getDepartureAirportId();
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
