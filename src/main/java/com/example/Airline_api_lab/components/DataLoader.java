package com.example.Airline_api_lab.components;

import com.example.Airline_api_lab.models.Flight;
import com.example.Airline_api_lab.models.Passenger;
import com.example.Airline_api_lab.repositories.FlightRepository;
import com.example.Airline_api_lab.repositories.PassengerRepository;
import com.example.Airline_api_lab.services.FlightService;
import com.example.Airline_api_lab.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FlightRepository flightRepository;
    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    FlightService flightService;
    @Autowired
    PassengerService passengerService;

    @Override
    public void run(ApplicationArguments args) throws Exception {


        Passenger passenger1 = new Passenger("john","091234");
        Passenger passenger2 = new Passenger("james","0912213434");
        Passenger passenger3 = new Passenger("alan","091212343234");

        passengerRepository.saveAll(Arrays.asList(passenger1,passenger2,passenger3));

        Flight flight1 = new Flight("London",100,"12/12/22","16:00");
        Flight flight2 = new Flight("Paris",150,"10/08/22","02:00");
        Flight flight3 = new Flight("New York",120,"25/01/23","19:00");

        flightRepository.saveAll(Arrays.asList(flight1,flight2,flight3));

//        flightService.addPassengerToFlight(3l,1l);
//        flightService.addPassengerToFlight(3l,2l);
//
//        flightRepository.saveAll(Arrays.asList(flight1,flight2,flight3));




    }
}
