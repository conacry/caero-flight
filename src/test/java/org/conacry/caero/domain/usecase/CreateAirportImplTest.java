package org.conacry.caero.domain.usecase;

import org.conacry.caero.boundary.model.CreateAirportInfo;
import org.conacry.caero.boundary.repository.AirportRepository;
import org.conacry.caero.boundary.usecase.CreateAirport;
import org.conacry.caero.domain.entity.*;
import org.conacry.caero.shared.exception.CodedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CreateAirportImplTest {
    @Mock
    private AirportRepository airportRepo;
    private CreateAirport createAirportUseCase;

    @BeforeEach
    void setUp() {
        this.createAirportUseCase = new CreateAirportImpl(airportRepo);
    }
    @Test
    void execute_InfoIsNull_ThrowEx() {
        var ex = assertThrows(CodedException.class, () -> createAirportUseCase.execute(null));
        assertEquals(UsecaseError.AIRPORT_INFO_IS_NULL, ex.getCode());
    }

    @Test
    void execute_AirportAlreadyExist_ThrowEx() {
        var airportInfo = new CreateAirportInfo();
        airportInfo.setAirportCode("RST");
        airportInfo.setAirportName("Dubai");
        airportInfo.setCity("Dubai");
        var coordinateInfo = new CreateAirportInfo.CoordinateInfo();
        coordinateInfo.setLatitude(80.123456);
        coordinateInfo.setLongitude(160.123456);
        airportInfo.setCoordinate(coordinateInfo);
        airportInfo.setTimezone("UTC +6");

        when(airportRepo.exist(any(AirportCode.class))).thenReturn(Boolean.TRUE);

        var ex = assertThrows(CodedException.class, () -> createAirportUseCase.execute(airportInfo));
        assertEquals(UsecaseError.AIRPORT_ALREADY_EXIST, ex.getCode());
    }

    @Test
    void execute_AllParamsAreValid_AirportBuiltAndSaved() {
        var airportInfo = new CreateAirportInfo();
        airportInfo.setAirportCode("RST");
        airportInfo.setAirportName("Dubai");
        airportInfo.setCity("Dubai");
        var coordinateInfo = new CreateAirportInfo.CoordinateInfo();
        coordinateInfo.setLatitude(80.123456);
        coordinateInfo.setLongitude(160.123456);
        airportInfo.setCoordinate(coordinateInfo);
        airportInfo.setTimezone("UTC +6");

        when(airportRepo.exist(any(AirportCode.class))).thenReturn(Boolean.FALSE);

        createAirportUseCase.execute(airportInfo);

        var captor = ArgumentCaptor.forClass(Airport.class);
        verify(airportRepo, times(1)).save(captor.capture());

        var actualAirport = captor.getValue();
        assertNotNull(actualAirport);
    }
}