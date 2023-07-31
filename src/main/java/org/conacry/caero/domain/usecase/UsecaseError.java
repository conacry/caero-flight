package org.conacry.caero.domain.usecase;

import org.conacry.caero.shared.exception.CodedException;

public class UsecaseError {
    public static final String AIRPORT_ALREADY_EXIST = "214d9c61-001";

    public static CodedException errAirportAlreadyExist() {
        var errMsg = "Airport already exist";
        return new CodedException(AIRPORT_ALREADY_EXIST, errMsg);
    }

}
