//Name: Khoa Pham
//Project: Final Sprint (Airport-Server-API)
//Date: 08/15/2025

package com.khoa.AirportServerAPI.passenger;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/passenger")
public class PassengerController {

    private final PassengerService passengerService;

    @Autowired
    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @GetMapping
    public List<Passenger> getAllPassengers() {
        return passengerService.getAllPassengers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Passenger> getPassengerById(@PathVariable Long id) {
        Optional<Passenger> passenger = passengerService.getPassengerById(id);
        return passenger.map(ResponseEntity::ok)
                        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Passenger createPassenger(@RequestBody Passenger passenger) {
        return passengerService.createPassenger(passenger);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Passenger> updatePassenger(@PathVariable Long id, @RequestBody Passenger passenger) {
        Passenger updatedPassenger = passengerService.updatePassenger(id, passenger);
        return (updatedPassenger != null)
                ? ResponseEntity.ok(updatedPassenger)
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public void deletePassenger(@PathVariable Long id) {
        passengerService.deletePassenger(id);
    }

    @PutMapping("/{passengerId}/aircraft/{aircraftId}")
    public ResponseEntity<Passenger> addAircraftToPassenger(@PathVariable Long passengerId, @PathVariable Long aircraftId) {
        Passenger updatedPassenger = passengerService.addAircraftToPassenger(passengerId, aircraftId);
        return (updatedPassenger != null)
                ? ResponseEntity.ok(updatedPassenger)
                : ResponseEntity.notFound().build();
    }
}
