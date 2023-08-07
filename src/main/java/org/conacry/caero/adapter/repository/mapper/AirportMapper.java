package org.conacry.caero.adapter.repository.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.conacry.caero.adapter.repository.model.AirportDbModel;

import java.util.UUID;

@Mapper
public interface AirportMapper {
    void insert(@Param("model") AirportDbModel model);
    AirportDbModel selectByID(@Param("id") UUID id);
}
