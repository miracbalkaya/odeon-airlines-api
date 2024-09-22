package com.example.odeonAirlines.controller.model;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FlightRequestDTO {
    @NotBlank
    private String departureCity;
    @NotBlank
    private String arrivalCity;
    @NotBlank
    private String departureAirportCode;
    @NotBlank
    private String arrivalAirportCode;

    private LocalDateTime departureTime;

    private LocalDateTime arrivalTime;
    @NotBlank
    private String flightCode;

}
