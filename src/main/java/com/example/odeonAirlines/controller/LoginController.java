package com.example.odeonAirlines.controller;

import com.example.odeonAirlines.controller.model.LoginRequestDTO;
import com.example.odeonAirlines.controller.model.LoginResponse;
import com.example.odeonAirlines.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users/login")
@RequiredArgsConstructor
public class LoginController {

    private final AuthenticationService authenticationServiceImpl;

    @PostMapping
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequestDTO request) {
        return ResponseEntity.ok(authenticationServiceImpl.login(request));
    }
}
