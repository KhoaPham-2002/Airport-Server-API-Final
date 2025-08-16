//Name: Khoa Pham
//Project: Final Sprint (Airport-Server-API)
//Date: 08/15/2025

package com.khoa.AirportServerAPI.aircraft;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.khoa.AirportServerAPI.airport.Airport;
import com.khoa.AirportServerAPI.airport.AirportRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AircraftService {

    private final AircraftRepository aircraftRepository;
    private final AirportRepository airportRepository;

    public AircraftService(AircraftRepository aircraftRepository, AirportRepository airportRepository) {
        this.aircraftRepository = aircraftRepository;
        this.airportRepository = airportRepository;
    }

    public List<Aircraft> getAllAircraft() {
        return aircraftRepository.findAll();
    }

    public Optional<Aircraft> getAircraftById(Long id) {
        return aircraftRepository.findById(id);
    }

    public Aircraft createAircraft(Aircraft aircraft) {
        if (aircraft.getAirports() != null) {
            var fullAirports = aircraft.getAirports().stream()
                    .map(a -> airportRepository.findById(a.getId())
                            .orElseThrow(() -> new EntityNotFoundException("Airport with ID " + a.getId() + " not found")))
                    .collect(java.util.stream.Collectors.toSet());
            aircraft.setAirports(fullAirports);
        }
        return aircraftRepository.save(aircraft);
    }

    public Aircraft updateAircraft(Long id, Aircraft updatedAircraft) {
        Optional<Aircraft> optionalAircraft = aircraftRepository.findById(id);

        if (optionalAircraft.isPresent()) {
            Aircraft aircraft = optionalAircraft.get();
            aircraft.setType(updatedAircraft.getType());
            aircraft.setAirline(updatedAircraft.getAirline());
            aircraft.setNumberOfPassengers(updatedAircraft.getNumberOfPassengers());
            return aircraftRepository.save(aircraft);
        } else {
            throw new EntityNotFoundException("Aircraft with ID " + id + " not found.");
        }
    }

    public void deleteAircraft(Long id) {
        aircraftRepository.deleteById(id);
    }

    public Aircraft addAirportToAircraft(Long aircraftId, Long airportId) {
        Aircraft aircraft = aircraftRepository.findById(aircraftId)
                .orElseThrow(() -> new EntityNotFoundException("Aircraft not found"));

        Airport airport = airportRepository.findById(airportId)
                .orElseThrow(() -> new EntityNotFoundException("Airport not found"));

        aircraft.getAirports().add(airport);
        return aircraftRepository.save(aircraft);
    }
}

