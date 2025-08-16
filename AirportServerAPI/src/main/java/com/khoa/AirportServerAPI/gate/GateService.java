package com.khoa.AirportServerAPI.gate;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class GateService {

    private final GateRepository gateRepository;

    public GateService(GateRepository gateRepository) {
        this.gateRepository = gateRepository;
    }

    // Get all gates
    public List<Gate> getAllGates() {
        return (List<Gate>) gateRepository.findAll();
    }

    // Get gates by airport ID
    public List<Gate> getGatesByAirportId(Long airportId) {
        return gateRepository.findByAirportId(airportId);
    }

    // Get gates by airport ID and whether it is a departure gate
    public List<Gate> getGatesByAirportAndType(Long airportId, boolean isDepartureGate) {
        return gateRepository.findByAirportIdAndIsDepartureGate(airportId, isDepartureGate);
    }

    // Get gate by ID
    public Optional<Gate> getGateById(Long id) {
        return gateRepository.findById(id);
    }

    // Create or update a gate
    public Gate saveGate(Gate gate) {
        return gateRepository.save(gate);
    }

    // Delete a gate
    public void deleteGate(Long id) {
        gateRepository.deleteById(id);
    }
}

