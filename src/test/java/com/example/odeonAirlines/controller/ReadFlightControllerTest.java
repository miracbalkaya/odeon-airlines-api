package com.example.odeonAirlines.controller;

import com.example.odeonAirlines.controller.model.FlightResponseDTO;
import com.example.odeonAirlines.service.FlightService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ReadFlightControllerTest {

    @InjectMocks
    private ReadFlightController readFlightController;

    @Mock
    private FlightService flightService;

    @Test
    public void getAllFlights() {
        //given
        FlightResponseDTO flightResponseDTO = FlightResponseDTO.builder()
                .flightCode("flightCode")
                .departureCity("departureCity")
                .arrivalCity("arrivalCity")
                .departureTime(null)
                .arrivalTime(null)
                .build();

        Mockito.when(flightService.findAllFlights()).thenReturn(List.of(flightResponseDTO));
        //when
        List<FlightResponseDTO> result = readFlightController.getAllFlights().getBody();
        //then
        assertEquals(List.of(flightResponseDTO), result);
    }
}