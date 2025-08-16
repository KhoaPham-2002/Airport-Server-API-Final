//Name: Khoa Pham
//Project: Final Sprint (Airport-Server-API)
//Date: 08/15/2025
package com.khoa.AirportServerAPI.flight;

import java.time.LocalDateTime;

import com.khoa.AirportServerAPI.aircraft.Aircraft;
import com.khoa.AirportServerAPI.airline.Airline;
import com.khoa.AirportServerAPI.airport.Airport;
import com.khoa.AirportServerAPI.gate.Gate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String flightNumber;

    @ManyToOne
    @JoinColumn(name = "airline_id", nullable = false)
    private Airline airline;

    @ManyToOne
    @JoinColumn(name = "aircraft_id", nullable = false)
    private Aircraft aircraft;

    @ManyToOne
    @JoinColumn(name = "departure_airport_id", nullable = false)
    private Airport departureAirport;

    @ManyToOne
    @JoinColumn(name = "departure_gate_id")
    private Gate departureGate;

    @ManyToOne
    @JoinColumn(name = "arrival_gate_id")
    private Gate arrivalGate;

    @ManyToOne
    @JoinColumn(name = "arrival_airport_id", nullable = false)
    private Airport arrivalAirport;

    @Column(nullable = false)
    private LocalDateTime scheduledDeparture;

    @Column(nullable = false)
    private LocalDateTime scheduledArrival;

    private String status; 
    public Flight() {}

    public Flight(String flightNumber, Airline airline, Aircraft aircraft,
                  Airport departureAirport, Airport arrivalAirport,
                  LocalDateTime scheduledDeparture, LocalDateTime scheduledArrival) {
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.aircraft = aircraft;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.scheduledDeparture = scheduledDeparture;
        this.scheduledArrival = scheduledArrival;
        this.status = "SCHEDULED";
    }

    public Long getId() { 
        return id; 
    }

    public void setId(Long id) { 
        this.id = id; 
    }

    public String getFlightNumber() { 
        return flightNumber; 
    }

    public void setFlightNumber(String flightNumber) { 
        this.flightNumber = flightNumber; 
    }

    public Airline getAirline() { 
        return airline; 
    }

    public void setAirline(Airline airline) { 
        this.airline = airline; 
    }

    public Aircraft getAircraft() { 
        return aircraft; 
    }

    public void setAircraft(Aircraft aircraft) { 
        this.aircraft = aircraft; 
    }

    public Airport getDepartureAirport() { 
        return departureAirport; 
    }

    public void setDepartureAirport(Airport departureAirport) { 
        this.departureAirport = departureAirport; 
    }

    public Airport getArrivalAirport() { 
        return arrivalAirport; 
    }

    public void setArrivalAirport(Airport arrivalAirport) { 
        this.arrivalAirport = arrivalAirport; 
    }

    public Gate getDepartureGate() {
        return departureGate;
    }

    public void setDepartureGate(Gate departureGate) {
        this.departureGate = departureGate;
    }

public Gate getArrivalGate() {
    return arrivalGate;
}

public void setArrivalGate(Gate arrivalGate) {
    this.arrivalGate = arrivalGate;
}


    public LocalDateTime getScheduledDeparture() { 
        return scheduledDeparture; 
    }

    public void setScheduledDeparture(LocalDateTime scheduledDeparture) { 
        this.scheduledDeparture = scheduledDeparture; 
    }

    public LocalDateTime getScheduledArrival() { 
        return scheduledArrival; 
    }

    public void setScheduledArrival(LocalDateTime scheduledArrival) { 
        this.scheduledArrival = scheduledArrival; 
    }

    public String getStatus() { 
        return status; 
    }

    public void setStatus(String status) { 
        this.status = status; 
    }
}
