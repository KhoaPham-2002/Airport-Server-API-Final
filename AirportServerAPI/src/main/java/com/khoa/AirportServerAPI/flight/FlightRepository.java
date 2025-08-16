package com.khoa.AirportServerAPI.flight;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    // Find a flight by its flight number
    Optional<Flight> findByFlightNumber(String flightNumber);

    // Find all flights for a specific airline
    List<Flight> findByAirlineId(Long airlineId);

    // Find all flights departing from a specific airport
    List<Flight> findByDepartureAirportId(Long airportId);

    // Find all flights arriving at a specific airport
    List<Flight> findByArrivalAirportId(Long airportId);

    // Find all flights scheduled between two dates
    List<Flight> findByScheduledDepartureBetween(LocalDateTime start, LocalDateTime end);
}

