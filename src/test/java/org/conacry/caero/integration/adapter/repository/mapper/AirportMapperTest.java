package org.conacry.caero.integration.adapter.repository.mapper;

import org.conacry.caero.adapter.repository.mapper.AirportMapper;
import org.conacry.caero.adapter.repository.model.AirportDbModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import testdouble.entity.AirportDbModelStub;
import util.annotation.IntegrationTest;

import static org.junit.jupiter.api.Assertions.*;

@IntegrationTest
class AirportMapperTest {

    @Autowired
    private AirportMapper airportMapper;

    private static final AirportDbModel AIRPORT_DB_MODEL = AirportDbModelStub.getAirportDbModel();

    @BeforeEach
    void setUp() {
        airportMapper.insertAirport(AIRPORT_DB_MODEL);
    }

    @AfterEach
    void tearDown() {
        airportMapper.deleteAll();
    }

    @Test
    void selectByID_ValueIsValid_ReturnAirportDbModel() {
        var id = AIRPORT_DB_MODEL.getAirportID();

        var airportDbModelFromDb = airportMapper.selectByID(id);
        assertNotNull(airportDbModelFromDb);
        assertEquals(AIRPORT_DB_MODEL, airportDbModelFromDb);
    }
}
