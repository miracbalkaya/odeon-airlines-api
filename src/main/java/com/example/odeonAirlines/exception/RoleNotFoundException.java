package com.example.odeonAirlines.exception;

public class RoleNotFoundException extends BaseException {

    private static final String message = "Role not found!";

    public RoleNotFoundException() {
        super(message);
    }
}
