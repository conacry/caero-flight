package org.conacry.caero.domain.entity.usecase;

import org.conacry.caero.boundary.repository.FlightRepository;
import org.conacry.caero.domain.entity.Flight;
import org.conacry.caero.domain.entity.FlightError;
import org.conacry.caero.domain.entity.FlightID;
import org.conacry.caero.shared.exception.CodedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import testdouble.entity.FlightStub;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ReadFlightDataUseCaseTest {
    @Mock
    private FlightRepository flightRepository;

    private ReadFlightDataUseCaseImpl readFlightDataUseCase;

    @BeforeEach
    void setUp() {
        readFlightDataUseCase = new ReadFlightDataUseCaseImpl(flightRepository);
    }

    @Test
    void findByID_FlightIDStrIsNull_ThrowEx() {
        var ex = assertThrows(CodedException.class, () -> readFlightDataUseCase.findByID(null));
        assertEquals(FlightError.FLIGHT_ID_VALUE_IS_REQUIRED, ex.getCode());
    }

    @Test
    void findByID_FlightNotFoundByID_ThrowEx() {
        var flightID = FlightID.newID().toString();
        when(flightRepository.findByID(any(FlightID.class))).thenReturn(Optional.empty());

        var ex = assertThrows(CodedException.class, () -> readFlightDataUseCase.findByID(flightID));
        assertEquals(UseCaseError.FLIGHT_NOT_FOUND, ex.getCode());
    }

    @Test
    void findAll_FlightIsNull_ThrowEx() {
        when(flightRepository.findAll()).thenThrow(new RuntimeException());
        assertThrows(RuntimeException.class, () -> readFlightDataUseCase.findAll());
    }

    @Test
    void findAll_RepoReturnEmptyList_ReturnEmptyList() {
        when(flightRepository.findAll()).thenReturn(Collections.emptyList());
        var flightList = readFlightDataUseCase.findAll();
        assertNotNull(flightList);
        assertTrue(flightList.isEmpty());
    }

    @Test
    void findAll_RepoReturnFilledList_ReturnAircraftList() {
        var flightList = FlightStub.getListFullFlight(5);
        when(flightRepository.findAll()).thenReturn(flightList);
        var actualFlightList = readFlightDataUseCase.findAll();
        assertEquals(actualFlightList, flightList);
    }
}