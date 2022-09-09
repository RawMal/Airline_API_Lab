package com.example.Airline_api_lab.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "flights")
public class Flight {

    @Id
    @GeneratedValue

}
