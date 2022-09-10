package com.example.Airline_api_lab.models;

public class Booking {

    private long passengerId;

    public Booking(long passengerId){ this.passengerId = passengerId;}

    public Booking() {
    }

    public long getPassengerId() {return passengerId;}

    public void setPassengerId(long passengerId){this.passengerId = passengerId;}
    }

