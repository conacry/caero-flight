package testdouble.entity;

import org.conacry.caero.domain.entity.*;
import util.generator.StringGenerator;

import java.time.Instant;

public class AirportStub {

    public static Airport getAirport() {
        var airportID = AirportID.newID();
        var airportCode = AirportCode.of("ABC");
        var airportName = AirportName.from("Almaty Airport");
        var city = City.of("Almaty");
        var coordinate = Coordinate.of(80.123456, 160.123456);
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
}
