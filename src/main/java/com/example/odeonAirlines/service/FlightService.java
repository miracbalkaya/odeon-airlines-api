package com.example.odeonAirlines.service;

import com.example.odeonAirlines.controller.model.FlightResponseDTO;

import java.util.List;

public interface FlightService {

    List<FlightResponseDTO> findAllFlights();
}

