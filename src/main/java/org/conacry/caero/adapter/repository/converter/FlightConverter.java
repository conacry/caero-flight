package org.conacry.caero.adapter.repository.converter;

import org.conacry.caero.adapter.repository.RepositoryError;
import org.conacry.caero.adapter.repository.model.FlightDbModel;
import org.conacry.caero.domain.entity.Flight;

public class FlightConverter {

    public static FlightDbModel toModel(Flight flight) {
        if (flight == null) {
            throw RepositoryError.errFlightIsRequired();
        }
        var flightID = flight.getId().getValue();
        var number = flight.getNumber();
        var departureAirport = flight.getDepartureAirport();
        var arrivalAirport = flight.getArrivalAirport();
        var aircraft = flight.getAircraft();
        var scheduledDeparture = flight.getScheduledDeparture();
        var scheduledArrival = flight.getScheduledArrival();
        var actualDeparture = flight.getActualDeparture();
        var actualArrival = flight.getActualArrival();
        var status = flight.getStatus();
        var createdAt = flight.getCreatedAt();
        var updatedAt = flight.getUpdatedAt();

        var flightDbModel = new FlightDbModel();
        flightDbModel.setFlightID(flightID);
        flightDbModel.;
    }
}
