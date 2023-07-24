package org.conacry.caero.domain.entity;

import java.util.Objects;
import java.util.UUID;

public class AirportID {

    private final UUID value;

    public static AirportID newID() {
        var value = UUID.randomUUID();
        return new AirportID(value);
    }

    public static AirportID from(String valueStr) {
        if (valueStr == null || valueStr.isBlank()) {
            throw AirportError.errAirportIDValueIsRequired();
        }

        try {
            var value = UUID.fromString(valueStr);
            return new AirportID(value);
        } catch (IllegalArgumentException e) {
            throw AirportError.errIllegalAirportIDValue(valueStr, e);
        }
    }

    private AirportID(UUID value) {
        this.value = value;
    }

    public UUID getValue() {
        return value;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        var airportID = (AirportID) o;
        return Objects.equals(value, airportID.value);
    }
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "AirportID{" +
                "value=" + value +
                '}';
    }

}
