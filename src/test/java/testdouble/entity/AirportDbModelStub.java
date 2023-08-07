package testdouble.entity;

import org.conacry.caero.adapter.repository.model.AirportDbModel;

import java.util.ArrayList;
import java.util.List;

public class AirportDbModelStub {

    public static AirportDbModel getAirportDbModel() {
        var airport = AirportStub.getAirport();

        var airportID = airport.getAirportID().getValue();
        var airportCode = airport.getAirportCode().getValue();
        var airportName = airport.getAirportName().getValue();
        var city = airport.getCity().getValue();
        var latitude = String.valueOf(airport.getCoordinate().getLatitude());
        var longitude = String.valueOf(airport.getCoordinate().getLongitude());
        var timezone = airport.getTimezone();

        var airportDbModel = new AirportDbModel();
        airportDbModel.setAirportID(airportID);
        airportDbModel.setAirportCode(airportCode);
        airportDbModel.setAirportName(airportName);
        airportDbModel.setCity(city);
        airportDbModel.setLatitude(latitude);
        airportDbModel.setLongitude(longitude);
        airportDbModel.setTimezone(timezone);

        return airportDbModel;
    }

    public static List<AirportDbModel> getAirportDbModels(int count) {
        var airportDbModels = new ArrayList<AirportDbModel>();

        for (int i = 0; i < count; i++) {
            airportDbModels.add(getAirportDbModel());
        }

        return airportDbModels;
    }
}
