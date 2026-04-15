package com.ias.ejercicio_reactiva.flight_booking;

public class Flight {

    private String id;
    private String origin;
    private String destination;
    private Integer capacity;
    private Integer availableSeats;

    public Flight(String id, String origin, String destination, Integer capacity, Integer availableSeats) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.capacity = capacity;
        this.availableSeats = availableSeats;
    }

    public String getId() {
        return id;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }
}
