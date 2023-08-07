package org.conacry.caero.domain.entity;

import java.util.Objects;
import java.util.UUID;

public final class FlightID {

    private final UUID value;

    public static FlightID newID() {
        var value = UUID.randomUUID();
        return new FlightID(value);
    }

    public static FlightID from(String valueStr) {
        if (valueStr == null || valueStr.isBlank()) {
            throw FlightError.errFlightIDValueIsRequired();
        }

        try {
            var value = UUID.fromString(valueStr);
            return new FlightID(value);
        } catch (IllegalArgumentException e) {
            throw FlightError.errIllegalFlightIDValue(valueStr, e);
        }
    }

    private FlightID(UUID value) {
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
        var flightID = (FlightID) o;
        return Objects.equals(value, flightID.value);
    }
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return this.value.toString();
    }
}