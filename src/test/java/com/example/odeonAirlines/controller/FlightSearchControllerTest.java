package com.example.odeonAirlines.controller;

import com.example.odeonAirlines.controller.model.FlightResponseDTO;
import com.example.odeonAirlines.service.FlightSearchService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class FlightSearchControllerTest {

    @InjectMocks
    private FlightSearchController flightSearchController;

    @Mock
    private FlightSearchService flightSearchService;

    @Test
    public void searchFlights() {
        //given
        FlightResponseDTO flightResponseDTO = FlightResponseDTO.builder()
                .flightCode("flightCode")
                .departureCity("departureCity")
                .arrivalCity("arrivalCity")
                .departureTime(null)
                .arrivalTime(null)
                .build();

        Mockito.when(flightSearchService.findFlightsByDepartureCity(Mockito.anyString())).thenReturn(List.of(flightResponseDTO));
        //when
        ResponseEntity<List<FlightResponseDTO>> response = flightSearchController.getFlightsByDepartureCity("departureCity");

        //then
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1, response.getBody().size());
        assertEquals(flightResponseDTO, response.getBody().get(0));    }

}