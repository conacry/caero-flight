package testdouble.entity;

import org.conacry.caero.domain.entity.*;
import util.generator.StringGenerator;

import java.util.ArrayList;
import java.util.List;

public class AirportStub {

    public static Airport getAirport() {
        var airportID = AirportID.newID();
        var airportCode = AirportCode.of("ALA");
        var airportName = AirportName.from(StringGenerator.getRandomString());
        var city = City.of(StringGenerator.getRandomString());
        var latitudeValue = 80.789456;
        var longitudeValue = 160.456465;
        var coordinate = Coordinate.of(latitudeValue, longitudeValue);
        var timezone = "UTC +6";

        return new AirportBuilder().
                airportID(airportID).
                airportCode(airportCode).
                airportName(airportName).
                city(city).
                coordinates(coordinate).
                timezone(timezone).
                build();
    }

    public static List<Airport> getAirports(int count) {
        var airports = new ArrayList<Airport>();

        for (int i = 0; i < count; i++) {
            airports.add(getAirport());
        }

        return airports;
    }
}
