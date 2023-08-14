package org.conacry.caero.integration.adapter.repository.mapper;

import org.conacry.caero.adapter.repository.mapper.FlightMapper;
import org.conacry.caero.adapter.repository.model.FlightDbModel;
import org.conacry.caero.domain.entity.FlightID;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import testdouble.entity.FlightDbModelStub;
import util.annotation.IntegrationTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@IntegrationTest
class FlightMapperTest {
    @Autowired
    private FlightMapper flightMapper;

    private static final FlightDbModel FLIGHT_DB_MODEL = FlightDbModelStub.getFlightDbModel();

    @BeforeEach
    void setUp() {
        flightMapper.insert(FLIGHT_DB_MODEL);
    }

    @AfterEach
    void tearDown() {
        flightMapper.deleteAll();
    }

    @Test
    void selectByID_ValueIsValid_ReturnFlightDbModel() {
        var id = FLIGHT_DB_MODEL.getFlightID();
        var flightID = FlightID.from(id.toString());

        var flightDbModelFromDb = flightMapper.selectByID(flightID);
        assertNotNull(flightDbModelFromDb);
        assertEquals(FLIGHT_DB_MODEL, flightDbModelFromDb);
    }

}
