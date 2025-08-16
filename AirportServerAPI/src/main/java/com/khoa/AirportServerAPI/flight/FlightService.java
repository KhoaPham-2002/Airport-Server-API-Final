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

    // Get all flights
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    // Get a flight by ID
    public Optional<Flight> getFlightById(Long id) {
        return flightRepository.findById(id);
    }

    // Get a flight by flight number
    public Optional<Flight> getFlightByNumber(String flightNumber) {
        return flightRepository.findByFlightNumber(flightNumber);
    }

    // Get flights for a specific airline
    public List<Flight> getFlightsByAirline(Long airlineId) {
        return flightRepository.findByAirlineId(airlineId);
    }

    // Get flights departing from a specific airport
    public List<Flight> getFlightsByDepartureAirport(Long airportId) {
        return flightRepository.findByDepartureAirportId(airportId);
    }

    // Get flights arriving at a specific airport
    public List<Flight> getFlightsByArrivalAirport(Long airportId) {
        return flightRepository.findByArrivalAirportId(airportId);
    }

    // Get flights scheduled between two dates
    public List<Flight> getFlightsBetweenDates(LocalDateTime start, LocalDateTime end) {
        return flightRepository.findByScheduledDepartureBetween(start, end);
    }

    // Add a new flight
    public Flight addFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    // Update a flight
    public Flight updateFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    // Delete a flight by ID
    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);
    }
}

