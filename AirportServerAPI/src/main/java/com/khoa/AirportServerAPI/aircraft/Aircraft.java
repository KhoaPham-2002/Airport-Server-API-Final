//Name: Khoa Pham
//Project: Final Sprint (Airport-Server-API)
//Date: 08/15/2025

package com.khoa.AirportServerAPI.aircraft;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.khoa.AirportServerAPI.airline.Airline;
import com.khoa.AirportServerAPI.airport.Airport;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Aircraft {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private int numberOfPassengers;

    @ManyToOne
    @JoinColumn(name = "airline_id") // Foreign key column in Aircraft table
    @JsonIgnore // Avoid recursion when serializing JSON
    private Airline airline;

    @ManyToMany
    @JoinTable(
            name = "aircraft_airport",
            joinColumns = @JoinColumn(name = "aircraft_id"),
            inverseJoinColumns = @JoinColumn(name = "airport_id")
    )
    @JsonIgnoreProperties("aircraft")
    private Set<Airport> airports;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public Set<Airport> getAirports() {
        return airports;
    }

    public void setAirports(Set<Airport> airports) {
        this.airports = airports;
    }
}
