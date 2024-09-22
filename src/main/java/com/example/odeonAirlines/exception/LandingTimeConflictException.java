package com.example.odeonAirlines.exception;

public class LandingTimeConflictException extends BaseException {
    private static final String message = "Bu şehirde 30 dakika içinde başka bir iniş mevcut! havalimanı kodu: %s";
    public LandingTimeConflictException(String airportCode) {
        super(String.format(message, airportCode));
    }
}
