package testdouble.entity;

import org.conacry.caero.adapter.repository.model.FlightDbModel;
import org.conacry.caero.domain.entity.FlightID;
import org.conacry.caero.domain.entity.FlightStatus;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class FlightDbModelStub {
    public static FlightDbModel getFlightDbModel() {
        var flightDbModel = new FlightDbModel();
        flightDbModel.setFlightID(FlightID.newID().getValue());
        flightDbModel.setNumber(123);
        flightDbModel.setDepartureAirport(AirportDbModelStub.getAirportDbModel());
        flightDbModel.setArrivalAirport(AirportDbModelStub.getAirportDbModel());
        flightDbModel.setAircraft(AircraftDbModelStub.getAircraftDbModel());
        flightDbModel.setScheduledDeparture(Instant.now().toEpochMilli());
        flightDbModel.setScheduledArrival(Instant.now().toEpochMilli());
        flightDbModel.setActualDeparture(Instant.now().toEpochMilli());
        flightDbModel.setActualArrival(Instant.now().toEpochMilli());
        flightDbModel.setStatus(FlightStatus.ON_TIME.toString());
        flightDbModel.setCreatedAt(Instant.now().getNano());
        flightDbModel.setUpdatedAt(Instant.now().getNano());

        return flightDbModel;
    }

    public static List<FlightDbModel> getFlightDbModels(int count) {
        var flightDbModels = new ArrayList<FlightDbModel>();

        for (int i = 0; i < count; i++) {
            flightDbModels.add(getFlightDbModel());
        }

        return flightDbModels;
    }
}
