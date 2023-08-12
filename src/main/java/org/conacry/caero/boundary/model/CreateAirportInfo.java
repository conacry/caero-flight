package org.conacry.caero.boundary.model;


public class CreateAirportInfo {
    private String airportCode;
    private String airportName;
    private String city;
    private CoordinateInfo coordinate;
    private String timezone;

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public CoordinateInfo getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(CoordinateInfo coordinate) {
        this.coordinate = coordinate;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public static class CoordinateInfo {
        private double latitude;
        private double longitude;

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }
    }
}
