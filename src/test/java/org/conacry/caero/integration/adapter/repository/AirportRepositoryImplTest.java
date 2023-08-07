package org.conacry.caero.integration.adapter.repository;

import org.conacry.caero.boundary.repository.AirportRepository;
import org.conacry.caero.domain.entity.Airport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import testdouble.entity.AirportStub;
import util.annotation.IntegrationTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@IntegrationTest
class AirportRepositoryImplTest {

    @Autowired
    private AirportRepository airportRepository;

    private static final Airport AIRPORT = AirportStub.getAirport();

    @BeforeEach
    void setUp() {
        airportRepository.save(AIRPORT);
    }

    @Test
    void test() {
        assertTrue(true);
    }




}