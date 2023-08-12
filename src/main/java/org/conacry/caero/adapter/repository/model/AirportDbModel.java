package org.conacry.caero.adapter.repository.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
public class AirportDbModel {
    private UUID airportID;
    private String airportCode;
    private String airportName;
    private String city;
    private String latitude;
    private String longitude;
    private String timezone;
}
