package com.example.odeonAirlines.service;

import com.example.odeonAirlines.controller.model.LoginRequestDTO;
import com.example.odeonAirlines.controller.model.LoginResponse;

public interface AuthenticationService {

    LoginResponse login(LoginRequestDTO request);
}
