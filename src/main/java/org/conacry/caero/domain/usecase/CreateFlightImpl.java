package org.conacry.caero.domain.usecase;

import org.conacry.caero.boundary.gateway.AircraftGateway;
import org.conacry.caero.boundary.model.CreateFlightInfo;
import org.conacry.caero.boundary.repository.AirportRepository;
import org.conacry.caero.boundary.repository.FlightRepository;
import org.conacry.caero.boundary.usecase.CreateFlight;
import org.conacry.caero.domain.entity.*;

import java.time.Instant;

public class CreateFlightImpl implements CreateFlight {

    private final FlightRepository flightRepository;
    private final AirportRepository airportRepository;
    private final AircraftGateway aircraftGateway;

    public CreateFlightImpl(
            FlightRepository flightRepository,
            AirportRepository airportRepository,
            AircraftGateway aircraftGateway
    ) {
        this.flightRepository = flightRepository;
        this.airportRepository = airportRepository;
        this.aircraftGateway = aircraftGateway;
    }

    @Override
    public FlightID execute(CreateFlightInfo info) {
        if (info == null) {
            throw UsecaseError.errFlightInfoIsNull();
        }

        var flightNumber = FlightNumber.of(info.getFlightNumber());
        var isFlightThere = flightRepository.exist(flightNumber);
        if(isFlightThere) {
            throw UsecaseError.errAirportAlreadyExist();
        }

        var departureAirportID = AirportID.from(info.getDepartureAirportID());
        var departureAirportOpt = airportRepository.findByID(departureAirportID);
        if (departureAirportOpt.isEmpty()) {
            throw UsecaseError.errDepartureAirportNotFound(departureAirportID);
        }

        var arrivalAirportID = AirportID.from(info.getArrivalAirportID());
        var arrivalAirportOpt = airportRepository.findByID(arrivalAirportID);
        if (arrivalAirportOpt.isEmpty()) {
            throw UsecaseError.errArrivalAirportNotFound(arrivalAirportID);
        }

        var aircraftID = AircraftID.from(info.getAircraftID());
        var aircraftOpt = aircraftGateway.getAircraftByID(aircraftID);
        if (aircraftOpt.isEmpty()) {
            throw UsecaseError.errAircraftOptNotFound(aircraftID);
        }

        var scheduledDeparture = Instant.ofEpochMilli(info.getScheduledDeparture());
        var scheduledArrival = Instant.ofEpochMilli(info.getScheduledArrival());

        var flight = new FlightBuilder().
                id(FlightID.newID()).
                number(flightNumber).
                departureAirport(departureAirportOpt.get()).
                arrivalAirport(arrivalAirportOpt.get()).
                aircraft(aircraftOpt.get()).
                scheduledDeparture(scheduledDeparture).
                scheduledArrival(scheduledArrival).
                status(FlightStatus.SCHEDULED).
                createdAt(Instant.now()).
                updatedAt(Instant.now()).
                build();

        flightRepository.save(flight);

        return flight.getId();
        // тесты для этого класса взять из class CreateAircraftUseCaseImplTest
    }
}
