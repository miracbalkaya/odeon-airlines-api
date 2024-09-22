package com.example.odeonAirlines.service.Impl;

import com.example.odeonAirlines.controller.mapper.FlightResponseDTOMapper;
import com.example.odeonAirlines.controller.model.FlightResponseDTO;
import com.example.odeonAirlines.entity.User;
import com.example.odeonAirlines.repository.FlightRepository;
import com.example.odeonAirlines.service.FlightSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FlightSearchServiceImpl implements FlightSearchService {

    private final FlightRepository flightRepository;

    @Override
    public List<FlightResponseDTO> findFlightsByDepartureCity(String departureCity) {
        if (departureCity == null || departureCity.isEmpty()) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            User user = (User) authentication.getPrincipal();
            departureCity =user.getCity();
        }

        return flightRepository.findByDepartureCity(departureCity).stream()
                .map(FlightResponseDTOMapper::mapToResponseDTO)
                .collect(Collectors.toList());
    }
}

