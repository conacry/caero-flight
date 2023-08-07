package org.conacry.caero.adapter.repository.converter;

import org.conacry.caero.adapter.repository.RepositoryError;
import org.conacry.caero.shared.exception.CodedException;
import org.junit.jupiter.api.Test;
import testdouble.entity.AirportDbModelStub;
import testdouble.entity.AirportStub;

import static org.junit.jupiter.api.Assertions.*;

class AirportConverterTest {

    @Test
    void toModel_AirportIsNull_ThrowEx() {
        var ex = assertThrows(CodedException.class, () -> AirportConverter.toModel(null));
        assertEquals(RepositoryError.AIRPORT_IS_REQUIRED, ex.getCode());
    }

    @Test
    void toModel_ValueIsValid_ReturnAirportDbModel() {
        var airport = AirportStub.getAirport();

        var airportDbModel = AirportConverter.toModel(airport);

        assertNotNull(airportDbModel);
        assertEquals(airportDbModel.getAirportID(), airport.getAirportID().getValue());
        assertEquals(airportDbModel.getAirportCode(), airport.getAirportCode().getValue());
        assertEquals(airportDbModel.getAirportName(), airport.getAirportName().getValue());
        assertEquals(airportDbModel.getCity(), airport.getCity().getValue());
        assertEquals(airportDbModel.getLatitude(), String.valueOf(airport.getCoordinate().getLatitude()));
        assertEquals(airportDbModel.getLongitude(), String.valueOf(airport.getCoordinate().getLongitude()));
        assertEquals(airportDbModel.getTimezone(), airport.getTimezone());
    }

    @Test
    void toModels_AirportsIsNull_ThrowEx() {
        var ex = assertThrows(CodedException.class, () -> AirportConverter.toModels(null));
        assertEquals(RepositoryError.AIRPORTS_IS_REQUIRED, ex.getCode());
    }

    @Test
    void toModels_ValueIsValid_ReturnAirportDbModels() {
        var count = 5;
        var airports = AirportStub.getAirports(count);

        var airportDbModels = AirportConverter.toModels(airports);

        assertNotNull(airportDbModels);

        for (int i = 0; i < count; i++) {
            assertNotNull(airportDbModels.get(i));
            assertEquals(airportDbModels.get(i).getAirportID(), airports.get(i).getAirportID().getValue());
            assertEquals(airportDbModels.get(i).getAirportCode(), airports.get(i).getAirportCode().getValue());
            assertEquals(airportDbModels.get(i).getAirportName(), airports.get(i).getAirportName().getValue());
            assertEquals(airportDbModels.get(i).getCity(), airports.get(i).getCity().getValue());
            assertEquals(airportDbModels.get(i).getLatitude(), String.valueOf(airports.get(i).getCoordinate().getLatitude()));
            assertEquals(airportDbModels.get(i).getLongitude(), String.valueOf(airports.get(i).getCoordinate().getLongitude()));
            assertEquals(airportDbModels.get(i).getTimezone(), airports.get(i).getTimezone());
        }
    }

    @Test
    void toEntity_AirportDbModelIsNull_ThrowEx() {
        var ex = assertThrows(CodedException.class, () -> AirportConverter.toEntity(null));
        assertEquals(RepositoryError.AIRPORT_DB_MODEL_IS_REQUIRED, ex.getCode());
    }

    @Test
    void toEntity_ValueIsValid_ReturnAirport() {
        var airportDbModel = AirportDbModelStub.getAirportDbModel();
        var airport = AirportConverter.toEntity(airportDbModel);

        assertNotNull(airport);
        assertEquals(airportDbModel.getAirportID(), airport.getAirportID().getValue());
        assertEquals(airportDbModel.getAirportCode(), airport.getAirportCode().getValue());
        assertEquals(airportDbModel.getAirportName(), airport.getAirportName().getValue());
        assertEquals(airportDbModel.getCity(), airport.getCity().getValue());
        assertEquals(airportDbModel.getLatitude(), String.valueOf(airport.getCoordinate().getLatitude()));
        assertEquals(airportDbModel.getLongitude(), String.valueOf(airport.getCoordinate().getLongitude()));
        assertEquals(airportDbModel.getTimezone(), airport.getTimezone());
    }

    @Test
    void toEntities_AirportDbModelsIsNull_ThrowEx() {
        var ex = assertThrows(CodedException.class, () -> AirportConverter.toEntities(null));
        assertEquals(RepositoryError.AIRPORT_DB_MODELS_IS_REQUIRED, ex.getCode());
    }

    @Test
    void toEntities_ValueIsValid_ReturnAirports() {
        var count = 5;
        var airportDbModels = AirportDbModelStub.getAirportDbModels(count);

        var airports = AirportConverter.toEntities(airportDbModels);

        assertNotNull(airportDbModels);

        for (int i = 0; i < count; i++) {
            assertNotNull(airportDbModels.get(i));
            assertEquals(airportDbModels.get(i).getAirportID(), airports.get(i).getAirportID().getValue());
            assertEquals(airportDbModels.get(i).getAirportCode(), airports.get(i).getAirportCode().getValue());
            assertEquals(airportDbModels.get(i).getAirportName(), airports.get(i).getAirportName().getValue());
            assertEquals(airportDbModels.get(i).getCity(), airports.get(i).getCity().getValue());
            assertEquals(airportDbModels.get(i).getLatitude(), String.valueOf(airports.get(i).getCoordinate().getLatitude()));
            assertEquals(airportDbModels.get(i).getLongitude(), String.valueOf(airports.get(i).getCoordinate().getLongitude()));
            assertEquals(airportDbModels.get(i).getTimezone(), airports.get(i).getTimezone());
        }
    }

}