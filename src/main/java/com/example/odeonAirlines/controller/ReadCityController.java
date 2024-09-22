package com.example.odeonAirlines.controller;


import com.example.odeonAirlines.controller.model.CityDTO;
import com.example.odeonAirlines.service.ReadCityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
@RequiredArgsConstructor
public class ReadCityController {

    private final ReadCityService readCityService;

    @GetMapping
    public List<CityDTO> getCities() {
        return readCityService.getCities();
    }
}
