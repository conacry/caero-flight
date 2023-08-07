package org.conacry.caero.adapter.repository.converter;

import org.conacry.caero.adapter.repository.RepositoryError;
import org.conacry.caero.adapter.repository.model.AirportDbModel;
import org.conacry.caero.domain.entity.*;

import java.util.List;

public final class AirportConverter {

    public static AirportDbModel toModel(Airport airport) {
        if (airport == null) {
            throw RepositoryError.errAirportIsRequired();
        }
        var airportID = airport.getAirportID().getValue();
        var airportCode = airport.getAirportCode().getValue();
        var airportName = airport.getAirportName().getValue();
        var city = airport.getCity().getValue();
        var latitude = String.valueOf(airport.getCoordinate().getLatitude());
        var longitude = String.valueOf(airport.getCoordinate().getLongitude());
        var timezone = airport.getTimezone();

        var airportDbModel = new AirportDbModel();
        airportDbModel.setAirportID(airportID);
        airportDbModel.setAirportCode(airportCode);
        airportDbModel.setAirportName(airportName);
        airportDbModel.setCity(city);
        airportDbModel.setLatitude(latitude);
        airportDbModel.setLongitude(longitude);
        airportDbModel.setTimezone(timezone);

        return airportDbModel;
    }

    public static List<AirportDbModel> toModels(List<Airport> airports) {
        if (airports == null) {
            throw RepositoryError.errAirportsIsRequired();
        }

        return airports.stream().
                map(AirportConverter::toModel).
                toList();

    }

    public static Airport toEntity(AirportDbModel airportDbModel) {
        if (airportDbModel == null) {
            throw RepositoryError.errAirportDbModelIsRequired();
        }

        var airportID = AirportID.from(airportDbModel.getAirportID().toString());
        var airportCode = AirportCode.of(airportDbModel.getAirportCode());
        var airportName = AirportName.from(airportDbModel.getAirportName());
        var city = City.of(airportDbModel.getCity());
        var latitude = Double.parseDouble(airportDbModel.getLatitude());
        var longitude = Double.parseDouble(airportDbModel.getLongitude());
        var coordinate = Coordinate.of(latitude, longitude);
        var timezone = airportDbModel.getTimezone();

        return new AirportBuilder().
                airportID(airportID).
                airportCode(airportCode).
                airportName(airportName).
                city(city).
                coordinates(coordinate).
                timezone(timezone).
                build();
    }

    public static List<Airport> toEntities(List<AirportDbModel> airportDbModels) {
        if (airportDbModels == null) {
            throw RepositoryError.errAirportDbModelsIsRequired();
        }

        return airportDbModels.stream().
                map(AirportConverter::toEntity).
                toList();

    }

    private AirportConverter() {}
}

