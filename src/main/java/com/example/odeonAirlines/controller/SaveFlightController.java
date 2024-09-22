package com.example.odeonAirlines.controller;


import com.example.odeonAirlines.controller.model.FlightRequestDTO;
import com.example.odeonAirlines.controller.model.FlightResponseDTO;
import com.example.odeonAirlines.service.SaveFlightService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/flights")
public class SaveFlightController {

    private final SaveFlightService saveFlightService;

    @PostMapping
    public ResponseEntity<FlightResponseDTO> saveFlight(@RequestBody @Valid FlightRequestDTO flightRequestDTO) {
        FlightResponseDTO savedFlight = saveFlightService.save(flightRequestDTO);
        return ResponseEntity.ok(savedFlight);
    }
}
