//Name: Khoa Pham
//Project: Midterm Sprint (Airport-Server-API)
//Date: 06/29/2025

package com.khoa.AirportServerAPI.city;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.khoa.AirportServerAPI.airport.Airport;
import com.khoa.AirportServerAPI.passenger.Passenger;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class City {

    @Id
    @SequenceGenerator(name = "city_sequence", sequenceName = "city_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "city_sequence")
    private long id;

    private String name;
    private String state;
    private long population;

    @OneToMany(mappedBy = "city")
    @JsonIgnoreProperties("city")
    private List<Airport> airports;

    @OneToMany(mappedBy = "city")
    @JsonIgnore
    private List<Passenger> passengers;

    // Constructors 
    public City() {}

    public City(long id, String name, String state, long population) {
        this.id = id;
        this.name = name;
        this.state = state;
        this.population = population;
    }

    // Getters and Setters 
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public List<Airport> getAirports() {
        return airports;
    }

    public void setAirports(List<Airport> airports) {
        this.airports = airports;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }
}
