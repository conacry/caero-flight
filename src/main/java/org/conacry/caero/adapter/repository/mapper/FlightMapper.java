package org.conacry.caero.adapter.repository.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.conacry.caero.adapter.repository.model.FlightDbModel;
import org.conacry.caero.domain.entity.Flight;
import org.conacry.caero.domain.entity.FlightID;

import java.util.List;
import java.util.UUID;

@Mapper
public interface FlightMapper {
    FlightDbModel findByID(@Param("ID")FlightID flightID);

    List<Flight> findAll();
}
