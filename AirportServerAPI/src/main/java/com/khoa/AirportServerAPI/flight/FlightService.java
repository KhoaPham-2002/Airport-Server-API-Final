//Name: Khoa Pham
//Project: Final Sprint (Airport-Server-API)
//Date: 08/15/2025
package com.khoa.AirportServerAPI.flight;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService {

    private final FlightRepository flightRepository;

    @Autowired
    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Optional<Flight> getFlightById(Long id) {
        return flightRepository.findById(id);
    }

    public Optional<Flight> getFlightByNumber(String flightNumber) {
        return flightRepository.findByFlightNumber(flightNumber);
    }

    public List<Flight> getFlightsByAirline(Long airlineId) {
        return flightRepository.findByAirlineId(airlineId);
    }

    public List<Flight> getFlightsByDepartureAirport(Long airportId) {
        return flightRepository.findByDepartureAirportId(airportId);
    }

    public List<Flight> getFlightsByArrivalAirport(Long airportId) {
        return flightRepository.findByArrivalAirportId(airportId);
    }

    public List<Flight> getFlightsBetweenDates(LocalDateTime start, LocalDateTime end) {
        return flightRepository.findByScheduledDepartureBetween(start, end);
    }

    public Flight addFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public Flight updateFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);
    }
}

