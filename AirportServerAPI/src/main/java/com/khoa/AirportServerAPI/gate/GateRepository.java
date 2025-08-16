//Name: Khoa Pham
//Project: Final Sprint (Airport-Server-API)
//Date: 08/15/2025
package com.khoa.AirportServerAPI.gate;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GateRepository extends JpaRepository<Gate, Long> {
    List<Gate> findByAirportId(Long airportId); 
    List<Gate> findByAirportIdAndIsDepartureGate(Long airportId, boolean isDepartureGate); 
}

