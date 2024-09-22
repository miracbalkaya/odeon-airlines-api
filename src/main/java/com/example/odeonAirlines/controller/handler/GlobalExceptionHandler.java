package com.example.odeonAirlines.controller.handler;

import com.example.odeonAirlines.controller.model.ErrorResponseDTO;
import com.example.odeonAirlines.exception.CustomException;
import com.example.odeonAirlines.exception.DepartureTimeConflictException;
import com.example.odeonAirlines.exception.InvalidCredentialsException;
import com.example.odeonAirlines.exception.LandingTimeConflictException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler(DepartureTimeConflictException.class)
    public ResponseEntity<ErrorResponseDTO> handleDepartureTimeConflictException(DepartureTimeConflictException ex) {
        log.error("DepartureTimeConflictException: {}", ex.getMessage());
        ErrorResponseDTO errorResponse = new ErrorResponseDTO(ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(LandingTimeConflictException.class)
    public ResponseEntity<ErrorResponseDTO> handleLandingTimeConflictException(LandingTimeConflictException ex) {
        log.error("LandingTimeConflictException: {}", ex.getMessage());
        ErrorResponseDTO errorResponse = new ErrorResponseDTO(ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponseDTO> handleCustomException(CustomException ex) {
        log.error("CustomException: {}", ex.getMessage());
        ErrorResponseDTO errorResponse = new ErrorResponseDTO(ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleGlobalException(Exception ex) {
        log.error("Exception: {}", ex.getMessage());
        ErrorResponseDTO errorResponse = new ErrorResponseDTO(String.format("An unexpected error occurred %s", ex.getMessage()));
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<ErrorResponseDTO> handleInvalidCredentialsException(InvalidCredentialsException ex) {
        log.error("InvalidCredentialsException: {}", ex.getMessage());
        ErrorResponseDTO errorResponse = new ErrorResponseDTO(ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErrorResponseDTO> handleBadCredentialsException(BadCredentialsException ex) {
        ErrorResponseDTO errorResponse = new ErrorResponseDTO("username or password is incorrect");
        log.error("BadCredentialsException: {}", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
    }

}
