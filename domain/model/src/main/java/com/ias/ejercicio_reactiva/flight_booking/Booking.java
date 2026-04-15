package com.ias.ejercicio_reactiva.flight_booking;

public class Booking {

    private Long id;
    private String flightId;
    private String passengerName;

    public Booking(Long id, String flightId, String passengerName) {
        this.id = id;
        this.flightId = flightId;
        this.passengerName = passengerName;
    }

    public Long getId() {
        return id;
    }

    public String getFlightId() {
        return flightId;
    }

    public String getPassengerName() {
        return passengerName;
    }
}
