package org.conacry.caero.boundary.usecase;

import org.conacry.caero.boundary.model.CreateFlightInfo;
import org.conacry.caero.domain.entity.FlightID;

public interface CreateFlight {
    FlightID execute(CreateFlightInfo info);

}
