//Name: Khoa Pham
//Project: Final Sprint (Airport-Server-API)
//Date: 08/15/2025
package com.khoa.AirportServerAPI.gate;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.khoa.AirportServerAPI.aircraft.Aircraft;
import com.khoa.AirportServerAPI.airport.Airport;
import com.khoa.AirportServerAPI.flight.Flight;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "gates")
public class Gate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String gateNumber;

    @Column(nullable = false)
    private String terminal;

    @Column(nullable = false)
    private boolean isDepartureGate;

    @ManyToOne
    @JoinColumn(name = "airport_id", nullable = false)
    private Airport airport;

    @ManyToOne
    @JoinColumn(name = "aircraft_id")
    private Aircraft aircraft;

    @OneToMany(mappedBy = "departureGate", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Flight> departureFlights = new HashSet<>();

    @OneToMany(mappedBy = "arrivalGate", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Flight> arrivalFlights = new HashSet<>();

    public Gate() {}

    public Gate(String gateNumber, String terminal, Airport airport, boolean isDepartureGate) {
        this.gateNumber = gateNumber;
        this.terminal = terminal;
        this.airport = airport;
        this.isDepartureGate = isDepartureGate;
    }

    public Long getId() { 
        return id; 
    }

    public void setId(Long id) { 
        this.id = id; 
    }

    public String getGateNumber() { 
        return gateNumber; 
    }

    public void setGateNumber(String gateNumber) { 
        this.gateNumber = gateNumber; 
    }

    public String getTerminal() { 
        return terminal; 
    }

    public void setTerminal(String terminal) { 
        this.terminal = terminal; 
    }

    public boolean isDepartureGate() { 
        return isDepartureGate; 
    }

    public void setDepartureGate(boolean departureGate) { 
        this.isDepartureGate = departureGate; 
    }

    public Airport getAirport() { 
        return airport; 
    }

    public void setAirport(Airport airport) { 
        this.airport = airport; 
    }

    public Aircraft getAircraft() { 
        return aircraft; 
    }

    public void setAircraft(Aircraft aircraft) { 
        this.aircraft = aircraft; 
    }

    public Set<Flight> getDepartureFlights() { 
        return departureFlights; 
    }

    public void setDepartureFlights(Set<Flight> departureFlights) { 
        this.departureFlights = departureFlights; 
    }

    public Set<Flight> getArrivalFlights() { 
        return arrivalFlights; 
    }

    public void setArrivalFlights(Set<Flight> arrivalFlights) { 
        this.arrivalFlights = arrivalFlights; 
    }
}