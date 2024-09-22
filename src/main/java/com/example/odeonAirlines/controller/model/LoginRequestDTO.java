package com.example.odeonAirlines.controller.model;


import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestDTO {

    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
