package org.conacry.caero.domain.usecase;

import org.conacry.caero.shared.exception.CodedException;

public class UsecaseError {
    public static final String AIRPORT_ALREADY_EXIST = "214d9c61-001";
    public static final String AIRPORT_INFO_IS_NULL = "214d9c61-002";

    public static CodedException errAirportAlreadyExist() {
        var errMsg = "Airport already exist";
        return new CodedException(AIRPORT_ALREADY_EXIST, errMsg);
    }

    public static CodedException errAirportInfoIsNull() {
        var errMsg = "Airport info cannot be null";
        return new CodedException(AIRPORT_INFO_IS_NULL, errMsg);
    }


}
