package com.example.odeonAirlines.service;

import com.example.odeonAirlines.controller.model.FlightRequestDTO;
import com.example.odeonAirlines.controller.model.FlightResponseDTO;

public interface SaveFlightService {
    FlightResponseDTO save(FlightRequestDTO flightRequestDTO);
}

