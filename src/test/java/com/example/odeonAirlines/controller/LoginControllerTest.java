package com.example.odeonAirlines.controller;

import com.example.odeonAirlines.controller.model.LoginRequestDTO;
import com.example.odeonAirlines.controller.model.LoginResponse;
import com.example.odeonAirlines.service.AuthenticationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class LoginControllerTest {

    @InjectMocks
    private LoginController loginController;

    @Mock
    private AuthenticationService authenticationServiceImpl;


    @Test
    public void testLogin() {
        //given
        LoginResponse loginResponse = LoginResponse.builder()
                .token("token")
                .roles(List.of("role"))
                .build();
        Mockito.when(authenticationServiceImpl.login(Mockito.any(LoginRequestDTO.class))).thenReturn(loginResponse);
        LoginRequestDTO loginRequestDTO = LoginRequestDTO.builder()
                .username("username")
                .password("password")
                .build();
        //when
        LoginResponse result = loginController.login(loginRequestDTO).getBody();
        //then

        assertEquals(loginResponse, result);
    }
}