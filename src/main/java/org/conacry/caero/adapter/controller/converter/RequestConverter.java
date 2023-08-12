package org.conacry.caero.adapter.controller.converter;

import org.conacry.caero.adapter.controller.ControllerError;
import org.conacry.caero.adapter.controller.request.CreateAirportRequest;
import org.conacry.caero.boundary.model.CreateAirportInfo;

public class RequestConverter {

    public static CreateAirportInfo createAirportRequestToInfo(CreateAirportRequest request) {
        if(request == null) {
            throw ControllerError.errCreateAirportRequestIsNull();
        }
        var airportInfo = new CreateAirportInfo();
        airportInfo.setAirportCode(request.getAirportCode());
        airportInfo.setAirportName(request.getAirportName());
        airportInfo.setCity(request.getCity());
        airportInfo.setTimezone(request.getTimezone());

        if(request.getCoordinate() == null){
            throw ControllerError.errCreateAirportRequestCoordinateIsNull();
        }
        var coordinatesInfo = new CreateAirportInfo.CoordinateInfo();
        coordinatesInfo.setLongitude(request.getCoordinate().getLongitude());
        coordinatesInfo.setLatitude(request.getCoordinate().getLatitude());
        airportInfo.setCoordinate(coordinatesInfo);

        return airportInfo;
    }

    private RequestConverter(){
    }
}
