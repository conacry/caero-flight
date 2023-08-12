package org.conacry.caero.boundary.gateway;

import org.conacry.caero.domain.entity.Aircraft;
import org.conacry.caero.domain.entity.AircraftID;

import java.util.Optional;

public interface AircraftGateway {
    Optional<Aircraft> getAircraftByID(AircraftID aircraftID);
}
