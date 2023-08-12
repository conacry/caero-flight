package org.conacry.caero.adapter.controller;

import org.conacry.caero.shared.exception.CodedException;

public class ControllerError {
    public static final String CREATE_AIRPORT_REQUEST_IS_NULL = "40f13e7a-001";
    public static final String CREATE_AIRPORT_REQUEST_COORDINATE_IS_NULL = "40f13e7a-002";

    public static CodedException errCreateAirportRequestIsNull() {
        var errMsg = "Create airport request is null";
        return new CodedException(CREATE_AIRPORT_REQUEST_IS_NULL, errMsg);

    }

    public static CodedException errCreateAirportRequestCoordinateIsNull() {
        var errMsg = "Create airport request coordinate is null";
        return new CodedException(CREATE_AIRPORT_REQUEST_COORDINATE_IS_NULL, errMsg);
    }
}
