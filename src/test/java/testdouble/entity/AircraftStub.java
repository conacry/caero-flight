package testdouble.entity;

import org.conacry.caero.domain.entity.Aircraft;
import org.conacry.caero.domain.entity.AircraftID;
import org.conacry.caero.domain.entity.Model;
import util.generator.StringGenerator;

import java.util.UUID;

public class AircraftStub {

    public static AircraftID getAircraftID() {
        return AircraftID.from(UUID.randomUUID().toString());
    }

    public static Aircraft getAircraft() {
        var aircraftID = getAircraftID();
        var model = ModelStub.getModel();
        return Aircraft.of(aircraftID, model);
    }
}
