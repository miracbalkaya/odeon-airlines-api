package com.example.odeonAirlines.service.Impl;

import com.example.odeonAirlines.controller.mapper.FlightResponseDTOMapper;
import com.example.odeonAirlines.controller.model.FlightResponseDTO;
import com.example.odeonAirlines.repository.FlightRepository;
import com.example.odeonAirlines.service.FlightService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;

    @Override
    public List<FlightResponseDTO> findAllFlights() {
        return flightRepository.findAll().stream()
                .map(FlightResponseDTOMapper::mapToResponseDTO)
                .collect(Collectors.toList());
    }

}
