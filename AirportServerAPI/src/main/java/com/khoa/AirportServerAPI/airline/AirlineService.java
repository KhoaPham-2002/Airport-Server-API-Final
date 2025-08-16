//Name: Khoa Pham
//Project: Final Sprint (Airport-Server-API)
//Date: 08/15/2025
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

    public List<Airline> getAllAirlines() {
        return airlineRepository.findAll();
    }

    public Optional<Airline> getAirlineById(Long id) {
        return airlineRepository.findById(id);
    }

    public Optional<Airline> getAirlineByCode(String code) {
        return airlineRepository.findByCode(code);
    }

    public Airline createAirline(Airline airline) {
        return airlineRepository.save(airline);
    }

    public Airline updateAirline(Long id, Airline updatedAirline) {
        return airlineRepository.findById(id)
                .map(airline -> {
                    airline.setName(updatedAirline.getName());
                    airline.setCode(updatedAirline.getCode());
                    return airlineRepository.save(airline);
                })
                .orElseThrow(() -> new RuntimeException("Airline not found with ID: " + id));
    }

    public void deleteAirline(Long id) {
        airlineRepository.deleteById(id);
    }
}

