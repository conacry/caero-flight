package org.conacry.caero.adapter.repository;

import org.conacry.caero.adapter.repository.mapper.AirportMapper;
import org.conacry.caero.adapter.repository.model.AirportDbModel;
import org.conacry.caero.boundary.repository.AirportRepository;
import org.conacry.caero.domain.entity.AirportID;
import org.conacry.caero.shared.exception.CodedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import testdouble.entity.AirportDbModelStub;
import testdouble.entity.AirportStub;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AirportRepositoryImplTest {

    @Mock
    private AirportMapper airportMapper;

    @Captor
    private ArgumentCaptor<AirportDbModel> airportDbModelCaptor;

    private AirportRepository airportRepository;

    @BeforeEach
    void setUp() {
        this.airportRepository = new AirportRepositoryImpl(airportMapper);
    }

    @Test
    void save_AirportIsNull_ThrowEx() {
        var ex = assertThrows(CodedException.class, () -> airportRepository.save(null));
        assertEquals(RepositoryError.AIRPORT_IS_REQUIRED, ex.getCode());
    }

    @Test
    void save_ValueIsValid_AirportSaved() {
        var airport = AirportStub.getAirport();

        airportRepository.save(airport);
        verify(airportMapper).insert(airportDbModelCaptor.capture());

        var airportDbModel = airportDbModelCaptor.getValue();
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
    void findByID_AirportIDIsNull_ThrowEx() {
        var ex = assertThrows(CodedException.class, () -> airportRepository.findByID(null));
        assertEquals(RepositoryError.AIRPORT_ID_IS_REQUIRED, ex.getCode());
    }

    @Test
    void findByID_ValueIsValid_ReturnAirport() {
        var airportDbModel = AirportDbModelStub.getAirportDbModel();

        when(airportMapper.selectByID(any(UUID.class))).thenReturn(airportDbModel);

        var airportOpt = airportRepository.findByID(AirportID.newID());

        assertTrue(airportOpt.isPresent());
        var airport = airportOpt.get();

        assertNotNull(airport);
        assertEquals(airportDbModel.getAirportID(), airport.getAirportID().getValue());
        assertEquals(airportDbModel.getAirportCode(), airport.getAirportCode().getValue());
        assertEquals(airportDbModel.getAirportName(), airport.getAirportName().getValue());
        assertEquals(airportDbModel.getCity(), airport.getCity().getValue());
        assertEquals(airportDbModel.getLatitude(), String.valueOf(airport.getCoordinate().getLatitude()));
        assertEquals(airportDbModel.getLongitude(), String.valueOf(airport.getCoordinate().getLongitude()));
        assertEquals(airportDbModel.getTimezone(), airport.getTimezone());
    }

}