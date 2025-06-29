//Name: Khoa Pham
//Project: Midterm Sprint (Airport-Server-API)
//Date: 06/29/2025

package com.khoa.AirportServerAPI.passenger;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.khoa.AirportServerAPI.aircraft.Aircraft;
import com.khoa.AirportServerAPI.aircraft.AircraftRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PassengerService {

    private final PassengerRepository passengerRepository;
    private final AircraftRepository aircraftRepository;

    public PassengerService(PassengerRepository passengerRepository, AircraftRepository aircraftRepository) {
        this.passengerRepository = passengerRepository;
        this.aircraftRepository = aircraftRepository;
    }

    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    public Optional<Passenger> getPassengerById(Long id) {
        return passengerRepository.findById(id);
    }

    public Passenger createPassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    public Passenger updatePassenger(Long id, Passenger updatedPassenger) {
        return passengerRepository.findById(id).map(passenger -> {
            passenger.setFirstName(updatedPassenger.getFirstName());
            passenger.setLastName(updatedPassenger.getLastName());
            passenger.setPhoneNumber(updatedPassenger.getPhoneNumber());
            passenger.setCity(updatedPassenger.getCity());
            passenger.setAircraft(updatedPassenger.getAircraft());
            return passengerRepository.save(passenger);
        }).orElseThrow(() -> new EntityNotFoundException("Passenger not found with id: " + id));
    }

    public void deletePassenger(Long id) {
        passengerRepository.deleteById(id);
    }

    public Passenger addAircraftToPassenger(Long passengerId, Long aircraftId) {
        Passenger passenger = passengerRepository.findById(passengerId)
                .orElseThrow(() -> new EntityNotFoundException("Passenger not found"));
        Aircraft aircraft = aircraftRepository.findById(aircraftId)
                .orElseThrow(() -> new EntityNotFoundException("Aircraft not found"));

        Set<Aircraft> aircraftSet = passenger.getAircraft();
        aircraftSet.add(aircraft);
        passenger.setAircraft(aircraftSet);
        return passengerRepository.save(passenger);
    }
}

