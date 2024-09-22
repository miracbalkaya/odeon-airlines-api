package com.example.odeonAirlines.service;

import com.example.odeonAirlines.controller.model.FlightResponseDTO;

import java.util.List;

public interface FlightSearchService {

    List<FlightResponseDTO> findFlightsByDepartureCity(String departureCity);
}

