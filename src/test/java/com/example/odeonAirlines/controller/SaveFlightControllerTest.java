package com.example.odeonAirlines.controller;

import com.example.odeonAirlines.controller.model.FlightRequestDTO;
import com.example.odeonAirlines.controller.model.FlightResponseDTO;
import com.example.odeonAirlines.service.SaveFlightService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class SaveFlightControllerTest {

    @InjectMocks
    private SaveFlightController saveFlightController;

    @Mock
    private SaveFlightService saveFlightService;

    @Test
    public void saveFlight() {
        //given
        FlightResponseDTO flightResponseDTO = FlightResponseDTO.builder()
                .flightCode("flightCode")
                .departureCity("departureCity")
                .arrivalCity("arrivalCity")
                .departureTime(null)
                .arrivalTime(null)
                .build();

        Mockito.when(saveFlightService.save(Mockito.any(FlightRequestDTO.class))).thenReturn(flightResponseDTO);
        FlightRequestDTO flightRequestDTO = FlightRequestDTO.builder()
                .departureCity("departureCity")
                .arrivalCity("arrivalCity")
                .departureAirportCode("departureAirportCode")
                .arrivalAirportCode("arrivalAirportCode")
                .departureTime(null)
                .arrivalTime(null)
                .flightCode("flightCode")
                .build();
        //when
        FlightResponseDTO result = saveFlightController.saveFlight(flightRequestDTO).getBody();
        //then
        assertEquals(flightResponseDTO, result);
    }

}