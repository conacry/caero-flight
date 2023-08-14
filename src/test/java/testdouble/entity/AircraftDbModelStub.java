package testdouble.entity;

import org.conacry.caero.adapter.repository.model.AircraftDbModel;
import util.generator.StringGenerator;

import java.util.UUID;

public class AircraftDbModelStub {
    public static AircraftDbModel getAircraftDbModel() {
        var aircraftDbModel = new AircraftDbModel();
        aircraftDbModel.setAircraftID(UUID.randomUUID().toString());
        aircraftDbModel.setModel(StringGenerator.getRandomString());
        return aircraftDbModel;
    }
}
