package com.example.odeonAirlines.service.Impl;

import com.example.odeonAirlines.controller.model.LoginRequestDTO;
import com.example.odeonAirlines.controller.model.LoginResponse;
import com.example.odeonAirlines.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final TokenServiceImpl tokenServiceImpl;

    public LoginResponse login(LoginRequestDTO request) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        String token = tokenServiceImpl.generateToken(request.getUsername());
        LoginResponse loginResponse = LoginResponse.builder()
                .token(String.format("Bearer %s", token))
                .roles(authenticate.getAuthorities().stream().map(Object::toString).collect(Collectors.toList()))
                .build();
        return loginResponse;
    }
}
