//Name: Khoa Pham
//Project: Final Sprint (Airport-Server-API)
//Date: 08/15/2025
package com.khoa.AirportServerAPI.airline;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineRepository extends JpaRepository<Airline, Long> {

    Optional<Airline> findByCode(String code);

}

