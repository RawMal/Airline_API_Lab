package com.example.Airline_api_lab.services;

import com.example.Airline_api_lab.models.Passenger;
import com.example.Airline_api_lab.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {

    @Autowired
    PassengerRepository passengerRepository;

    public List<Passenger> getAllPassengers(){ return passengerRepository.findAll();}

    public Optional<Passenger> getPassengerById(Long id){ return passengerRepository.findById(id);}

    public Passenger addNewPassenger(Passenger passenger){
        passengerRepository.save(passenger);
        return passenger;
    }
}
