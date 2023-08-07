package org.conacry.caero.boundary.usecase;

import org.conacry.caero.boundary.model.CreateAirportInfo;
import org.conacry.caero.boundary.model.CreateFlightInfo;
import org.conacry.caero.domain.usecase.UsecaseError;

public interface CreateFlight {
    void execute(CreateFlightInfo info);

}
