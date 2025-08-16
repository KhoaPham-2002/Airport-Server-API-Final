package com.khoa.AirportServerAPI.airline;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirlineService {

    private final AirlineRepository airlineRepository;

    @Autowired
    public AirlineService(AirlineRepository airlineRepository) {
        this.airlineRepository = airlineRepository;
    }

    // Get all airlines
    public List<Airline> getAllAirlines() {
        return airlineRepository.findAll();
    }

    // Get airline by ID
    public Optional<Airline> getAirlineById(Long id) {
        return airlineRepository.findById(id);
    }

    // Get airline by code
    public Optional<Airline> getAirlineByCode(String code) {
        return airlineRepository.findByCode(code);
    }

    // Create a new airline
    public Airline createAirline(Airline airline) {
        return airlineRepository.save(airline);
    }

    // Update an existing airline
    public Airline updateAirline(Long id, Airline updatedAirline) {
        return airlineRepository.findById(id)
                .map(airline -> {
                    airline.setName(updatedAirline.getName());
                    airline.setCode(updatedAirline.getCode());
                    return airlineRepository.save(airline);
                })
                .orElseThrow(() -> new RuntimeException("Airline not found with ID: " + id));
    }

    // Delete an airline by ID
    public void deleteAirline(Long id) {
        airlineRepository.deleteById(id);
    }
}

