package com.example.odeonAirlines.controller.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FlightResponseDTO {
    private String departureCity;
    private String arrivalCity;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private String flightCode;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        FlightResponseDTO that = (FlightResponseDTO) object;
        return Objects.equals(departureCity, that.departureCity) && Objects.equals(arrivalCity, that.arrivalCity) && Objects.equals(departureTime, that.departureTime) && Objects.equals(arrivalTime, that.arrivalTime) && Objects.equals(flightCode, that.flightCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departureCity, arrivalCity, departureTime, arrivalTime, flightCode);
    }
}
