//Name: Khoa Pham
//Project: Final Sprint (Airport-Server-API)
//Date: 08/15/2025

package com.khoa.AirportServerAPI.airport;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AirportService {

    private final AirportRepository airportRepository;

    @Autowired
    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

    public Optional<Airport> getAirportById(Long id) {
        return airportRepository.findById(id);
    }

    public Airport createAirport(Airport airport) {
        return airportRepository.save(airport);
    }

    public Airport updateAirport(Long id, Airport updatedAirport) {
        return airportRepository.findById(id).map(airport -> {
            airport.setName(updatedAirport.getName());
            airport.setCode(updatedAirport.getCode());
            airport.setCity(updatedAirport.getCity());
            airport.setAircraft(updatedAirport.getAircraft());
            return airportRepository.save(airport);
        }).orElseThrow(() -> new EntityNotFoundException("Airport with ID " + id + " not found."));
    }

    public void deleteAirport(Long id) {
        if (!airportRepository.existsById(id)) {
            throw new EntityNotFoundException("Airport with ID " + id + " does not exist.");
        }
        airportRepository.deleteById(id);
    }
}


