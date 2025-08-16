//Name: Khoa Pham
//Project: Final Sprint (Airport-Server-API)
//Date: 08/15/2025
package com.khoa.AirportServerAPI.gate;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/gates")
public class GateController {

    private final GateService gateService;

    public GateController(GateService gateService) {
        this.gateService = gateService;
    }

    // Get all gates
    @GetMapping
    public List<Gate> getAllGates() {
        return gateService.getAllGates();
    }

    // Get gates by airport ID
    @GetMapping("/airport/{airportId}")
    public List<Gate> getGatesByAirport(@PathVariable Long airportId) {
        return gateService.getGatesByAirportId(airportId);
    }

    // Get gates by airport ID and type (departure or arrival)
    @GetMapping("/airport/{airportId}/type")
    public List<Gate> getGatesByAirportAndType(@PathVariable Long airportId,
                                                @RequestParam boolean isDepartureGate) {
        return gateService.getGatesByAirportAndType(airportId, isDepartureGate);
    }

    // Get gate by ID
    @GetMapping("/{id}")
    public Optional<Gate> getGateById(@PathVariable Long id) {
        return gateService.getGateById(id);
    }

    // Create a new gate
    @PostMapping
    public Gate createGate(@RequestBody Gate gate) {
        return gateService.saveGate(gate);
    }

    // Update an existing gate
    @PutMapping("/{id}")
    public Gate updateGate(@PathVariable Long id, @RequestBody Gate gate) {
        gate.setId(id);
        return gateService.saveGate(gate);
    }

    // Delete a gate
    @DeleteMapping("/{id}")
    public void deleteGate(@PathVariable Long id) {
        gateService.deleteGate(id);
    }
}

