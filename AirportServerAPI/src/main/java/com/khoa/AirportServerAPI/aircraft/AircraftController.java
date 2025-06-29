//Name: Khoa Pham
//Project: Midterm Sprint (Airport-Server-API)
//Date: 06/29/2025

package com.khoa.AirportServerAPI.aircraft;

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

import com.khoa.AirportServerAPI.airport.AirportRepository;

@RestController
@CrossOrigin
@RequestMapping("/aircraft")
public class AircraftController {

    private final AircraftService aircraftService;

    @Autowired
    private AircraftRepository aircraftRepository;

    @Autowired
    private AirportRepository airportRepository;
    public AircraftController(AircraftService aircraftService) {
        this.aircraftService = aircraftService;
    }

    @GetMapping
    public List<Aircraft> getAllAircraft() {
        return aircraftService.getAllAircraft();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aircraft> getAircraftById(@PathVariable Long id) {
        Optional<Aircraft> aircraft = aircraftService.getAircraftById(id);
        return aircraft.map(ResponseEntity::ok)
                       .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Aircraft createAircraft(@RequestBody Aircraft aircraft) {
        return aircraftService.createAircraft(aircraft);
    }

    @PutMapping("/{aircraftId}/airport/{airportId}")
    public ResponseEntity<Aircraft> assignAirportToAircraft(
            @PathVariable Long aircraftId,
            @PathVariable Long airportId) {

        Optional<Aircraft> aircraftOpt = aircraftRepository.findById(aircraftId);
        Optional<com.khoa.AirportServerAPI.airport.Airport> airportOpt = airportRepository.findById(airportId);

        if (aircraftOpt.isEmpty() || airportOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Aircraft aircraft = aircraftOpt.get();
        com.khoa.AirportServerAPI.airport.Airport airport = airportOpt.get();

        aircraft.getAirports().add(airport);
        aircraftRepository.save(aircraft);

        return ResponseEntity.ok(aircraft);
    }


    @DeleteMapping("/{id}")
    public void deleteAircraft(@PathVariable Long id) {
        aircraftService.deleteAircraft(id);
    }
}
