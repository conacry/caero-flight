package org.conacry.caero.domain.entity;

import java.util.regex.Pattern;

public class AirportCode {

    private static final Pattern FORMAT_PATTERN = Pattern.compile("[^A-Z]");

    private final String value;

    private AirportCode(String value) {
        this.value = value;
    }

    public static AirportCode of(String codeValue) {
        if (codeValue == null || codeValue.isBlank()) {
            throw AirportError.errAirportCodeValueIsEmpty();
        }
        if (codeValue.length() > 3) {
            throw AirportError.errAirportCodeValueIsIllegalFormat(codeValue);
        }
        var matcher = FORMAT_PATTERN.matcher(codeValue);
        if (matcher.find()) {
            throw AirportError.errAirportCodeValueIsIllegalFormat(codeValue);
        }

        return new AirportCode(codeValue);
    }

    public String getValue() {
        return this.value;
    }
}
