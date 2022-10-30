package com.example.Airline_api_lab.repositories;

import com.example.Airline_api_lab.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Long> {
}
