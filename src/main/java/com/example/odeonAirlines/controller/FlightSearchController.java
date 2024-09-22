package com.example.odeonAirlines.controller;

import com.example.odeonAirlines.controller.model.FlightResponseDTO;
import com.example.odeonAirlines.service.FlightSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/flights/departure")
public class FlightSearchController {

    private final FlightSearchService flightSearchServiceImpl;

    @GetMapping
    public ResponseEntity<List<FlightResponseDTO>> getFlightsByDepartureCity(@RequestParam(required = false) String departureCity) {
        return ResponseEntity.ok(flightSearchServiceImpl.findFlightsByDepartureCity(departureCity));
    }
}
