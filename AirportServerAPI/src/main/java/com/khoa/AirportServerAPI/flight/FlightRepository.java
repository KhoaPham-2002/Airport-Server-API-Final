//Name: Khoa Pham
//Project: Final Sprint (Airport-Server-API)
//Date: 08/15/2025
package com.khoa.AirportServerAPI.flight;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    Optional<Flight> findByFlightNumber(String flightNumber);

    List<Flight> findByAirlineId(Long airlineId);

    List<Flight> findByDepartureAirportId(Long airportId);

    List<Flight> findByArrivalAirportId(Long airportId);

    List<Flight> findByScheduledDepartureBetween(LocalDateTime start, LocalDateTime end);
}

