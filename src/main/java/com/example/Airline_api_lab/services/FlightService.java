package com.example.Airline_api_lab.services;

import com.example.Airline_api_lab.models.Flight;
import com.example.Airline_api_lab.models.Passenger;
import com.example.Airline_api_lab.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerService passengerService;

    public List<Flight> getAllFlights(){ return flightRepository.findAll();}

    public Flight getFlightById(Long id){ return flightRepository.findById(id).get();}

    public Flight addNewFlight(Flight flight){
        flightRepository.save(flight);
        return flight;
    }

    public Flight addPassengerToFlight(long flightId, long passengerId){
        Flight flight = flightRepository.findById(flightId).get();
        Passenger passenger = passengerService.getPassengerById(passengerId);
        List<Passenger> passengers = flight.getPassengers();
        passengers.add(passenger);
        flight.setPassengers(passengers);
        flightRepository.save(flight);
        return flight;

    }

}
