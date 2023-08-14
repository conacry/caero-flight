package org.conacry.caero.adapter.repository.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.conacry.caero.adapter.repository.model.FlightDbModel;
import org.conacry.caero.domain.entity.Flight;
import org.conacry.caero.domain.entity.FlightID;

import java.util.List;

@Mapper
public interface FlightMapper {
    void insert(@Param("model")FlightDbModel model);
    FlightDbModel selectByID(@Param("ID")FlightID flightID);
    List<Flight> selectAll();
    void deleteAll ();
}
