package com.khoa.AirportServerAPI.airline;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.khoa.AirportServerAPI.aircraft.Aircraft;
import com.khoa.AirportServerAPI.flight.Flight;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "airline")
public class Airline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private String code; // Example: "AC" for Air Canada

    @OneToMany(mappedBy = "airline", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Aircraft> aircraft = new HashSet<>();

    @OneToMany(mappedBy = "airline", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Flight> flights = new HashSet<>();

    // Constructors
    public Airline() {}

    public Airline(String name, String code) {
        this.name = name;
        this.code = code;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public Set<Aircraft> getAircraft() {
        return aircraft;
    }
    public void setAircraft(Set<Aircraft> aircraft) {
        this.aircraft = aircraft;
    }

    public Set<Flight> getFlights() {
        return flights;
    }
    public void setFlights(Set<Flight> flights) {
        this.flights = flights;
    }

    // Relationship helpers
    public void addAircraft(Aircraft aircraft) {
        this.aircraft.add(aircraft);
        aircraft.setAirline(this);
    }

    public void removeAircraft(Aircraft aircraft) {
        this.aircraft.remove(aircraft);
        aircraft.setAirline(null);
    }

    public void addFlight(Flight flight) {
        this.flights.add(flight);
        flight.setAirline(this);
    }

    public void removeFlight(Flight flight) {
        this.flights.remove(flight);
        flight.setAirline(null);
    }
}

