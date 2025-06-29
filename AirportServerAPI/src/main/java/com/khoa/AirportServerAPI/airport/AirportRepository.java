//Name: Khoa Pham
//Project: Midterm Sprint (Airport-Server-API)
//Date: 06/29/2025

package com.khoa.AirportServerAPI.airport;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {
}
