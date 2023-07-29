package org.conacry.caero.domain.entity;

public class AirportBuilder {
    private AirportID airportID;
    private AirportCode airportCode;
    private AirportName airportName;
    private City city;
    private Coordinate coordinate;
    private String timezone;

    public AirportBuilder airportID(AirportID airportID) {
        this.airportID = airportID;
        return this;
    }

    public AirportBuilder airportCode(AirportCode airportCode) {
        this.airportCode = airportCode;
        return this;
    }

    public AirportBuilder airportName(AirportName airportName) {
        this.airportName = airportName;
        return this;
    }

    public AirportBuilder city(City city) {
        this.city = city;
        return this;
    }

    public AirportBuilder coordinates(Coordinate coordinates) {
        this.coordinate = coordinates;
        return this;
    }

    public AirportBuilder timezone(String timezone) {
        this.timezone = timezone;
        return this;
    }

    public Airport build() {
        this.checkRequiredFields();

        return new Airport(
                this.airportID,
                this.airportCode,
                this.airportName,
                this.city,
                this.coordinate,
                this.timezone
        );
    }

    private void checkRequiredFields() {
        if (this.airportID == null) {
            throw AirportError.errAirportIDIsRequired();
        }
        if (this.airportCode == null) {
            throw AirportError.errAirportCodeIsRequired();
        }
        if (this.airportName == null) {
            throw AirportError.errAirportNameIsRequired();
        }
        if (this.city == null) {
            throw AirportError.errCityIsRequired();
        }
        if (this.coordinate == null) {
            throw AirportError.errAirportCoordinateIsRequired();
        }
        if (this.timezone == null) {
            throw AirportError.errAirportTimezoneIsRequired();
        }
    }
}
