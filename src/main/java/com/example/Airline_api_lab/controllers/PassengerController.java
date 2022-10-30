package com.example.Airline_api_lab.controllers;

import com.example.Airline_api_lab.models.Passenger;
import com.example.Airline_api_lab.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/passengers")
public class PassengerController {

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    PassengerService passengerService;

    @GetMapping
    public ResponseEntity<List<Passenger>> getAllPassengers(){
        return new ResponseEntity<>(passengerService.getAllPassengers(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Passenger> getPassengerById(@PathVariable long id){
        return new ResponseEntity<>(passengerService.getPassengerById(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Passenger> addPassenger(@RequestBody Passenger passenger){
        Passenger savedPassenger = passengerService.addPassenger(passenger);
        return new ResponseEntity<>(savedPassenger,HttpStatus.CREATED);
    }



}
