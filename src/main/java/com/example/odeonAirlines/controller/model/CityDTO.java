package com.example.odeonAirlines.controller.model;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CityDTO {

    private String cityName;
    private String airportCode;
    private String airportName;
}
