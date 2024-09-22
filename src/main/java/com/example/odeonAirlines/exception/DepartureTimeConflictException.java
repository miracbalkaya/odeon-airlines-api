package com.example.odeonAirlines.exception;

public class DepartureTimeConflictException extends BaseException {

    private static final String message = "Bu şehirde 30 dakika içinde başka bir uçuş mevcut! havalimanı kodu: %s";
    public DepartureTimeConflictException(String airportCode) {
        super(String.format(message, airportCode));
    }
}
