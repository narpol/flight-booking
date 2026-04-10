package com.ias.ejercicio_reactiva.flight_booking.exception;

public class FlightNotFoundException extends RuntimeException {
    public FlightNotFoundException(String id) {
        super("Flight Not Found: " + id);
    }
}
