package com.example.Airline_api_lab.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "passengers")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email_address")
    private String emailAddress;

    @ManyToMany
    @JoinTable(
            name = "flights_passengers",
            joinColumns = {@JoinColumn(name = "passenger_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "passenger_id", nullable = false)}
    )
    @JsonIgnoreProperties({"passengers"})
    private List<Flight> flights;

    public Passenger(String name, String emailAddress, List<Flight> flights) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.flights = new ArrayList<>();
    }

    public Passenger() {

    }

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

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }
}






