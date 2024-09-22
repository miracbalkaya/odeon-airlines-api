package com.example.odeonAirlines.controller;

import com.example.odeonAirlines.controller.model.CityDTO;
import com.example.odeonAirlines.service.ReadCityService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ReadCityControllerTest {

    @InjectMocks
    private ReadCityController readCityController;

    @Mock
    private ReadCityService readCityService;

    @Test
    public void getCities() {
        //given
        CityDTO cityDTO = CityDTO.builder()
                .cityName("cityName")
                .airportCode("airportCode")
                .airportName("airportName")
                .build();

        Mockito.when(readCityService.getCities()).thenReturn(List.of(cityDTO));
        //when
        List<CityDTO> result = readCityController.getCities();
        //then
        assertEquals(List.of(cityDTO), result);
    }

}