package com.example.odeonAirlines.controller.model;

import lombok.Data;

@Data
public class ErrorResponseDTO {

    private String message;

    public ErrorResponseDTO(String message) {
        this.message = message;
    }
}

