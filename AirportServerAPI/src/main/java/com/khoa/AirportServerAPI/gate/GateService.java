//Name: Khoa Pham
//Project: Final Sprint (Airport-Server-API)
//Date: 08/15/2025
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

    public List<Gate> getAllGates() {
        return (List<Gate>) gateRepository.findAll();
    }

    public List<Gate> getGatesByAirportId(Long airportId) {
        return gateRepository.findByAirportId(airportId);
    }

    public List<Gate> getGatesByAirportAndType(Long airportId, boolean isDepartureGate) {
        return gateRepository.findByAirportIdAndIsDepartureGate(airportId, isDepartureGate);
    }

    public Optional<Gate> getGateById(Long id) {
        return gateRepository.findById(id);
    }

    public Gate saveGate(Gate gate) {
        return gateRepository.save(gate);
    }

    public void deleteGate(Long id) {
        gateRepository.deleteById(id);
    }
}

