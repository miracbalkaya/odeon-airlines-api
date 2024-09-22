package com.example.odeonAirlines.controller;

import com.example.odeonAirlines.controller.model.UserRequestDTO;
import com.example.odeonAirlines.controller.model.UserResponseDTO;
import com.example.odeonAirlines.service.SaveUserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class SignupControllerTest {

    @InjectMocks
    private SignupController signupController;

    @Mock
    private SaveUserService saveUserService;


    @Test
    public void signup() {
        //given
        UserResponseDTO userResponseDTO = UserResponseDTO.builder()
                .username("username")
                .firstName("firstName")
                .lastName("lastName")
                .city("city")
                .roles(Set.of("role"))
                .build();

        Mockito.when(saveUserService.save(Mockito.any(UserRequestDTO.class))).thenReturn(userResponseDTO);
        UserRequestDTO userRequestDTO = UserRequestDTO.builder()
                .username("username")
                .password("password")
                .firstName("firstName")
                .lastName("lastName")
                .city("city")
                .build();

        //when
        UserResponseDTO result = signupController.signup(userRequestDTO).getBody();
        //then
        assertEquals(userResponseDTO, result);
    }


}