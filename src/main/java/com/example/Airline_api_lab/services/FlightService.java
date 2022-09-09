package com.example.Airline_api_lab.services;

import com.example.Airline_api_lab.models.Flight;
import com.example.Airline_api_lab.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    public List<Flight> getAllFlights(){ return flightRepository.findAll();}

    public Optional<Flight> getFlightById(Long id){ return flightRepository.findById(id);}

    public Flight addNewFlight(Flight flight){
        flightRepository.save(flight);
        return flight;
    }
}
