package com.example.odeonAirlines.service.Impl;

import com.example.odeonAirlines.controller.model.FlightRequestDTO;
import com.example.odeonAirlines.controller.model.FlightResponseDTO;
import com.example.odeonAirlines.entity.Flight;
import com.example.odeonAirlines.exception.DepartureTimeConflictException;
import com.example.odeonAirlines.exception.LandingTimeConflictException;
import com.example.odeonAirlines.repository.FlightRepository;
import com.example.odeonAirlines.service.FlightService;
import com.example.odeonAirlines.service.SaveFlightService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.odeonAirlines.controller.mapper.FlightResponseDTOMapper.mapToResponseDTO;

@Slf4j
@Service
@RequiredArgsConstructor
public class SaveFlightServiceImpl implements SaveFlightService {

    private final FlightRepository flightRepository;

    @Override
    public FlightResponseDTO save(FlightRequestDTO request) {

        log.info("Saving flight with params: City: {}, DepartureTime: {}, ArrivalTime: {}",
                request.getDepartureCity(), request.getDepartureTime(), request.getArrivalTime());

        validateFlight(request);

        Flight flight = Flight.builder()
                .departureCity(request.getDepartureCity())
                .arrivalCity(request.getArrivalCity())
                .departureTime(request.getDepartureTime())
                .arrivalTime(request.getArrivalTime())
                .arrivalAirportCode(request.getArrivalAirportCode())
                .departureAirportCode(request.getDepartureAirportCode())
                .flightCode(request.getFlightCode())
                .build();

        Flight savedFlight = flightRepository.save(flight);

        return mapToResponseDTO(savedFlight);
    }

    private void validateFlight(FlightRequestDTO request) {

        List<Flight> flightsDepartingFromCity = flightRepository.findFirstByDepartureAirportCodeAndBetweenDepartureTimeAndNow(request.getDepartureAirportCode(), request.getDepartureTime(), request.getDepartureTime().plusMinutes(30));

        if (!flightsDepartingFromCity.isEmpty()) {
            throw new DepartureTimeConflictException(request.getDepartureAirportCode());
        }

        List<Flight> flightsArrivingAtDepartureCity = flightRepository.findFirstByArrivalAirportCodeAndBetweenDepartureTimeAndNow(request.getDepartureAirportCode(), request.getDepartureTime(), request.getDepartureTime().plusMinutes(30));

        if (!flightsArrivingAtDepartureCity.isEmpty()) {
            throw new LandingTimeConflictException(request.getArrivalAirportCode());
        }

        List<Flight> flightsDepartingToCity = flightRepository.findFirstByArrivalAirportCodeAndBetweenDepartureTimeAndNow(request.getArrivalAirportCode(), request.getArrivalTime().minusMinutes(30), request.getArrivalTime());

        if (!flightsDepartingToCity.isEmpty()) {
            throw new LandingTimeConflictException(request.getArrivalAirportCode());
        }

        List<Flight> flightsArrivingAtDestinationCity = flightRepository.findFirstByDepartureAirportCodeAndBetweenDepartureTimeAndNow(request.getArrivalAirportCode(), request.getArrivalTime().minusMinutes(30), request.getArrivalTime());

        if (!flightsArrivingAtDestinationCity.isEmpty()) {
            throw new DepartureTimeConflictException(request.getArrivalAirportCode());
        }
    }
}
