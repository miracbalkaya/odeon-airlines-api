package com.example.odeonAirlines.service;

import com.example.odeonAirlines.controller.model.UserRequestDTO;
import com.example.odeonAirlines.controller.model.UserResponseDTO;

public interface SaveUserService {
    UserResponseDTO save(UserRequestDTO userRequestDTO);
}
