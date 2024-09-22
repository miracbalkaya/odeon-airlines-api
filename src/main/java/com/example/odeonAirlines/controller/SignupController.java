package com.example.odeonAirlines.controller;

import com.example.odeonAirlines.controller.model.UserRequestDTO;
import com.example.odeonAirlines.controller.model.UserResponseDTO;
import com.example.odeonAirlines.service.SaveUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users/signup")
@RequiredArgsConstructor
public class SignupController {

    private final SaveUserService saveUserService;

    @PostMapping
    public ResponseEntity<UserResponseDTO> signup(@RequestBody @Valid UserRequestDTO userRequestDTO) {
        UserResponseDTO savedUser = saveUserService.save(userRequestDTO);
        return ResponseEntity.ok(savedUser);
    }
}
