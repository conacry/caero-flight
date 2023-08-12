package testdouble.entity;

import org.conacry.caero.domain.entity.AirportCode;
import util.generator.StringGenerator;

public final class AirportCodeStub {

    public static AirportCode getAirportCode() {
        var airportCodeStr = StringGenerator.getRandomString(3).toUpperCase();
        return AirportCode.of(airportCodeStr);
    }
}
