package com.example.Airline_api_lab.services;

import com.example.Airline_api_lab.models.Passenger;
import com.example.Airline_api_lab.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {

    @Autowired
    PassengerRepository passengerRepository;

    public List<Passenger> getAllPassengers(){
        return  passengerRepository.findAll();
    }

    public Passenger getPassengerById(long id){
        return passengerRepository.findById(id).get();
    }

    public Passenger addPassenger(Passenger passenger){
        passengerRepository.save(passenger);
        return passenger;
    }
}