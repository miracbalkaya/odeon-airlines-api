package com.example.odeonAirlines.repository;

import com.example.odeonAirlines.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {


    @Query("SELECT f FROM Flight f WHERE f.departureAirportCode = :departureAirportCode AND f.departureTime BETWEEN :startTime AND :endTime")
    List<Flight> findFirstByDepartureAirportCodeAndBetweenDepartureTimeAndNow(String departureAirportCode, LocalDateTime startTime, LocalDateTime endTime);

    @Query("SELECT f FROM Flight f WHERE f.arrivalAirportCode = :arrivalAirportCode " +
            "AND f.departureTime BETWEEN :startTime AND :endTime")
    List<Flight> findFirstByArrivalAirportCodeAndBetweenDepartureTimeAndNow(String arrivalAirportCode, LocalDateTime startTime, LocalDateTime endTime);


    List<Flight> findByDepartureCity(String departureCity);

}
