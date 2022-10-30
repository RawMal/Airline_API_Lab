package com.example.Airline_api_lab.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Column
    private String phoneNumber;
    @ManyToMany
    @JoinTable(
            name = "flights_passengers",
            joinColumns = {@JoinColumn(name = "passenger_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "flight_id", nullable = false)}
    )
    @JsonIgnoreProperties({"passengers"})
    private List<Flight> flights;

    public Passenger(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.flights = new ArrayList<>();
    }

    public Passenger(){}

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }
}






