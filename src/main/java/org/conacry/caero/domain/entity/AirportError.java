package org.conacry.caero.domain.entity;

import org.conacry.caero.shared.exception.CodedException;

public class AirportError {

    public static final String AIRPORT_ID_VALUE_IS_REQUIRED = "9443525c-001";
    public static final String ILLEGAL_AIRPORT_ID_VALUE = "9443525c-002";
    public static final String AIRPORT_CODE_VALUE_EMPTY = "9443525c-003";
    public static final String AIRPORT_CODE_VALUE_ILLEGAL_FORMAT = "9443525c-004";
    public static final String AIRPORT_NAME_REQUIRED = "9443525c-005";
    public static final String AIRPORT_NAME_ILLEGAL_FORMAT = "9443525c-006";
    public static final String  AIRPORT_CITY_REQUIRED = "9443525c-007";
    public static final String COORDINATE_LATITUDE_ILLEGAL_FORMAT = "9443525c-008";
    public static final String COORDINATE_LONGITUDE_ILLEGAL_FORMAT = "9443525c-009";
    public static final String AIRPORT_ID_BUILDER_REQUIRED = "9443525c-010";
    public static final String AIRPORT_CODE_BUILDER_REQUIRED = "9443525c-011";
    public static final String AIRPORT_NAME_BUILDER_REQUIRED = "9443525c-012";
    public static final String AIRPORT_CITY_BUILDER_REQUIRED = "9443525c-013";
    public static final String AIRPORT_COORDINATE_BUILDER_REQUIRED = "9443525c-014";
    public static final String AIRPORT_TIMEZONE_BUILDER_REQUIRED = "9443525c-015";

    public static CodedException errAirportIDValueIsRequired() {
        var errMsg = "Value to create AirportID is required";
        return new CodedException(AIRPORT_ID_VALUE_IS_REQUIRED, errMsg);
    }

    public static CodedException errIllegalAirportIDValue(String valueStr, Throwable cause) {
        var errMsg = String.format("Illegal value = '%s' format to create AirportID", valueStr);
        return new CodedException(ILLEGAL_AIRPORT_ID_VALUE, errMsg, cause);
    }

    public static CodedException errAirportCodeValueIsEmpty() {
        var errMsg = "Value to create AirportCode is required";
        return new CodedException(AIRPORT_CODE_VALUE_EMPTY, errMsg);
    }

    public static CodedException errAirportCodeValueIsIllegalFormat(String codeValue) {
        var errMsg = String.format("Illegal value = '%s' format to create AirportCode", codeValue);
        return new CodedException(AIRPORT_CODE_VALUE_ILLEGAL_FORMAT, errMsg);
    }

    public static CodedException errAirportNameValueIsRequired() {
        var errMsg = "Value to create AirportName is required";
        return new CodedException(AIRPORT_NAME_REQUIRED, errMsg);
    }

    public static CodedException errIllegalAirportNameValue(String value) {
        var errMsg = String.format("Illegal value = '%s' format to create AirportName", value);
        return new CodedException(AIRPORT_NAME_ILLEGAL_FORMAT, errMsg);
    }

    public static CodedException errAirportCityIsRequired() {
        var errMsg ="Value to create City is required";
        return new CodedException(AIRPORT_CITY_REQUIRED, errMsg);
    }

    public static CodedException errCoordinateLatitudeIsIllegal(String value) {
        var errMsg = String.format("Illegal latitude value = '%s' format to create Coordinate", value);
        return new CodedException(COORDINATE_LATITUDE_ILLEGAL_FORMAT, errMsg);
    }

    public static CodedException errCoordinateLongitudeIsIllegal(String value) {
        var errMsg = String.format("Illegal longitude value = '%s' format to create Coordinate", value);
        return new CodedException(COORDINATE_LONGITUDE_ILLEGAL_FORMAT, errMsg);
    }

    public static CodedException errAirportIDIsRequired() {
        var errMsg = "AirportID is required";
        return new CodedException(AIRPORT_ID_BUILDER_REQUIRED, errMsg);
    }

    public static CodedException errAirportCodeIsRequired() {
        var errMsg = "AirportCode is required";
        return new CodedException(AIRPORT_CODE_BUILDER_REQUIRED, errMsg);
    }

    public static CodedException errAirportNameIsRequired() {
        var errMsg = "AirportName is required";
        return new CodedException(AIRPORT_NAME_BUILDER_REQUIRED, errMsg);
    }

    public static CodedException errCityIsRequired() {
        var errMsg = "City is required";
        return new CodedException(AIRPORT_CITY_BUILDER_REQUIRED, errMsg);
    }

    public static CodedException errAirportCoordinateIsRequired() {
        var errMsg = "Coordinate is required";
        return new CodedException(AIRPORT_COORDINATE_BUILDER_REQUIRED, errMsg);
    }

    public static CodedException errAirportTimezoneIsRequired() {
        var errMsg = "Airport Timezone is required";
        return new CodedException(AIRPORT_TIMEZONE_BUILDER_REQUIRED, errMsg);
    }
}
