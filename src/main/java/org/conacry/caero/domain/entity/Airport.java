package org.conacry.caero.domain.entity;

public class Airport {

    private final AirportID airportID;
    private AirportCode airportCode;
    private AirportName airportName;
    private City city;
    private Coordinate coordinate;
    private String timezone;

    public Airport(AirportID airportID,
                   AirportCode airportCode,
                   AirportName airportName,
                   City city,
                   Coordinate coordinate,
                   String timezone) {
        this.airportID = airportID;
        this.airportCode = airportCode;
        this.airportName = airportName;
        this.city = city;
        this.coordinate = coordinate;
        this.timezone = timezone;
    }

    public AirportID getAirportID() {
        return airportID;
    }

    public AirportCode getAirportCode() {
        return airportCode;
    }

    public AirportName getAirportName() {
        return airportName;
    }

    public City getCity() {
        return city;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public String getTimezone() {
        return timezone;
    }
}
