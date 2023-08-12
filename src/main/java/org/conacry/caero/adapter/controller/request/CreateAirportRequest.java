package org.conacry.caero.adapter.controller.request;

import lombok.Data;

@Data
public class CreateAirportRequest {
    private String airportCode;
    private String airportName;
    private String city;
    private CoordinateInfo coordinate;
    private String timezone;

    @Data
    public static class CoordinateInfo {
        private double latitude;
        private double longitude;
    }
}
