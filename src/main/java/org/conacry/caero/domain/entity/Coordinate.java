package org.conacry.caero.domain.entity;

public class Coordinate {

    private final double latitude;
    private final double longitude;

    public static Coordinate of(double latitudeValue, double longitudeValue) {
        if (Math.abs(latitudeValue) > 90) {
            throw AirportError.errCoordinateLatitudeIsIllegal(String.valueOf(latitudeValue));
        }
        if (Math.abs(longitudeValue) > 180) {
            throw AirportError.errCoordinateLongitudeIsIllegal(String.valueOf(longitudeValue));
        }
        return new Coordinate(latitudeValue, longitudeValue);
    }

    private Coordinate(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
