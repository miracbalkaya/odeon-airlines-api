package com.example.odeonAirlines.controller;

import com.example.odeonAirlines.controller.model.FlightResponseDTO;
import com.example.odeonAirlines.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/flights")
public class ReadFlightController {

    private final FlightService flightService;

    @GetMapping
    public ResponseEntity<List<FlightResponseDTO>> getAllFlights() {
        List<FlightResponseDTO> flights = flightService.findAllFlights();
        return ResponseEntity.ok(flights);
    }
}
