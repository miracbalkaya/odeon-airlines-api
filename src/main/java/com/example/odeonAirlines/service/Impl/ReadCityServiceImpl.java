package com.example.odeonAirlines.service.Impl;

import com.example.odeonAirlines.controller.model.CityDTO;
import com.example.odeonAirlines.repository.AirportRepository;
import com.example.odeonAirlines.service.ReadCityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReadCityServiceImpl implements ReadCityService {

    private final AirportRepository airportRepository;

    @Override
    public List<CityDTO> getCities() {
        return airportRepository.findAll()
                .stream()
                .map(airport -> {
                    CityDTO cityDTO = new CityDTO();
                    cityDTO.setCityName(airport.getCityName());
                    cityDTO.setAirportCode(airport.getAirportCode());
                    cityDTO.setAirportName(airport.getAirportName());
                    return cityDTO;
                })
                .toList();
    }
}
