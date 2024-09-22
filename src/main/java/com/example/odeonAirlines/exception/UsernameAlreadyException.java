package com.example.odeonAirlines.exception;

public class UsernameAlreadyException extends BaseException {

    private static final String message = "Username already exists!";

    public UsernameAlreadyException() {
        super(message);
    }
}
