package com.example.odeonAirlines.controller.mapper;

import com.example.odeonAirlines.controller.model.FlightResponseDTO;
import com.example.odeonAirlines.entity.Flight;

public class FlightResponseDTOMapper {

    public static FlightResponseDTO mapToResponseDTO(Flight flight) {
        FlightResponseDTO flightResponseDTO = new FlightResponseDTO();
        flightResponseDTO.setDepartureCity(flight.getDepartureCity());
        flightResponseDTO.setArrivalCity(flight.getArrivalCity());
        flightResponseDTO.setDepartureTime(flight.getDepartureTime());
        flightResponseDTO.setArrivalTime(flight.getArrivalTime());
        flightResponseDTO.setFlightCode(flight.getFlightCode());
        return flightResponseDTO;
    }

}
